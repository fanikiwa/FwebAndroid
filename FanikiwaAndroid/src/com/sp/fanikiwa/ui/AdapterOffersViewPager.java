package com.sp.fanikiwa.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdapterOffersViewPager extends FragmentPagerAdapter {

	final int PAGE_COUNT = 1;
	// Tab Titles  
	private String tabtitles[] = new String[] { "Create Offer", "My Offers", "Borrow Offers","Lend Offers" };
	Context context;

	public AdapterOffersViewPager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

		// Open FragmentTab1.java
//		case 0:
//			FragmentTabCreateOffer fragmenttab1 = new FragmentTabCreateOffer();
//			return fragmenttab1;
//
//			// Open FragmentTab2.java
//		case 1:
//			FragmentTabMyOffers fragmenttab2 = new FragmentTabMyOffers();
//			return fragmenttab2;
//			
//			 // Open FragmentTab3.java
//			 case 2:
//			 FragmentTabBorrowOffers fragmenttab3 = new FragmentTabBorrowOffers();
//			 return fragmenttab3;
			
			 // Open FragmentTab4.java
//			 case 3:
//			 FragmentTabLendOffers fragmenttab4 = new FragmentTabLendOffers();
//			 return fragmenttab4;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}
}