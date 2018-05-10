package students.logic;

import students.logic.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public class MySqlStudentDao implements StudentDao {

	private Connection connection;
	private Map<String, PreparedStatement> preparedStatements = new HashMap<String, PreparedStatement>();
	private final String SELECT_STUDENT = "SELECT ID, NAME, SURNAME FROM Student WHERE ID = ?";
	private final String UPDATE_STUDENT = "UPDATE Student SET name = ?, surname = ? WHERE ID = ?";
	private final String DELETE_STUDENT = "DELETE FROM Student WHERE ID = ?";
	private final String LIST_STUDENT = "SELECT id, name, surname FROM Student";

	protected PreparedStatement getPreparedStatement(String sql) throws DAOException {
		//connection = null;
		PreparedStatement preparedStatement = preparedStatements.get(sql);
		if(preparedStatement == null){//connection == null && 
			connection = DbUtil.getConnection();
			try {
				preparedStatement = connection.prepareStatement(sql);
			} catch (SQLException e) {
				throw new DAOException("preparedStatement was not created :", e);
			}
	    	}
		if (preparedStatement != null && connection != null) {
				preparedStatements.put(sql, preparedStatement);
		}
		return preparedStatement;
        }

	public String schedule(int i) throws DAOException {
		ResultSet rs = null;
		PreparedStatement ps = null;
		DAOException ex = null;
		String str = null;
		
		try {
			ps = getPreparedStatement(SELECT_STUDENT);
			Student student = new Student();
			student.setId(i);
			ps.setInt(1, student.getId());
			rs = ps.executeQuery();
			rs.first();
				int b = rs.getInt("id");
				String s1 = rs.getString("name");
				String s2 = rs.getString("surname");
				String s3 = String.valueOf(b);
				str = "Name: " + s1 + " Surname: " +  s2;
		} catch(SQLException e) {
			throw new DAOException("Can not assign a student :", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("ResultSet was not closed :", e);
				} 
			}
		}
		return str;
	}

	public List<Student> getAll() throws DAOException {
		List<Student> list = new ArrayList<Student>();
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			ps = getPreparedStatement(LIST_STUDENT);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
				st.setSurname(rs.getString("surname"));
				list.add(st);
			}
		} catch(SQLException e) {
			throw new DAOException("Can not get a list of students :", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("ResultSet was not closed :", e);
				} 
			}
		}
		return list;
	}

	public void update(Student student) throws DAOException {
		PreparedStatement ps = null;

		try {
		ps = getPreparedStatement(UPDATE_STUDENT);
		ps.setString(1, student.getName());
		ps.setString(2, student.getSurname());
		ps.setInt(3, student.getId());
		int rowsAffected = ps.executeUpdate();

		} catch(SQLException e) {
			throw new DAOException("Can not update student :", e);
		} 
	}

	public void delete(Student student) throws DAOException {
		PreparedStatement ps = null;
		String str = null;

		try {
		ps = getPreparedStatement(DELETE_STUDENT);
		ps.setInt(1, student.getId());
		int rowsAffected = ps.executeUpdate();
 
		} catch(SQLException e) {
			throw new DAOException("can not delete student :", e);
		}
	}

	public void closeUtil() throws DAOException {
		DAOException ex = null;
		for (Iterator<PreparedStatement> i = preparedStatements.values().iterator(); i.hasNext(); ) { 
			PreparedStatement preparedStatement = i.next();
			if (preparedStatement != null) {
				try { 
					preparedStatement.close();
				} catch (SQLException e) {
					ex = new DAOException("preparedStatement or connection was not closed :", e);
				}
			} else {
				if (connection != null) {
					closeConnection();
				}
			}
		}

		if (ex != null){
			throw ex;
		}
	}

	protected void closeConnection() throws DAOException {
		try{
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DAOException("connection was not closed :", e);
                }
	}

	public void close() throws DAOException {
		try {
			closeUtil();
		} catch(DAOException e) {
			throw new DAOException("preparedStatement or connection was not closed :", e);
		}
	}
}

