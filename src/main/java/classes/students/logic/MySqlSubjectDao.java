package students.logic;

import students.logic.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public class MySqlSubjectDao implements SubjectDao {

	private Connection connection;
	private Map<String, PreparedStatement> preparedStatements = new HashMap<String, PreparedStatement>();
	private final String SELECT_SUBJECT = "SELECT SUBJECT FROM SUBJECT WHERE ID = ?";
	private final String UPDATE_SUBJECT = "UPDATE Subject SET Subject = ? WHERE Id = ?";
	private final String DELETE_SUBJECT = "DELETE FROM SUBJECT WHERE ID = ?";
	private final String LIST_SUBJECT = "SELECT Id, Subject FROM SUBJECT";

	protected PreparedStatement getPreparedStatement(String sql) throws DAOException {
		PreparedStatement preparedStatement = preparedStatements.get(sql);
		if(preparedStatement == null){
			connection = DbUtil.getConnection();
			try {
				
				preparedStatement = connection.prepareStatement(sql);
			} catch (SQLException e) {
				throw new DAOException("preparedStatement was not create :", e);
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
			ps = getPreparedStatement(SELECT_SUBJECT);
			Subject subject = new Subject();
			subject.setId(i);
			ps.setInt(1, subject.getId());
			rs = ps.executeQuery();
			rs.first();
				str = rs.getString("subject");
		} catch(SQLException e) {
			throw new DAOException("Can not assign a subject :", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("ResultSet did not close :", e);
				}
			}
		}
		return str;
	}

	public void update(Subject subject) throws DAOException {
		PreparedStatement ps = null;

		try {
			ps = getPreparedStatement(UPDATE_SUBJECT);
			ps.setString(1, subject.getSubject());
			ps.setInt(2, subject.getId());
			int rowsAffected = ps.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("Can not update subject :", e);
		}
	}

	public void delete(Subject subject) throws DAOException {
		PreparedStatement ps = null;

		try {
		ps = getPreparedStatement(DELETE_SUBJECT);
		ps.setInt(1, subject.getId());
		int rowsAffected = ps.executeUpdate();
 
		} catch(SQLException e) {
			throw new DAOException("Can not delete subject :", e);
		}
	}

	public List<Subject> getAll() throws DAOException {
		PreparedStatement ps = null;
		List<Subject> list = new ArrayList<Subject>();
		ResultSet rs = null;

		try {
		ps = getPreparedStatement(LIST_SUBJECT);
		rs = ps.executeQuery();
		while (rs.next()) {
			Subject sub = new Subject();
			sub.setId(rs.getInt("id"));
			sub.setSubject(rs.getString("subject"));
			list.add(sub);
		}
		} catch(SQLException e) {
			throw new DAOException("Can not get a list of subject :", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("ResultSet did not close :", e);
				}
			}
		}
		return list;
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
