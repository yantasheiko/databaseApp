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

	//@AfterMethod
	//public void tearDown() throws Exception {
       // 	stDao.close();
	//	subDao.close();
	//}



	@Test
	public void testFindAll() throws Exception {
  		List<Student> list;
		List<Subject> listSub;
  		list = studentService.findAll();
		listSub = subjectService.findAll();
  		Assert.assertNotNull(list);
  		Assert.assertTrue(list.size() > 0);
		Assert.assertNotNull(listSub);
  		Assert.assertTrue(listSub.size() > 0);
	}

	@Test
	public void testfindById() throws Exception {
		String str;
		int i = 1;
		str = subjectService.findById(i).toString();
		Assert.assertNotNull(str);
		Assert.assertTrue(str.length() >= 11);
		i++;
		str = studentService.findById(i).toString();
		Assert.assertNotNull(str);
		Assert.assertTrue(str.length() >= 29);
	}

	@Test
	public void testUpdate() throws Exception {
		Student st = new Student("Richard", "Prayor", 1);
		Subject sub = new Subject("Russian", 7);
		studentService.update(st);
		subjectService.update(sub);
			Student stud = new Student();
			Subject subject = new Subject();
			List<Student> list = studentService.findAll();
	   		Iterator<Student> i = list.iterator();
         		if (i.hasNext()) {
				stud = i.next();
				Assert.assertEquals(stud.getName(), "Richard");
				Assert.assertEquals(stud.getSurname(), "Prayor");
            		}
			List<Subject> listSub = subjectService.findAll();
			Iterator<Subject> iter = listSub.iterator();
         		for (int a = 0; iter.hasNext();) {
				subject = iter.next();
            		}
			Assert.assertEquals(subject.getSubject(), "Russian");
			Assert.assertEquals(subject.getId().toString(), "7");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelete() throws Exception {
		Student st = new Student();
		Subject sub = new Subject();
		st.setId(5);
		sub.setId(8);
		studentService.delete(st.getId());
		subjectService.delete(sub.getId());
			Student stud = new Student();
			List<Student> list = studentService.findAll();
			Iterator<Student> i = list.iterator();
			Assert.assertEquals(4, list.size());
			for (int a = 1; a <= 5; a++){
				stud = i.next();
				Assert.assertEquals(stud.getId().toString(), String.valueOf(a));
			}
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
