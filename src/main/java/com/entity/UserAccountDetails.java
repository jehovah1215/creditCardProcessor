package com.entity;

import java.io.Serializable;

public class UserAccountDetails implements Serializable {
	static final long serialVersionUID = 1L;

	private CreditCard creditCardDetails;
	private String balance;

	public CreditCard getCreditCardDetails() {
		return creditCardDetails;
	}

	public void setCreditCardDetails(CreditCard creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public UserAccountDetails(CreditCard creditCardDetails, String balance) {
		this.creditCardDetails = creditCardDetails;
		this.balance = balance;
	}

}
