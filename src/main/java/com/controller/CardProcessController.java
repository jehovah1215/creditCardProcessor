package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CreditCard;
import com.entity.UserAccountDetails;
import com.exceptions.InvalidRequestException;
import com.requests.AddCardRequest;
import com.service.CardProcessor;
import com.validation.RequestValidationUtil;

@RestController
public class CardProcessController {

	@Autowired
	private CardProcessor cardProcessorService;

	@GetMapping(value = "/getAllCards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<UserAccountDetails> getAllCreditCardDetails() {
		ArrayList<UserAccountDetails> cardList = cardProcessorService.getAllUsers();
		return cardList;

	}

	@PostMapping(value = "/addCard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCreditCard(@RequestBody AddCardRequest addCardRequest) throws InvalidRequestException {
		RequestValidationUtil.validateAddCardRequest(addCardRequest);
		CreditCard creditCard = new CreditCard(addCardRequest.getUserName(), addCardRequest.getCardNumber(),
				addCardRequest.getLimit());
		cardProcessorService.addCreditCard(creditCard);

	}

}
