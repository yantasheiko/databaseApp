package students.logic;

import java.util.List;

import students.logic.*;

public class StudentService {

    private static StudentDao stDao;
 
    public StudentService() {
        stDao = new StudentDao();
    }

    public void update(Student entity) {
        stDao.update(entity);
    }
 
    public Student findById(Integer id) {
        Student st = stDao.findById(id);
        return st;
    }

    public void delete(Integer id) {
        Student st = stDao.findById(id);
        stDao.delete(st);
    }

    public List<Student> findAll() {
        List<Student> students = stDao.findAll();
        return students;
    }

    public StudentDao stDao() {
        return stDao;
    }
}
