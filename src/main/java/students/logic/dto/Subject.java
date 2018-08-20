package students.logic.dto;


import java.util.*;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

public class Subject {

	private Integer subjectId;


	private String subject;

    	private Set<Student> students;

	public Subject() {
	}

	public Subject(String subject, int subjectId) {
		this.subject = subject;
		this.subjectId = subjectId;
	}

	public Integer getSubjectId() {

		return subjectId;

	}


	public void setSubjectId(int subjectId) {

		this.subjectId = subjectId;

	}


	public String getSubject() {

		return subject;

	}


	public void setSubject(String subject) {

		this.subject = subject;

	}



	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
 	}

	public String toString(){
		return "Subject: " + this.subject;
	}
}

