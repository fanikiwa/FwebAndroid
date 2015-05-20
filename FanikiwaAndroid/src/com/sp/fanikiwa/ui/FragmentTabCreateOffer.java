package com.sp.fanikiwa.ui;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.offerendpoint.Offerendpoint;
import com.sp.fanikiwa.entity.offerendpoint.model.Offer;
import com.sp.fanikiwa.entity.offerendpoint.model.OfferDTO;
import com.sp.fanikiwa.entity.offerendpoint.model.RequestResult;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class FragmentTabCreateOffer extends Fragment {

	EditText txtDescription;
	CheckBox chkPublicOffer;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.fragmenttab_createoffer,
				container, false);

		txtDescription = (EditText) view.findViewById(R.id.offer_description);
		txtDescription.requestFocus();
		txtAmount = (EditText) view.findViewById(R.id.offer_Amount);
		txtInterest = (EditText) view.findViewById(R.id.offer_Interest);
		txtTerm = (EditText) view.findViewById(R.id.offer_Term);
		cboOfferType = (Spinner) view.findViewById(R.id.offer_OfferType);
		chkPublicOffer = (CheckBox) view.findViewById(R.id.offer_PublicOffer);
		chkPartialPay = (CheckBox) view.findViewById(R.id.offer_partialPay);

		// Event Listener for MakeOFfer button
		Button btnMakeOFfer = (Button) view.findViewById(R.id.btnMakeOffer);
		btnMakeOFfer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Check if values are provided
				String description = txtDescription.getText().toString().trim();
				String amount = txtAmount.getText().toString().trim();
				String interest = txtInterest.getText().toString().trim();
				String term = txtTerm.getText().toString().trim();
				String offertype = cboOfferType.getSelectedItem().toString();
				String publicoffer = chkPublicOffer.getText().toString().trim();
				if (publicoffer.equals("true")) {
					publicoffer = "1";
				}
				if (publicoffer.equals("false")) {
					publicoffer = "0";
				}
				String partialpay = chkPartialPay.getText().toString().trim();
				if (partialpay.equals("true")) {
					partialpay = "1";
				}
				if (partialpay.equals("false")) {
					partialpay = "0";
				}

				if ((description.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Description");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
							spannableString, Toast.LENGTH_LONG).show();
					return;
				}
				if ((amount.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Amount");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
							spannableString, Toast.LENGTH_LONG).show();
					return;
				}

				if ((interest.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Interest");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
							spannableString, Toast.LENGTH_LONG).show();
					return;
				}

				if ((term.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Term");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
							spannableString, Toast.LENGTH_LONG).show();
					return;
				}

				if ((offertype.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Offer Type");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
							spannableString, Toast.LENGTH_LONG).show();
					return;
				}

				// Go ahead and perform the transaction
				String[] params = { description, amount, interest, term,
						offertype, publicoffer, partialpay };
				new MakeOfferAsyncTask(FragmentTabCreateOffer.this
						.getActivity()).execute(params);

			}
		});

		// Event Listener for Cancel button
		Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				txtDescription.setText("");
				txtDescription.requestFocus();
				txtAmount.setText("");
				txtInterest.setText("");
				txtTerm.setText("");
				chkPublicOffer.setChecked(false);
				cboOfferType.setSelection(0);
				chkPartialPay.setChecked(false);
			}
		});

		// Event Listener for Close button
		Button btnClose = (Button) view.findViewById(R.id.btnClose);
		btnClose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(FragmentTabCreateOffer.this.getActivity(),
						"FragmentTabCreateOffer", Toast.LENGTH_LONG).show();
			}
		});

		// Populate Spinners AsyncTask
		new PopulateSpinnersAsyncTask(this.getActivity()).execute();

		return view;

	}

	private class MakeOfferAsyncTask extends
			AsyncTask<String, Void, RequestResult> {
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

		protected RequestResult doInBackground(String... params) {
			RequestResult response = null;
			try {
				Offerendpoint.Builder builder = new Offerendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Offerendpoint service = builder.build();
				OfferDTO offer = new OfferDTO();
				offer.setDescription(params[0]);
				double amount = Double.parseDouble(params[1]);
				offer.setAmount(amount);
				double interest = Double.parseDouble(params[2]);
				offer.setInterest(interest);
				int term = Integer.parseInt(params[3]);
				offer.setTerm(term);
				offer.setOfferType(params[4]);
				Boolean privateOffer = Boolean.parseBoolean(params[5]);
				offer.setPrivateOffer(privateOffer);
				Boolean partialpay = Boolean.parseBoolean(params[6]);
				offer.setPartialPay(partialpay);

				response = service.saveOffer(offer).execute();
			} catch (Exception e) {
				SpannableString spannableString = new SpannableString(
						"Error Creating Offer: Message " + e.getMessage());
				spannableString.setSpan(new ForegroundColorSpan(getResources()
						.getColor(android.R.color.holo_red_light)), 0,
						spannableString.length(), 0);
				Toast.makeText(context, spannableString, Toast.LENGTH_LONG)
						.show();
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
			chkPublicOffer.setChecked(false);
			cboOfferType.setSelection(0);
			chkPartialPay.setChecked(false);

			// Display success message to user
			SpannableString spannableString = new SpannableString(
					"Offer created succesfully");
			spannableString.setSpan(new ForegroundColorSpan(getResources()
					.getColor(android.R.color.holo_blue_light)), 0,
					spannableString.length(), 0);
			Toast.makeText(context, spannableString, Toast.LENGTH_LONG).show();

		}
	}

	// Download JSON file AsyncTask
	private class PopulateSpinnersAsyncTask extends AsyncTask<Void, Void, Void> {
		Context context;

		public PopulateSpinnersAsyncTask(Context context) {
			this.context = context;
		}

		@Override
		protected Void doInBackground(Void... params) {

			publicoffers = new ArrayList<String>();
			offertypes = new ArrayList<String>();

			try {

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

			cboOfferType.setAdapter(new ArrayAdapter<String>(context,
					android.R.layout.simple_spinner_dropdown_item, offertypes));

		}
	}

}
