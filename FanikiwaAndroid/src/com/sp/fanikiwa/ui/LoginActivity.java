package com.sp.fanikiwa.ui;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.entity.quoteEndpoint.QuoteEndpoint;
import com.sp.fanikiwa.entity.quoteEndpoint.model.Quote;
import com.sp.fanikiwa.entity.userprofileendpoint.Userprofileendpoint;
import com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText txtusername;
	EditText txtpwd;
	public static final String LOGIN_PREFERENCES = "LoginPrefs";
	public static final String USER_ID = "USER_ID";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setting default screen to login.xml

		setContentView(R.layout.login);

		// Event Listener for Login button
		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*
				 * call boolean auth= UsersEndpoint.Login(userid, pwd) if(auth)
				 * {show mainactivity; set preferences} else Toast(Error)
				 */

				txtusername = (EditText) findViewById(R.id.txtusername);
				txtusername.requestFocus();
				txtpwd = (EditText) findViewById(R.id.txtpwd);

				String username = txtusername.getText().toString().trim();
				String pwd = txtpwd.getText().toString().trim();

				if (username.length() == 0) {
					SpannableString spannableString = new SpannableString(
							"You need to provide values for UserName");
					spannableString.setSpan(
							new ForegroundColorSpan(getResources().getColor(
									android.R.color.holo_red_light)), 0,
							spannableString.length(), 0);
					Toast.makeText(getBaseContext(), spannableString,
							Toast.LENGTH_LONG).show();
					return;
				}

				if (pwd.length() == 0) {
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
				String[] params = { username, pwd };
				new LoginAsyncTask(LoginActivity.this).execute(params);

			}
		});

		// Event Listener for Register button
		Button btnRegister = (Button) findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
			}
		});

		 

	}

	private class LoginAsyncTask extends AsyncTask<String, Void, Userprofile> {
		Context context;
		private ProgressDialog pd;

		public LoginAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Authenticating...");
			pd.show();
		}

		protected Userprofile doInBackground(String... params) {
			Userprofile response = null;
			try {
				Userprofileendpoint.Builder builder = new Userprofileendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Userprofileendpoint service = builder.build();
				///TODO encrypt password
				response = service.login(params[0], params[1]).execute();
			} catch (Exception e) {
				Log.d("Could not Authenticate", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Userprofile userprofile) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			if ((userprofile == null)) {
				SpannableString spannableString = new SpannableString(
						"Authentication failed, please check your UserId or Password");
				spannableString.setSpan(new ForegroundColorSpan(getResources()
						.getColor(android.R.color.holo_red_light)), 0,
						spannableString.length(), 0);
				Toast.makeText(getBaseContext(), spannableString,
						Toast.LENGTH_LONG).show();
				return;
			}

			if ((userprofile != null)) {
				txtusername.setText("");
				txtpwd.setText("");

				// Display success message to user
				SpannableString spannableString = new SpannableString(
						"Login successfull");
				spannableString.setSpan(new ForegroundColorSpan(getResources()
						.getColor(android.R.color.holo_blue_light)), 0,
						spannableString.length(), 0);
				Toast.makeText(getBaseContext(), spannableString,
						Toast.LENGTH_LONG).show();

				SharedPreferences settings = getSharedPreferences(
						LOGIN_PREFERENCES, MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = settings.edit();
				prefEditor.putString("Userid", userprofile.getUserId().toString());
//				prefEditor.putString("Pwd", userprofile.getPassword());
				prefEditor.putBoolean("Isloggedin", true);
				prefEditor.putBoolean("Isfirstlogin", false);
				prefEditor.commit();

				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				i.putExtra(USER_ID, userprofile.getUserId());
				startActivity(i);

			}

		}
	}

}
