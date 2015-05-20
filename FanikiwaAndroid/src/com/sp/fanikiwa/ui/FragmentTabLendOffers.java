package com.sp.fanikiwa.ui;

import java.util.List;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.offerendpoint.Offerendpoint;
import com.sp.fanikiwa.entity.offerendpoint.model.CollectionResponseOffer;
import com.sp.fanikiwa.entity.offerendpoint.model.Offer; 

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView; 

public class FragmentTabLendOffers extends Fragment {

	// variables declaration 
	ListView listViewOffers; 
	private AdapterLendOffers adapter = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab_listlendoffers, container, false);
 
		listViewOffers = (ListView) view.findViewById(R.id.listlendoffers); 
		// populate offers
		// offers = offerendpoint.listMemberOffers(member,limit=5,cursor)

		new LendOffersListAsyncTask(this.getActivity()).execute();

		
		return view;
	}

	private class LendOffersListAsyncTask extends
			AsyncTask<Void, Void, CollectionResponseOffer> {
		Context context;
		private ProgressDialog pd;

		public LendOffersListAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Retrieving Offers...");
			pd.show();
		}

		protected CollectionResponseOffer doInBackground(Void... unused) {
			CollectionResponseOffer offers = null;
			try {
				Offerendpoint.Builder builder = new Offerendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Offerendpoint service = builder.build();
				offers = service.listOffer().execute();
			} catch (Exception e) {
				Log.d("Could not retrieve Offers", e.getMessage(), e);
			}
			return offers;
		}

		protected void onPostExecute(CollectionResponseOffer Offers) {
			pd.dismiss();
			if (Offers != null) {
				List<Offer> list = Offers.getItems();
				adapter = new AdapterLendOffers(context, list);
				listViewOffers.setAdapter(adapter);
			}
		}
	}
}
