package com.snapsell.activities;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class JsonParser
{
	public List<Listing> parseListings(String json)
	{
		ArrayList<Listing> listings = new ArrayList<Listing>();
		try
		{
			JSONObject object = new JSONObject(json);
			JSONArray rawListings = object.getJSONArray("listings");
			for (int i = 0; i < rawListings.length(); i++)
			{
				String rawListing = rawListings.getString(i);
				Listing listing = parseListing(rawListing);
				listings.add(listing);
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return listings;
	}
	
	public Listing parseListing(String json)
	{
		Listing listing = null;
		try
		{
			JSONObject rawListing = new JSONObject(json);
			String id = rawListing.getString("_id");
			String rawImage = rawListing.getString("picture");
			Bitmap image = parseImage(rawImage);
			//String rawUser = rawListing.getString("user");
			//User user = parseUser(rawUser);
//			String title = rawListing.getString("title");
//			String description = rawListing.getString("description");
			String title = "Poop";
			String description = "A gooey substance you don't wanna touch.";
			String rawMessages = rawListing.getString("messages");
			boolean bought = rawListing.getBoolean("bought");
			List<Message> messages = parseMessages(rawMessages);
			listing = new Listing(id, title, description, image, null, bought, messages);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return listing;
	}
	
	public User parseUser(String json)
	{
		User user = null;
		try
		{
			JSONObject rawUser = new JSONObject(json);
			String id = rawUser.getString("_id");
			String firstName = rawUser.getString("name");
			String lastName = "";//rawUser.getString("lastName");
			user = new User(id, firstName, lastName);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public List<Message> parseMessages(String json)
	{
		ArrayList<Message> messages = new ArrayList<Message>();
		try
		{
			JSONArray rawMessages = new JSONArray(json);
			for (int i = 0; i < rawMessages.length(); i++)
			{
				String rawMessage = rawMessages.getString(i);
				Message message = parseMessage(rawMessage);
				messages.add(message);
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return messages;
	}
	
	public Message parseMessage(String json)
	{
		Message message = null;
		try
		{
			JSONObject rawMessage = new JSONObject(json);
			String rawUser = rawMessage.getString("user");
			User user = parseUser(rawUser);
			String date = rawMessage.getString("date");
			String text = rawMessage.getString("text");
			message = new Message(user, date, text);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return message;
	}
	
	public Bitmap parseImage(String json)
	{
		Bitmap picture = null;
		try
		{
			String requestUrl = "http://www.empireonline.com/images/uploaded/cage1.jpg";
			URL url = new URL(requestUrl);
			URLConnection conn = url.openConnection();
			picture = BitmapFactory.decodeStream(conn.getInputStream());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return picture;
	}
}
