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
import com.sp.fanikiwa.entity.coaendpoint.model.Coa;
import com.sp.fanikiwa.entity.coaendpoint.Coaendpoint; 

public class AddCoaActivity extends Activity {

	EditText txtDescription; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addcoa);

		txtDescription = (EditText) findViewById(R.id.txtCoaDescription); 

		// Event Listener for About App button
		Button btnAddCoa = (Button) findViewById(R.id.btnAddCoa);
		btnAddCoa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Check if values are provided
				String coaDescription = txtDescription.getText().toString().trim(); 
				
				if (coaDescription.length() == 0) {
					Toast.makeText(AddCoaActivity.this,
							"You need to provide value for Chart of Account Description",
							Toast.LENGTH_SHORT).show();
					return;
				}
 
				// Go ahead and perform the transaction
				String[] params = { coaDescription };
				new AddCoaAsyncTask(AddCoaActivity.this)
						.execute(params); 
			}
		});

	}

	private class AddCoaAsyncTask extends
			AsyncTask<String, Void, Coa> {
		Context context;
		private ProgressDialog pd;

		public AddCoaAsyncTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Adding the Chart of Account...");
			pd.show();
		}

		protected Coa doInBackground(String... params) {
			Coa response = null;
			try {
				Coaendpoint.Builder builder = new Coaendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null);
				Coaendpoint service = builder.build();
				Coa coa = new Coa();
				coa.setDescription(params[0]); 
				response = service.insertCoa(coa).execute();
			} catch (Exception e) {
				Log.d("Could not Add Chart of Account", e.getMessage(), e);
			}
			return response;
		}

		protected void onPostExecute(Coa coa) {
			// Clear the progress dialog and the fields
			pd.dismiss();
			txtDescription.setText(""); 

			// Display success message to user
			Toast.makeText(getBaseContext(), "Chart of Account added succesfully",
					Toast.LENGTH_SHORT).show();
		}
	}

}
