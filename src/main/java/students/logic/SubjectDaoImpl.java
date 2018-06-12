package students.logic;

import students.logic.*;
import java.util.List;
import java.sql.*;

public interface SubjectDaoImpl {

    public void update(Subject entity);

    public void delete(Subject entity);

    public List<Subject> findAll();

    public Subject findById(Integer id);

}