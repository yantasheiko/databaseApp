package students.logic;

import students.logic.*;
import java.util.List;
import java.sql.*;

public interface StudentDao {

    public List<Student> getAll() throws DAOException;

    public void update(Student student) throws DAOException;

    public void delete(Student student) throws DAOException;

    public String schedule(int i) throws DAOException;

    public void close() throws DAOException;

}