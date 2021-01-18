package com.entity;

import java.io.Serializable;

public class CreditCard implements Serializable {
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	static final long serialVersionUID = 1L;

	private String userName;
	private String cardNumber;
	private String limit;
	

	public CreditCard(String userName, String cardNumber, String limit) {
		this.userName = userName;
		this.cardNumber = cardNumber;
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "CreditCard [userName=" + userName + ", cardNumber=" + cardNumber + ", limit="
				+ limit + "]";
	}

}
