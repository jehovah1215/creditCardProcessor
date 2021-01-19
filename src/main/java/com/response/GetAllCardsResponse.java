package com.response;

import java.io.Serializable;
import java.util.ArrayList;

import com.entity.UserAccountDetails;

public class GetAllCardsResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<UserAccountDetails> cardListResponse;

	public ArrayList<UserAccountDetails> getCardListResponse() {
		return cardListResponse;
	}

	public void setCardListResponse(ArrayList<UserAccountDetails> cardListResponse) {
		this.cardListResponse = cardListResponse;
	}

}
