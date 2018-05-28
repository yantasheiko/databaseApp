package students.logic;



import java.util.*;


public class Student {
	private Integer id;

	private String name;

	private String surname;
	
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
	public String toString(){
		return "Name: " + name +" Surname: " + surname;
	}
}

