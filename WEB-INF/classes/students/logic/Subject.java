package students.logic;


public class Subject {
	private Integer id;

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
		return "Subject: " + subject;
	}
}

