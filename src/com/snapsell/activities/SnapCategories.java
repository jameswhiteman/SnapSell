package com.snapsell.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.TextView;

public class SnapCategories extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_categories);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.snap_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menuLoginSettings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        	
        	// Set up the switch.
        	Switch buy = (Switch)rootView.findViewById(R.id.categoriesSwitchBuy);
        	buy.setTextOff("Buy");
        	buy.setTextOn("Sell");
			
			// Set up the grid view
			GridView gridView = (GridView)rootView.findViewById(R.id.categoriesGridOptions);
			gridView.setAdapter(new CategoryAdapter(rootView.getContext()));
			gridView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id)
				{
					TextView text = (TextView)v.findViewById(R.id.gridItemCategoryTextTitle);
					String i = text.getTag().toString();
					Intent intent = new Intent(getActivity(), SnapListings.class);
					intent.putExtra("option", i);
					startActivity(intent);
				}
			});
			
			return rootView;
        }
    }

}