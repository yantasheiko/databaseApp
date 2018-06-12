package students.logic;

import java.util.List;

import students.logic.*;

public class SubjectService {

    private static SubjectDao subDao;
 
    public SubjectService() {
        subDao = new SubjectDao();
    }

    public void update(Subject entity) {
        subDao.update(entity);
    }
 
    public Subject findById(Integer id) {
        Subject sub = subDao.findById(id);
        return sub;
    }

    public void delete(Integer id) {
        Subject sub = subDao.findById(id);
        subDao.delete(sub);
    }

    public List<Subject> findAll() {
        List<Subject> subjects = subDao.findAll();
        return subjects;
    }

    public SubjectDao stDao() {
        return subDao;
    }
}
