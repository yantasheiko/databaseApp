package students.logic;


import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
        @Column(name = "id")
	private Integer id;


	@Column(name = "subject")
	private String subject;

	@ManyToMany
    	@JoinTable(name="student_subject",
        	joinColumns=@JoinColumn(name="subject_id"), 
        	inverseJoinColumns=@JoinColumn(name="student_id"))
    	private List<Student> students;

	public Subject() {
	}

	public Subject(String subject, int id) {
		this.subject = subject;
		this.id = id;
	}

	public Integer getId() {

		return id;

	}


	public void setId(int id) {

		this.id = id;

	}


	public String getSubject() {

		return subject;

	}


	public void setSubject(String subject) {

		this.subject = subject;

	}



	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
 	}

	public String toString(){
		return "Subject: " + this.subject;
	}
}

