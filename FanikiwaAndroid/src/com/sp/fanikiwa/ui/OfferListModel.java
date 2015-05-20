package com.sp.fanikiwa.ui;

public class OfferListModel {
    
    private  String Offerer="";
    private  String Offertype="";
    private  double Amount;
    private double Interest;
    private int term;
	public String getOfferer() {
		return Offerer;
	}
	public void setOfferer(String offerer) {
		Offerer = offerer;
	}
	public String getOffertype() {
		return Offertype;
	}
	public void setOffertype(String offertype) {
		Offertype = offertype;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getInterest() {
		return Interest;
	}
	public void setInterest(double interest) {
		Interest = interest;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
}