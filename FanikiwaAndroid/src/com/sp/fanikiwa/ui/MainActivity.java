package com.sp.fanikiwa.ui;
 
import com.sp.fanikiwa.ui.R;
import java.util.Locale;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
//import android.support.v4.app.ActionBarDrawerToggle;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarActivity;

import android.widget.ListView;

public class MainActivity extends ActionBarActivity  {
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 setContentView(R.layout.activity_main); 
		 
		 getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
//	    switch (item.getItemId()) {
//	        case R.id.action_search:
//	            openSearch();
//	            return true;
//	        case R.id.action_settings:
//	            openSettings();
//	            return true;
//	        default:
	            return super.onOptionsItemSelected(item);
//	    }
	}
	private void openSearch()
	{
		Toast.makeText(this, "Search not implemented", Toast.LENGTH_LONG).show();
	}
	private void openSettings()
	{
		Toast.makeText(this, "Settings not implemented", Toast.LENGTH_LONG).show();
	}
	
	
	  
}
