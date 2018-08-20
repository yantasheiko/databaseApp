package students.logic.dao;

import students.logic.dto.*;
import java.util.List;
import java.sql.*;

public interface StudentDaoImpl {

    public List<Student> findAll();

    public void update(Student entity);

    public void delete(Student entity);

    public Student findById(Integer id);

}