package com.sp.fanikiwa.ui;

import java.util.List;
import com.sp.fanikiwa.entity.accountendpoint.model.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterMyAccounts extends BaseAdapter {

	Context context;
	protected List<Account> Accounts;
	LayoutInflater inflater;

	public AdapterMyAccounts(Context context, List<Account> listAccounts) {
		this.Accounts = listAccounts;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public int getCount() {
		return Accounts.size();
	}

	public Account getItem(int position) {
		return Accounts.get(position);
	}

	public long getItemId(int position) {
		return Accounts.get(position).getAccountID();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {

			holder = new ViewHolder();
			convertView = this.inflater.inflate(R.layout.itemmyaccount, parent, false);

			holder.txtAccountName = (TextView) convertView
					.findViewById(R.id.account_name);
			holder.txtClearedBalance = (TextView) convertView
					.findViewById(R.id.account_clearedbalance);
			holder.txtBookBalance = (TextView) convertView
					.findViewById(R.id.account_bookbalance);
			holder.txtLimit = (TextView) convertView
					.findViewById(R.id.account_limit);

			convertView.setTag(holder);
		} else {
			
			holder = (ViewHolder) convertView.getTag();
			
			convertView = this.inflater.inflate(R.layout.itemmyaccount, parent, false);

			holder.txtAccountName = (TextView) convertView
					.findViewById(R.id.account_name);
			holder.txtClearedBalance = (TextView) convertView
					.findViewById(R.id.account_clearedbalance);
			holder.txtBookBalance = (TextView) convertView
					.findViewById(R.id.account_bookbalance);
			holder.txtLimit = (TextView) convertView
					.findViewById(R.id.account_limit);

			convertView.setTag(holder);
		}

		Account account = Accounts.get(position);
		holder.txtAccountName.setText("Account Name: " + account.getAccountName().trim());
		holder.txtClearedBalance.setText("Cleared Balance: " + account.getClearedBalance().toString());
		holder.txtBookBalance.setText("Book Balance: " + account.getBookBalance().toString());
		holder.txtLimit.setText("Limit: " + account.getLimit().toString());

		return convertView;
	}

	private class ViewHolder {
		TextView txtAccountName;
		TextView txtClearedBalance;
		TextView txtBookBalance;
		TextView txtLimit;
	}
}
