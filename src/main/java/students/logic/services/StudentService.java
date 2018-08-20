package students.logic.services;

import java.util.List;

import students.logic.dao.*;
import students.logic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class StudentService {

    private static StudentDao studentDao;
 
    public StudentService() {
        studentDao = new StudentDao();
    }

    public void update(Student entity) {
        studentDao.update(entity);
    }
 
    public Student findById(Integer id) {
        Student st = studentDao.findById(id);
        return st;
    }

    public void delete(Integer id) {
        Student st = studentDao.findById(id);
        studentDao.delete(st);
    }

    public List<Student> findAll() {
        List<Student> students = studentDao.findAll();
        return students;
    }

    public void close(){
	studentDao.close();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
	this.studentDao = studentDao;
    }
}
