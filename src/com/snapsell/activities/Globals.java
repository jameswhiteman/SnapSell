package com.snapsell.activities;

import java.util.List;

public class Globals
{
	private static List<Listing> listings;
	
	public static void setListings(List<Listing> listings)
	{
		Globals.listings = listings;
	}
	
	public static List<Listing> getListings()
	{
		return listings;
	}
}
