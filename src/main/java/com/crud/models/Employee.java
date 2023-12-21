package com.crud.models;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employes")


public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	
@Column(name="first_name")
   @NotNull
private String firstName;
	 
	@Column(name="last_name")
	@NotNull
private String lastName;
	   @NotNull
	@Column(name="email")
private String Email;
	   private String image;
public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

public Employee() {
	super();
}

public Employee(String firstName, String lastName, String email, String image) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	Email = email;
	this.image = image;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lasttName) {
	this.lastName = lasttName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
