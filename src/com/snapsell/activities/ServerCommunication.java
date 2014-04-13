package com.snapsell.activities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

public class ServerCommunication extends AsyncTask<String, Void, String>
{
	private DefaultHttpClient mHttpClient;


	public ServerCommunication() {
	    HttpParams params = new BasicHttpParams();
	    params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
	    mHttpClient = new DefaultHttpClient(params);
	}


	public void uploadUserPhoto(File image) {

	    try {
	    	URI url = new URI("http://10.55.3.27:3000/mobile/listing");
	        HttpPost httppost = new HttpPost(url);
	        
	        if (image == null)
	        	System.out.println("SPONGEBOB");
	        else
	        	System.out.println(image.toString());
	        
	        FileBody filebody = new FileBody(image);

	        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);  
	        multipartEntity.addPart("Title", new StringBody("Title"));
	        multipartEntity.addPart("Nick", new StringBody("Nick"));
	        multipartEntity.addPart("Email", new StringBody("Email"));
	        multipartEntity.addPart("Description", new StringBody("Poop"));
	        multipartEntity.addPart("Image", filebody);
	        httppost.setEntity(multipartEntity);

	        mHttpClient.execute(httppost, new PhotoUploadResponseHandler());

	    } catch (Exception e) {
	        Log.e(ServerCommunication.class.getName(), e.getLocalizedMessage(), e);
	    }
	}

	private class PhotoUploadResponseHandler implements ResponseHandler<Object> {

	    @Override
	    public Object handleResponse(HttpResponse response)
	            throws ClientProtocolException, IOException {

	        HttpEntity r_entity = response.getEntity();
	        String responseString = EntityUtils.toString(r_entity);
	        Log.d("UPLOAD", responseString);

	        return null;
	    }

	}

	@Override
	protected String doInBackground(String... files) {
		try
		{
		URL url = new URL("http://www.livingthegoodlifenaturally.com/wp-content/uploads/2014/01/Nicolas-Cage-Photo.jpg");
		URLConnection conn = url.openConnection();
		Bitmap pic = BitmapFactory.decodeStream(conn.getInputStream());
		String name = "/poop.png";
		/*
    ImageView view = new ImageView(v.getContext());
    view.setImageBitmap(pic);
	ServerCommunication comm = new ServerCommunication();
	FileOutputStream output = new FileOutputStream("poop.png");
	pic.compress(Bitmap.CompressFormat.PNG, 1, output);
	output.flush();
	output.close();
	file = new File("poop.png");*/
		String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
		String filename = extStorageDirectory + name;
		OutputStream outStream = null;

		File file = new File(filename);
		if (file.exists()) {
			file.delete();
			file = new File(filename);
			Log.e("file exist", filename);
		}
		// make a new bitmap from your file

		if (pic == null)
			System.out.println("craziness");
		else
			System.out.println("pirate-trove");
		outStream = new FileOutputStream(file);
		if (pic == null)
			System.out.println("Daniel");
		else
			System.out.println("Plainview");
		pic.compress(Bitmap.CompressFormat.PNG, 100, outStream);
		outStream.flush();
		outStream.close();
		uploadUserPhoto(file);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "done";
	}
}