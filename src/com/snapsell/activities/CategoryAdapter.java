package com.snapsell.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {
	private Context context;
	private int count;
 
	public CategoryAdapter(Context context) {
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
			textView.setText("Test Category");
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.gridItemCategoryImageMain);
			textView.setTag(count);
			
			switch (count)
			{
			case 0:
				imageView.setImageResource(R.drawable.category_books);
				textView.setText("Books");
				break;
			case 1:
				imageView.setImageResource(R.drawable.category_electronics);
				textView.setText("Electronics");
				break;
			case 2:
				imageView.setImageResource(R.drawable.category_entertainment);
				textView.setText("Entertainment");
				break;
			case 3:
				imageView.setImageResource(R.drawable.category_home);
				textView.setText("Home");
				break;
			case 4:
				imageView.setImageResource(R.drawable.category_sports);
				textView.setText("Sporting");
				break;
			case 5:
				imageView.setImageResource(R.drawable.category_womens_clothing);
				textView.setText("Women's Clothes");
				break;
			case 6:
				imageView.setImageResource(R.drawable.category_mens_clothing);
				textView.setText("Men's Clothes");
				break;
			default:
				imageView.setImageResource(R.drawable.category_other);
				textView.setText("Other");
				break;
			}
			count++;
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return 8;
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