package com.snapsell.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListingAdapter extends BaseAdapter {
	private Context context;
	private int count;
 
	public ListingAdapter(Context context) {
		this.context = context;
		count = 0;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.grid_item_category, null);
 
			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.gridItemCategoryTextTitle);
			String text = Globals.getListings().get(count).getTitle();
			textView.setText(text);
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.gridItemListingImageMain);
			Bitmap bitmap = Globals.getListings().get(count).getImage();
			imageView.setImageBitmap(bitmap);
			textView.setTag(count);
			
			// increment the count.
			count++;
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		if (Globals.getListings() == null)
			return 0;
		return Globals.getListings().size();
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}