package com.xworkz.StudentEnrollApp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_table")
@NamedQueries({ @NamedQuery(name = "GetRecordByMail", query = "SELECT student FROM StudentEnrollEntity student WHERE student.email=:em ") })
public class StudentEnrollEntity implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "STUDENT_ID")
	private int id;
	@Column(name = "STUDENT_NAME")
	private String name;
	@Column(name = "STUDENT_EMAIL")
	private String email;
	@Column(name = "STUDENT_PASSWORD")
	private String password;

	public StudentEnrollEntity() {
		super();
	}

	public StudentEnrollEntity(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentEnrollEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
