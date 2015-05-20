package com.sp.fanikiwa.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.ui.R;
import com.sp.fanikiwa.entity.offerendpoint.Offerendpoint;
import com.sp.fanikiwa.entity.offerendpoint.model.Offer; 

public class MakeOfferActivity extends Activity  {

	EditText txtDescription;
//	Spinner cboPublicOffer;
//	Spinner cboOfferType;
	EditText txtAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_offer);

//		ArrayList<String> offertypes = new ArrayList<String>();
//		offertypes.add("Lend");
//		offertypes.add("Borrow");
//		ArrayList<String> publicoffers = new ArrayList<String>();
//		publicoffers.add("Public");
//		publicoffers.add("Private");
		txtDescription = (EditText) findViewById(R.id.offer_description);
		txtAmount = (EditText) findViewById(R.id.offer_Amount);
//		cboPublicOffer = (Spinner) findViewById(R.id.offer_PublicOffer);
		// Creating adapter for spinner
		// ArrayAdapter<String> publicoffersdataAdapter = new
		// ArrayAdapter<String>(this,
		// android.R.layout.simple_spinner_item, publicoffers);
		//
		// // Drop down layout style - list view with radio button
		// publicoffersdataAdapter
		// .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		// // attaching data adapter to spinner
		// cboPublicOffer.setAdapter(publicoffersdataAdapter);
		// cboPublicOffer.setOnItemSelectedListener(this);

//		cboOfferType = (Spinner) findViewById(R.id.offer_OfferType);
		// // Creating adapter for spinner
		// ArrayAdapter<String> offertypesdataAdapter = new
		// ArrayAdapter<String>(this,
		// android.R.layout.simple_spinner_item, offertypes);
		//
		// // Drop down layout style - list view with radio button
		// offertypesdataAdapter
		// .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		// // attaching data adapter to spinner
		// cboOfferType.setAdapter(offertypesdataAdapter);
		// cboOfferType.setOnItemSelectedListener(this);

		// Event Listener for About App button
		Button btnMakeOFfer = (Button) findViewById(R.id.btnMakeOFfer);
		btnMakeOFfer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Check if values are provided
				String description = txtDescription.getText().toString().trim();
				String publicoffer = txtDescription.getText().toString().trim();
				String offertype = txtDescription.getText().toString().trim();
				String amount = txtAmount.getText().toString().trim();

				if ((description.length() == 0)) {
					Toast.makeText(MakeOfferActivity.this,
							"You need to provide values for Description",
							Toast.LENGTH_SHORT).show();
					return;
				}

				// if ((publicoffer.length() == 0)) {
				// Toast.makeText(MakeOfferActivity.this,
				// "You need to provide values for Public Offer",
				// Toast.LENGTH_SHORT).show();
				// return;
				// }
				//
				// if ((offertype.length() == 0)) {
				// Toast.makeText(MakeOfferActivity.this,
				// "You need to provide values for Offer Type",
				// Toast.LENGTH_SHORT).show();
				// return;
				// }

				if ((amount.length() == 0)) {
					Toast.makeText(MakeOfferActivity.this,
							"You need to provide values for Amount",
							Toast.LENGTH_SHORT).show();
					return;
				}

				// Go ahead and perform the transaction
				String[] params = { description, description, description,
						amount };
				new MakeOfferAsyncTask(MakeOfferActivity.this).execute(params);

			}
		});

	}

	private class MakeOfferAsyncTask extends AsyncTask<String, Void, Offer> {
		Context context;
		private ProgressDialog pd;

		public MakeOfferAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Creating the Offer...");
			pd.show();
		}

		protected Offer doInBackground(String... params) {
			Offer response = null;
			try {
				Offerendpoint.Builder builder = new Offerendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Offerendpoint service = builder.build();
				Offer offer = new Offer();
				offer.setDescription(params[0]);
				Boolean privateOffer = Boolean.parseBoolean(params[1]);
				offer.setPrivateOffer(privateOffer);
				offer.setOfferType(params[2]);
				double amount = Double.parseDouble(params[3]);
				offer.setAmount(amount);
				response = service.insertOffer(offer).execute();
			} catch (Exception e) {
				Log.d("Could not Create Offer", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Offer quote) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			txtDescription.setText("");
			txtAmount.setText("");

			// Display success message to user
			Toast.makeText(getBaseContext(), "Offer created succesfully",
					Toast.LENGTH_SHORT).show();
		}
	}
 

}
