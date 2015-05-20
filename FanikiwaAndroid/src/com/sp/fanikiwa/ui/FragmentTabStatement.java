package com.sp.fanikiwa.ui;

import java.util.List;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.accountendpoint.Accountendpoint;
import com.sp.fanikiwa.entity.accountendpoint.model.CollectionResponseAccount;
import com.sp.fanikiwa.entity.accountendpoint.model.Account;
import com.sp.fanikiwa.entity.memberendpoint.Memberendpoint;
import com.sp.fanikiwa.entity.memberendpoint.model.Member;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentTabStatement extends Fragment {

	// variables declaration
	ListView listViewAccounts;
	private AdapterMyAccounts adapter = null;
	public static final String LOGIN_PREFERENCES = "LoginPrefs";
	public static final String USER_ID = "USER_ID"; 

	   

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab_myaccounts,
				container, false);

		listViewAccounts = (ListView) view.findViewById(R.id.listaccounts);
		// populate accounts
		// accounts = accountendpoint.listMemberAccounts(member,limit=5,cursor)

		new MyAccountsListAsyncTask(this.getActivity()).execute();

		return view;
	}

	private class MyAccountsListAsyncTask extends
			AsyncTask<Void, Void, CollectionResponseAccount> {
		Context context;
		private ProgressDialog pd;

		public MyAccountsListAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Retrieving Accounts...");
			pd.show();
		}

		protected CollectionResponseAccount doInBackground(Void... unused) {
			CollectionResponseAccount accounts = null;
			try {
				Accountendpoint.Builder builder = new Accountendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Accountendpoint service = builder.build();
				
				Memberendpoint.Builder memberbuilder = new Memberendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				
				SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
				long userid = sharedPref.getInt(getString(R.string.USER_ID), 0);
				
				Memberendpoint memberservice = memberbuilder.build();
				Member member = memberservice.getMemberByID(userid).execute();
				
				accounts = service.listAccount().execute();
			} catch (Exception e) {
				Log.d("Could not retrieve Accounts", e.getMessage(), e);
			}
			return accounts;
		}

		protected void onPostExecute(CollectionResponseAccount accounts) {
			pd.dismiss();
			if (accounts != null) {
				List<Account> list = accounts.getItems();
				adapter = new AdapterMyAccounts(context, list);
				listViewAccounts.setAdapter(adapter);
			}
		}
	}
}
