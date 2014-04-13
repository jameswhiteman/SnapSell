package com.snapsell.activities;

public class Message
{
	private User sender;
	private String date;
	private String text;
	
	public Message(User sender, String date, String text)
	{
		this.sender = sender;
		this.date = date;
		this.text = text;
	}
	
	// Setters
	public void setSender(User sender)
	{
		this.sender = sender;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	// Getters
	public User getSender()
	{
		return sender;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getText()
	{
		return text;
	}
}
