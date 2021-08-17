package com.xworkz.vaccination.dto;

public class RegisterDTO {
	private String username;
	private String email;
	private int otp;
	private String password;
	private String cpassword;
	private long phonenumber;
	private String vaccineType;

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "RegisterDTO [username=" + username + ", email=" + email + ", otp=" + otp + ", password=" + password
				+ ", cpassword=" + cpassword + ", phonenumber=" + phonenumber + ", vaccineType=" + vaccineType + "]";
	}
	
	

}
