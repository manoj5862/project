package com.xworkz.vaccination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vaccination_table")
public class RegisterEntity {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "OTP")
	private int otp;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "PHONENUMBER")
	private long phonenumber;
	@Column(name = "VACCINETYPE")
	private String vaccineType;

	public RegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterEntity(int id, String username, String email, int otp, String password, long phonenumber,
			String vaccineType) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.otp = otp;
		this.password = password;
		this.phonenumber = phonenumber;
		this.vaccineType = vaccineType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", username=" + username + ", email=" + email + ", otp=" + otp
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", vaccineType=" + vaccineType + "]";
	}

}
