package com.sp.fanikiwa.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.sp.fanikiwa.ui.R;
import com.sp.fanikiwa.entity.organizationendpoint.Organizationendpoint;
import com.sp.fanikiwa.entity.organizationendpoint.model.Organization; 

public class AddOrganizationActivity extends Activity {

	EditText txtName;
	EditText txtEmail;
	EditText txtAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addorganization);

		txtName = (EditText) findViewById(R.id.txtOrganizationName);
		txtEmail = (EditText) findViewById(R.id.txtOrganizationEmail);
		txtAddress = (EditText) findViewById(R.id.txtOrganizationAddress);

		// Event Listener for About App button
		Button btnAddOrganization = (Button) findViewById(R.id.btnAddOrganization);
		btnAddOrganization.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Check if values are provided
				String orgName = txtName.getText().toString().trim();
				String orgEmail = txtEmail.getText().toString().trim();
				String orgAddress = txtAddress.getText().toString().trim();

				if (orgName.length() == 0) {
					Toast.makeText(AddOrganizationActivity.this,
							"You need to provide value for Organization Name",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (orgEmail.length() == 0) {
					Toast.makeText(
							AddOrganizationActivity.this,
							"You need to provide value for Organization Email",
							Toast.LENGTH_SHORT).show();
					return;
				}

				if (orgAddress.length() == 0) {
					Toast.makeText(
							AddOrganizationActivity.this,
							"You need to provide value for Organization Address",
							Toast.LENGTH_SHORT).show();
					return;
				}

				// Go ahead and perform the transaction
				String[] params = { orgName, orgEmail, orgAddress };
				new AddOrganizationAsyncTask(AddOrganizationActivity.this)
						.execute(params);

			}
		});

	}

	private class AddOrganizationAsyncTask extends
			AsyncTask<String, Void, Organization> {
		Context context;
		private ProgressDialog pd;

		public AddOrganizationAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Adding the Organization...");
			pd.show();
		}

		protected Organization doInBackground(String... params) {
			Organization response = null;
			try {
				Organizationendpoint.Builder builder = new Organizationendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Organizationendpoint service = builder.build();
				Organization organization = new Organization();
				organization.setName(params[0]);
				organization.setEmail(params[1]);
				organization.setAndress(params[2]);
				response = service.insertOrganization(organization).execute();
			} catch (Exception e) {
				Log.d("Could not Add Organization", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Organization organization) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			txtName.setText("");
			txtEmail.setText("");
			txtAddress.setText("");

			// Display success message to user
			Toast.makeText(getBaseContext(), "Organization added succesfully",
					Toast.LENGTH_SHORT).show();
		}
	}

}
