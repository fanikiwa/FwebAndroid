package com.sp.fanikiwa.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.organizationendpoint.Organizationendpoint;
import com.sp.fanikiwa.entity.organizationendpoint.model.CollectionResponseOrganization;
import com.sp.fanikiwa.entity.organizationendpoint.model.Organization;
import com.sp.fanikiwa.entity.quoteEndpoint.QuoteEndpoint;
import com.sp.fanikiwa.entity.quoteEndpoint.model.CollectionResponseQuote;
import com.sp.fanikiwa.entity.quoteEndpoint.model.Quote;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class OrganizationsListActivity extends ListActivity {
	private TextView tv = null;
	private ArrayList<Map<String,String>> list = null;
	private SimpleAdapter adapter = null;
	private String[] from = { "name", "email" };
	private int[] to = { android.R.id.text1, android.R.id.text2 };
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("Organizations");
		tv.setGravity(Gravity.CENTER);
		getListView().addHeaderView(tv);
		new OrganizationsListAsyncTask(this).execute();
	}

	private class OrganizationsListAsyncTask extends AsyncTask<Void, Void, CollectionResponseOrganization>{
		  Context context;
		  private ProgressDialog pd;

		  public OrganizationsListAsyncTask(Context context) {
		    this.context = context;
		  }
		  
		  protected void onPreExecute(){ 
		     super.onPreExecute();
		          pd = new ProgressDialog(context);
		          pd.setMessage("Retrieving Organizations...");
		          pd.show();    
		  }

		  protected CollectionResponseOrganization doInBackground(Void... unused) {
			  CollectionResponseOrganization Organizations = null;
		    try {
		    	Organizationendpoint.Builder builder = new Organizationendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
		    	Organizationendpoint service =  builder.build();
		    	Organizations = service.listOrganization().execute();
		    } catch (Exception e) {
		      Log.d("Could not retrieve Organizations", e.getMessage(), e);
		    }
		    return Organizations;
		  }

		  protected void onPostExecute(CollectionResponseOrganization organizations) {
			  pd.dismiss();
		    // Do something with the result.
 			   ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			   List<Organization> _list = organizations.getItems();
				for (Organization organization : _list) {
					HashMap<String, String> item = new HashMap<String, String>();
					item.put("name", organization.getName());
					item.put("email", organization.getEmail());
					item.put("andress", organization.getAndress());
			 	    list.add(item);
				}
				adapter = new SimpleAdapter(OrganizationsListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
				setListAdapter(adapter);
		  }
		}
}
