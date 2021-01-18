package com.requests;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class AddCardRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String userName;
	@NotBlank
	private String cardNumber;
	@NotBlank
	private String limit;

	public AddCardRequest() {
		
	}

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

}
