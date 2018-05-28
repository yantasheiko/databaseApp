package students.logic;

import students.logic.*;
import java.util.List;
import java.sql.*;

public interface SubjectDao{

    public void update(Subject subject) throws DAOException;

    public void delete(Subject subject) throws DAOException;

    public List<Subject> getAll() throws DAOException;

    public String schedule(int i) throws DAOException;

    public void close() throws DAOException;

}