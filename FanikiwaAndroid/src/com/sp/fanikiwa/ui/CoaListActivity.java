package com.sp.fanikiwa.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.coaendpoint.model.Coa;
import com.sp.fanikiwa.entity.coaendpoint.Coaendpoint;
import com.sp.fanikiwa.entity.coaendpoint.model.CollectionResponseCoa;
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

public class CoaListActivity extends ListActivity {
	private TextView tv = null;
	private ArrayList<Map<String,String>> list = null;
	private SimpleAdapter adapter = null;
	private String[] from = { "description" };
	private int[] to = { android.R.id.text1};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText("Chart Of Accounts");
		tv.setGravity(Gravity.CENTER);
		getListView().addHeaderView(tv);
		new CoaListAsyncTask(this).execute();
	}

	private class CoaListAsyncTask extends AsyncTask<Void, Void, CollectionResponseCoa>{
		  Context context;
		  private ProgressDialog pd;

		  public CoaListAsyncTask(Context context) {
		    this.context = context;
		  }
		  
		  protected void onPreExecute(){ 
		     super.onPreExecute();
		          pd = new ProgressDialog(context);
		          pd.setMessage("Retrieving Chart of Accounts...");
		          pd.show();    
		  }

		  protected CollectionResponseCoa doInBackground(Void... unused) {
			  CollectionResponseCoa Coas = null;
		    try {
		    	Coaendpoint.Builder builder = new Coaendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
		    	Coaendpoint service =  builder.build();
		    	Coas = service.listCoa().execute();
		    } catch (Exception e) {
		      Log.d("Could not retrieve Chart of Accounts", e.getMessage(), e);
		    }
		    return Coas;
		  }

		  protected void onPostExecute(CollectionResponseCoa coas) {
			  pd.dismiss();
		    // Do something with the result.
 			   ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			   List<Coa> _list = coas.getItems();
				for (Coa coa : _list) {
					HashMap<String, String> item = new HashMap<String, String>();
					item.put("description", coa.getDescription()); 
			 	    list.add(item);
				}
				adapter = new SimpleAdapter(CoaListActivity.this, list,android.R.layout.simple_list_item_2, from, to);
				setListAdapter(adapter);
		  }
		}
}
