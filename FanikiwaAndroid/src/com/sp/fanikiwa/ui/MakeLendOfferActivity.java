package com.sp.fanikiwa.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.CheckBox;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.ui.R;
import com.sp.fanikiwa.entity.offerendpoint.Offerendpoint;
import com.sp.fanikiwa.entity.offerendpoint.model.Offer;
import com.sp.fanikiwa.entity.quoteEndpoint.model.Quote;

public class MakeLendOfferActivity extends Activity {

	EditText txtDescription;
	Spinner cboPublicOffer;
	Spinner cboOfferType;
	EditText txtAmount;
	EditText txtInterest;
	EditText txtTerm;
	CheckBox chkPartialPay;
	JSONObject jsonobject;
	JSONArray jsonarray;
	ProgressDialog mProgressDialog;
	ArrayList<String> offertypes;
	ArrayList<String> publicoffers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_offer);

		txtDescription = (EditText) findViewById(R.id.offer_description);
		txtDescription.requestFocus();
		txtAmount = (EditText) findViewById(R.id.offer_Amount);
		txtInterest = (EditText) findViewById(R.id.offer_Interest);
		txtTerm = (EditText) findViewById(R.id.offer_Term);
		cboOfferType = (Spinner) findViewById(R.id.offer_OfferType);
		cboPublicOffer = (Spinner) findViewById(R.id.offer_PublicOffer);
		chkPartialPay = (CheckBox) findViewById(R.id.offer_partialPay);

		// Event Listener for MakeOFfer button
		Button btnMakeOFfer = (Button) findViewById(R.id.btnMakeOFfer);
		btnMakeOFfer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Check if values are provided
				String description = txtDescription.getText().toString().trim(); 
				String amount = txtAmount.getText().toString().trim();
				String interest = txtInterest.getText().toString().trim();
				String term = txtTerm.getText().toString().trim(); 
				String offertype = cboOfferType.getSelectedItem().toString();
				String publicoffer = cboPublicOffer.getSelectedItem().toString();
				String partialpay = chkPartialPay.getText().toString().trim(); 
				
				if ((description.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Description");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}
				if ((amount.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Amount");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}
				
				if ((interest.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Interest");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}
				
				if ((term.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Term");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}
				
				 if ((publicoffer.length() == 0)) {  
				 SpannableString spannableString = new SpannableString(
						 "You need to provide values for Public Offer");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
				 return;
				 }
				
				 if ((offertype.length() == 0)) {  
				 SpannableString spannableString = new SpannableString(
						 "You need to provide values for Offer Type");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
				 return;
				 }
 
				// Go ahead and perform the transaction
				String[] params = { description, amount, interest,  term, offertype, publicoffer, partialpay };
				new MakeOfferAsyncTask(MakeLendOfferActivity.this).execute(params);

			}
		});

		// Event Listener for Cancel button
		Button btnCancel = (Button) findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				txtDescription.setText("");
				txtDescription.requestFocus();
				txtAmount.setText("");
				txtInterest.setText("");
				txtTerm.setText("");
				cboPublicOffer.setSelection(0);
				cboOfferType.setSelection(0);
				chkPartialPay.setChecked(false); 
			}
		});

		// Populate Spinners AsyncTask
		new PopulateSpinnersAsyncTask().execute();

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
				double amount = Double.parseDouble(params[1]);
				offer.setAmount(amount);
				double interest = Double.parseDouble(params[2]);
				offer.setInterest(interest);
				int term = Integer.parseInt(params[3]);
				offer.setTerm(term);
				offer.setOfferType(params[4]); 
				offer.setPublicOffer(params[5]);
				int partialpay = Integer.parseInt(params[6]); 
				offer.setPartialPay(partialpay); 
				
				response = service.insertOffer(offer).execute();
			} catch (Exception e) {
				Log.d("Could not Create Offer", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Offer offer) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			txtDescription.setText(""); 
			txtAmount.setText("");
			txtInterest.setText("");
			txtTerm.setText("");
			cboPublicOffer.setSelection(0);
			cboOfferType.setSelection(0);
			chkPartialPay.setChecked(false);

			// Display success message to user
			SpannableString spannableString = new SpannableString(
					"Offer created succesfully");
			spannableString.setSpan(
					new ForegroundColorSpan(getResources().getColor(
							android.R.color.holo_blue_light)), 0,
					spannableString.length(), 0);
			Toast.makeText(getBaseContext(), spannableString,
					Toast.LENGTH_LONG).show(); 
		}
	}

	// Download JSON file AsyncTask
	private class PopulateSpinnersAsyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {

			publicoffers = new ArrayList<String>();
			offertypes = new ArrayList<String>();

			try {

				// Populate spinner
				publicoffers.add("Public");
				publicoffers.add("Private");
				offertypes.add("Lend");
				offertypes.add("Borrow");

			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void args) {

			cboPublicOffer
					.setAdapter(new ArrayAdapter<String>(
							MakeLendOfferActivity.this,
							android.R.layout.simple_spinner_dropdown_item,
							publicoffers));

			cboOfferType.setAdapter(new ArrayAdapter<String>(
					MakeLendOfferActivity.this,
					android.R.layout.simple_spinner_dropdown_item, offertypes));

		}
	}

}
