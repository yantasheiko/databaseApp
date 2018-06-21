package students.logic;



import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
        @Column(name = "id")
	private Integer id;


	@Column(name = "name")
	private String name;


	@Column(name = "surname")
	private String surname;

	@ManyToMany
    	@JoinTable (name="student_subject",
        	joinColumns=@JoinColumn (name="student_id"),
        	inverseJoinColumns=@JoinColumn(name="subject_id"))
    	private List<Subject> subjects;
	
	public Student(){
	}

	public Student(String name, String surname, int id) {
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	public Integer getId() {

		return id;

	}


	public void setId(int id) {

		this.id = id;

	}


	public String getName() {

		return name;

	}


	public void setName(String name) {

		this.name = name;

	}


	public String getSurname() {

		return surname;

	}


	public void setSurname(String surname) {

		this.surname = surname;

	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
 	}

	public String toString(){
		return "Name: " + this.name +" Surname: " + this.surname;
	}
}

