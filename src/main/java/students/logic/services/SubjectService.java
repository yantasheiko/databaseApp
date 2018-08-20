package students.logic.services;

import java.util.List;

import students.logic.dao.*;
import students.logic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SubjectService {

    private static SubjectDao subjectDao;
 
    public SubjectService() {
        subjectDao = new SubjectDao();
    }

    public void update(Subject entity) {
        subjectDao.update(entity);
    }
 
    public Subject findById(Integer id) {
        Subject sub = subjectDao.findById(id);
        return sub;
    }

    public void delete(Integer id) {
        Subject sub = subjectDao.findById(id);
        subjectDao.delete(sub);
    }

    public List<Subject> findAll() {
        List<Subject> subjects = subjectDao.findAll();
        return subjects;
    }

    public void close(){
	subjectDao.close();
    }

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
	this.subjectDao = subjectDao;
    }

}
