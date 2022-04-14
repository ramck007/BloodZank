
public class BloodZData {
	String uname , aadhar , email , pin , bloodgrp , gender , number , location , address , date , willing ;

	
	
	public BloodZData() {
		super();

	}

	public BloodZData(String uname, String aadhar, String email, String pin, String bloodgrp, String gender,
			String number, String location, String address, String date, String willing) {
		super();
		this.uname = uname;
		this.aadhar = aadhar;
		this.email = email;
		this.pin = pin;
		this.bloodgrp = bloodgrp;
		this.gender = gender;
		this.number = number;
		this.location = location;
		this.address = address;
		this.date = date;
		this.willing = willing;
	}

	public BloodZData(String email, String pin) {
		super();
		this.email = email;
		this.pin = pin;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWilling() {
		return willing;
	}

	public void setWilling(String willing) {
		this.willing = willing;
	}
	
	
	
}
