package com.snapsell.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

public class ListingsTask extends AsyncTask<String, Void, List<Listing>>
{
	private Activity currentActivity;
	
	public ListingsTask(Activity currentActivity)
	{
		this.currentActivity = currentActivity;
	}
	
	@Override
	protected List<Listing> doInBackground(String...ids)
	{
		List<Listing> listings = null;
		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet("http://google.com/mobile/listings");
			/*ArrayList<NameValuePair> postData = new ArrayList<NameValuePair>();
			NameValuePair id = new BasicNameValuePair("area", ids[0]);
			postData.add(id);
			get.setEntity(new UrlEncodedFormEntity(postData));
			HttpParams params = new DefaultedHttpParams();
			get.getParams();*/
			
			HttpResponse response = client.execute(get);
			//String json = EntityUtils.toString(response.getEntity());
			String json = "{\"listings\":[{\"picture\":\"\",\"bought\":false,\"user\":{\"name\":\"James\",\"_id\":\"83\"},\"_id\":\"534a64a42ab6228030fbaa43\",\"__v\":0,\"message\":[]},{\"picture\":\"\",\"bought\":false,\"user\":{\"name\":\"John\",\"_id\":\"29\"},\"_id\":\"534a64b72ab6228030fbaa44\",\"__v\":0,\"message\":[]},{\"picture\":\"\",\"bought\":false,\"user\":{\"name\":\"Chad\",\"_id\":\"928\",},\"_id\":\"534a64d52ab6228030fbaa45\",\"__v\":0,\"message\":[]}]}";
			JsonParser parser = new JsonParser();
			listings = parser.parseListings(json);
			System.out.println("JSON:" + json + ";");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listings;
	}
	
	@Override
	protected void onPostExecute(List<Listing> listings)
	{
		System.out.println("EAT A DICK HACKATHON! IT DIDN'T BREAK!");
		Intent intent = new Intent(currentActivity, SnapCategories.class);
		currentActivity.startActivity(intent);
	}
}
