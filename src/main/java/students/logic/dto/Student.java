package students.logic.dto;



import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

public class Student {

	private Integer studentId;


	private String name;


	private String surname;

    	private Set<Subject> subjects;

	public Student(){
	}

	public Student(String name, String surname, Integer studentId) {
		this.name = name;
		this.surname = surname;
		this.studentId = studentId;
	}

	public Integer getStudentId() {

		return studentId;

	}


	public void setStudentId(int studentId) {

		this.studentId = studentId;

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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
 	}

	public String toString(){
		return "Name: " + this.name +" Surname: " + this.surname;
	}
}

