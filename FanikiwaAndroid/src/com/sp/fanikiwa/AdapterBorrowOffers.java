package com.sp.fanikiwa;

import java.util.List;

import com.sp.fanikiwa.entity.offerendpoint.model.Offer;
import com.sp.fanikiwa.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class AdapterBorrowOffers extends BaseAdapter {

	Context context;
	protected List<Offer> Offers;
	LayoutInflater inflater;

	public AdapterBorrowOffers(Context context, List<Offer> listOffers) {
		this.Offers = listOffers;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
	}

	public int getCount() {
		if (Offers != null)
			return Offers.size();
		else
			return 0;
	}

	public Offer getItem(int position) {
		return Offers.get(position);
	}

	public long getItemId(int position) {
		return Offers.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {

			holder = new ViewHolder();
			convertView = this.inflater.inflate(R.layout.itemborrowoffer,
					parent, false);

			holder.txtDescription = (TextView) convertView
					.findViewById(R.id.offer_description);
			holder.txtAmount = (TextView) convertView
					.findViewById(R.id.offer_amount);
			holder.txtTerm = (TextView) convertView
					.findViewById(R.id.offer_term);
			holder.txtInterest = (TextView) convertView
					.findViewById(R.id.offer_interest);
			holder.chkBorrowOffersMarker = (CheckBox) convertView
					.findViewById(R.id.chkBorrowOffersMarker);

			convertView.setTag(holder);
		} else {

			holder = (ViewHolder) convertView.getTag();

			convertView = this.inflater.inflate(R.layout.itemborrowoffer,
					parent, false);

			holder.txtDescription = (TextView) convertView
					.findViewById(R.id.offer_description);
			holder.txtAmount = (TextView) convertView
					.findViewById(R.id.offer_amount);
			holder.txtTerm = (TextView) convertView
					.findViewById(R.id.offer_term);
			holder.txtInterest = (TextView) convertView
					.findViewById(R.id.offer_interest);
			holder.chkBorrowOffersMarker = (CheckBox) convertView
					.findViewById(R.id.chkBorrowOffersMarker);

			convertView.setTag(holder);
		}

		Offer offer = Offers.get(position);
		holder.txtDescription.setText("Description: "
				+ offer.getDescription().trim());
		holder.txtAmount.setText("Amount: " + offer.getAmount().toString());
		holder.txtTerm.setText("Term: " + offer.getTerm().toString());
		holder.txtInterest.setText("Interest: "
				+ offer.getInterest().toString());
		holder.chkBorrowOffersMarker
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// contacts.setCheck(isChecked);
						notifyDataSetChanged();
					}
				});
		// holder.chkBorrowOffersMarker.setChecked(contacts.isCheck());
		return convertView;
	}

	private class ViewHolder {
		TextView txtDescription;
		TextView txtAmount;
		TextView txtInterest;
		TextView txtTerm;
		CheckBox chkBorrowOffersMarker;
	}
}
