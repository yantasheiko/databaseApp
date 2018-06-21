package src.test.java.ru.maven;

import org.testng.*;
import org.testng.annotations.*;
import students.logic.*;
import java.util.*;

public class TestDao {


	private StudentService studentService;
	private SubjectService subjectService;

	@BeforeMethod
	public void setUp() throws Exception {
		studentService = new StudentService();
		subjectService = new SubjectService();
	}

	@Test
	public void testStudentFindAll() throws Exception {
  		List<Student> list;
  		list = studentService.findAll();
  		Assert.assertNotNull(list);
	}

	@Test
	public void testSubjectFindAll() throws Exception {
		List<Subject> listSub;
		listSub = subjectService.findAll();
		Assert.assertNotNull(listSub);
	}

	@Test
	public void testSubjectFindById() throws Exception {
		int i = 1;
		Subject sub = (Subject) subjectService.findById(i);
		Assert.assertNotNull(sub);
	}

	@Test
	public void testStudentFindById() throws Exception {
		int i = 2;
		Student st = (Student) studentService.findById(i);
		Assert.assertNotNull(st);
	}

	@Test
	public void testStudentUpdate() throws Exception {
		Student st = new Student("Richard", "Prayor", 1);
		studentService.update(st);
			Student stud = new Student();
			List<Student> list = studentService.findAll();
	   		Iterator<Student> i = list.iterator();
         		if (i.hasNext()) {
				stud = i.next();
				Assert.assertEquals(stud.getName(), "Richard");
				Assert.assertEquals(stud.getSurname(), "Prayor");
            		}
	}

	@Test
	public void testSubjectUpdate() throws Exception {
		Subject sub = new Subject("Russian", 7);
		subjectService.update(sub);
			Subject subject = new Subject();
			List<Subject> listSub = subjectService.findAll();
			Iterator<Subject> iter = listSub.iterator();
         		for (int a = 0; iter.hasNext();) {
				subject = iter.next();
            		}
			Assert.assertEquals(subject.getSubject(), "Russian");
			Assert.assertEquals(subject.getId().toString(), "7");
	}

	@Test(expectedExceptions = { IllegalArgumentException.class, NoSuchElementException.class } )
	public void testStudentDelete() throws Exception {
		Student st = new Student();
		st.setId(5);
		studentService.delete(st.getId());
			Student stud = new Student();
			List<Student> list = studentService.findAll();
			Iterator<Student> i = list.iterator();
			Assert.assertEquals(4, list.size());
			for (int a = 1; a <= 5; a++){
				stud = i.next();
				Assert.assertEquals(stud.getId().toString(), String.valueOf(a));
			}
	}

	@Test(expectedExceptions = { IllegalArgumentException.class, NoSuchElementException.class } )
	public void testSubjectDelete() throws Exception {
		Subject sub = new Subject();
		sub.setId(8);
		subjectService.delete(sub.getId());
			Subject subject = new Subject();
			List<Subject> listSub = subjectService.findAll();
			Iterator<Subject> iter = listSub.iterator();
			Assert.assertEquals(7, listSub.size());
			for (int a = 1; a <= 8; a++){
				subject = iter.next();
				Assert.assertEquals(subject.getId().toString(), String.valueOf(a));
			}
	}

}
