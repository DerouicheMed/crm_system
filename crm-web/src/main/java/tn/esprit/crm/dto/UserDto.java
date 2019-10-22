package tn.esprit.crm.dto;

import java.time.LocalDateTime;

public class UserDto {
	
	private long id;
	private String username;
	private String password;
	private String email;
	private String phoneNumPrimary;
	private String phoneNumAlternative;
	private String address;
	private LocalDateTime lastLoggedAt;
	private boolean activated;
	private String companyName;
	private String companyType;
	private String firstname;
	private String lastname;
	private String cin;
	private LocalDateTime birthDate;
	private String type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumPrimary() {
		return phoneNumPrimary;
	}
	public void setPhoneNumPrimary(String phoneNumPrimary) {
		this.phoneNumPrimary = phoneNumPrimary;
	}
	public String getPhoneNumAlternative() {
		return phoneNumAlternative;
	}
	public void setPhoneNumAlternative(String phoneNumAlternative) {
		this.phoneNumAlternative = phoneNumAlternative;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDateTime getLastLoggedAt() {
		return lastLoggedAt;
	}
	public void setLastLoggedAt(LocalDateTime lastLoggedAt) {
		this.lastLoggedAt = lastLoggedAt;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
	
	
	
	
	

}
