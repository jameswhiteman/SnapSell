package com.snapsell.activities;

import java.util.List;

import android.graphics.Bitmap;

public class Listing
{
	private String id;
	private String title;
	private String description;
	private Bitmap image;
	private User user;
	private boolean bought;
	private List<Message> messages;
	
	public Listing(String id, String title, String description,
			Bitmap image, User user, boolean bought, List<Message> messages)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.user = user;
		this.bought = bought;
		this.messages = messages;
	}
	
	// Setters
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setImage(Bitmap image)
	{
		this.image = image;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public void setBought(boolean bought)
	{
		this.bought = bought;
	}
	
	public void setMessage(List<Message> messages)
	{
		this.messages = messages;
	}
	
	// Getters
	public String getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Bitmap getImage()
	{
		return image;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public boolean getBought()
	{
		return bought;
	}
	
	public List<Message> getMessages()
	{
		return messages;
	}
}
