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


	public String toString(){
		return "Subject: " + this.subject;
	}
}

