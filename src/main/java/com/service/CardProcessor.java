package com.service;

import java.util.ArrayList;

import com.entity.CreditCard;
import com.entity.UserAccountDetails;

public interface CardProcessor {
	public ArrayList<UserAccountDetails> getAllUsers();
	public void addCreditCard(CreditCard cardDetails);

}
