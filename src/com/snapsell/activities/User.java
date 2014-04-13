package com.snapsell.activities;

public class User
{
	private String id;
	private String firstName;
	private String lastName;
	
	public User(String id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Setters
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	// Getters
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
}
