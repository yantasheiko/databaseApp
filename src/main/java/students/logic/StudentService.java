package students.logic;

import java.util.List;

import students.logic.*;

public class StudentService {

    private static StudentDao stDao;
 
    public StudentService() {
        stDao = new StudentDao();
    }

    public void update(Student entity) {
        stDao.openCurrentSessionwithTransaction();
        stDao.update(entity);
        stDao.closeCurrentSessionwithTransaction();
    }
 
    public Student findById(Integer id) {
        stDao.openCurrentSession();
        Student st = stDao.findById(id);
        stDao.closeCurrentSession();
        return st;
    }

    public void delete(Integer id) {
        stDao.openCurrentSessionwithTransaction();
        Student st = stDao.findById(id);
        stDao.delete(st);
        stDao.closeCurrentSessionwithTransaction();
    }

    public List<Student> findAll() {
        stDao.openCurrentSession();
        List<Student> students = stDao.findAll();
        stDao.closeCurrentSession();
        return students;
    }

    public StudentDao stDao() {
        return stDao;
    }
}
