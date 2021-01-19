package com.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.InMemoryDB;
import com.entity.CreditCard;
import com.entity.UserAccountDetails;

@Component
public class CardProcessorServiceImpl implements CardProcessor {
	Logger logger = LoggerFactory.getLogger(CardProcessorServiceImpl.class);

	@Autowired
	private InMemoryDB inMemoryDB;

	@Override
	public ArrayList<UserAccountDetails> getAllUsers() {
		logger.info(" requesting db for records ");
		return inMemoryDB.getAllCards();
	}

	@Override
	public void addCreditCard(CreditCard cardDetails) {
		logger.info(" adding card details with card number  XXXXXXX"+ cardDetails.getCardNumber().substring(8) +" into db " );
		inMemoryDB.addCardDetials(cardDetails);

	}

}
