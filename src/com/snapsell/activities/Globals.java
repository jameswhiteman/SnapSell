package com.snapsell.activities;

import java.util.List;

public class Globals
{
	private static List<Listing> listings;
	public static final String URL_HOST = "http://54.186.137.197/";
	public static final String URL_GET_LISTINGS = "mobile/listings";
	public static final String URL_POST_LISTINGS = "mobile/listing";
	
	public static void setListings(List<Listing> listings)
	{
		Globals.listings = listings;
	}
	
	public static List<Listing> getListings()
	{
		return listings;
	}
}
