package com.sp.fanikiwa.ui;

import java.util.Date;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.memberendpoint.Memberendpoint;
import com.sp.fanikiwa.entity.memberendpoint.model.Member; 
import com.sp.fanikiwa.entity.memberendpoint.model.MemberDTO;
import com.sp.fanikiwa.entity.memberendpoint.model.RequestResult;
import com.sp.fanikiwa.entity.memberendpoint.model.UserDTO;
import com.sp.fanikiwa.entity.userprofileendpoint.Userprofileendpoint;
import com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	EditText txtsurname;
	EditText txtemail;
	EditText txtpwd;
	EditText txttelephone;
	public static final String REGISTER_PREFERENCES = "RegisterPrefs";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set View to register.xml
		setContentView(R.layout.register);

		// Event Listener for Login button
		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Closing registration screen
				// Switching to Login Screen/closing register screen
				Intent i = new Intent(getApplicationContext(),
						LoginActivity.class);
				startActivity(i);
				finish();
			}
		});

		// Event Listener for Register button
		Button btnRegister = (Button) findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				txtsurname = (EditText) findViewById(R.id.reg_surname);
				txtsurname.requestFocus();
				txtemail = (EditText) findViewById(R.id.reg_email);
				txtpwd = (EditText) findViewById(R.id.reg_password);
				txttelephone = (EditText) findViewById(R.id.reg_telephone);

				String surname = txtsurname.getText().toString().trim();
				String email = txtemail.getText().toString().trim();
				String pwd = txtpwd.getText().toString().trim();
				String telephone = txttelephone.getText().toString().trim();

				if ((surname.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for SurName");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}

				if ((email.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Email");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}

				if ((pwd.length() == 0)) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for Password");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}

				// Go ahead and perform the transaction
				String[] params = { surname, email, pwd, telephone };
				new RegisterAsyncTask(RegisterActivity.this).execute(params);

			}
		});

	}

	private class RegisterAsyncTask extends AsyncTask<String, Void, RequestResult> {
		Context context;
		private ProgressDialog pd;

		public RegisterAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Registering...");
			pd.show();
		}

		protected RequestResult doInBackground(String... params) {
			RequestResult response = null; 
			try {

				Userprofileendpoint.Builder ibuilder = new Userprofileendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null); 
				Memberendpoint.Builder builder = new Memberendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Memberendpoint service = builder.build();
				UserDTO member = new UserDTO();
				// at this point, fill the member with the details from the UI
				member.setSurname(params[0]);
				member.setEmail(params[1]);
				member.setPwd(params[2]);
				member.setTelephone(params[3]);

				response = service.register(member).execute();
				Log.d("RegisterAsyncTask", "Member registered. Memerid="
						+ response.getClientToken().toString());
			} catch (Exception e) {
				Log.d("Could not Authenticate", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Member member) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			txtsurname.setText("");
			txtemail.setText("");
			txtpwd.setText("");

			if ((member == null)) {
				SpannableString spannableString = new SpannableString(
						"Registration failed, please Try Again");
				spannableString.setSpan(new ForegroundColorSpan(getResources()
						.getColor(android.R.color.holo_red_light)), 0,
						spannableString.length(), 0);
				Toast.makeText(getBaseContext(), spannableString,
						Toast.LENGTH_LONG).show();
				return;
			}

			if ((member != null)) {
				// Display success message to user
				SpannableString spannableString = new SpannableString(
						"Registration succesfull");
				spannableString.setSpan(new ForegroundColorSpan(getResources()
						.getColor(android.R.color.holo_blue_light)), 0,
						spannableString.length(), 0);
				Toast.makeText(getBaseContext(), spannableString,
						Toast.LENGTH_LONG).show();

				SharedPreferences settings = getSharedPreferences(
						REGISTER_PREFERENCES, MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = settings.edit();
				prefEditor.putLong("Memberid", member.getMemberId());
				prefEditor.putLong("Currentaccount", member.getCurrentAccount()
						.getAccountID());
				prefEditor.putLong("Loanaccount", member.getLoanAccount()
						.getAccountID());
				prefEditor.putLong("Investmentaccount", member
						.getInvestmentAccount().getAccountID());
				prefEditor.commit();

				Log.d("RegisterAsyncTask.PostExec",
						"Saved shared pref, now calling Main");
				
				 Intent i = new Intent(getApplicationContext(),
				 MainActivity.class);
				 startActivity(i);
  
			}

		}
	}

}
