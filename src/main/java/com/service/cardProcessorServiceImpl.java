package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.InMemoryDB;
import com.entity.CreditCard;
import com.entity.UserAccountDetails;

@Component
public class cardProcessorServiceImpl implements CardProcessor{
	
	@Autowired
	private InMemoryDB inMemoryDB;

	@Override
	public ArrayList<UserAccountDetails> getAllUsers() {
		return inMemoryDB.getAllCards();
	}

	@Override
	public void addCreditCard(CreditCard cardDetails) {
		inMemoryDB.addCardDetials(cardDetails);
		
	}

}
