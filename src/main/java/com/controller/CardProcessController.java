package com.controller;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CreditCard;
import com.entity.UserAccountDetails;
import com.exceptions.InvalidRequestException;
import com.requests.AddCardRequest;
import com.response.GetAllCardsResponse;
import com.service.CardProcessor;
import com.validation.RequestValidationUtil;

@RestController
public class CardProcessController {

	Logger logger = LoggerFactory.getLogger(CardProcessController.class);
	@Autowired
	private CardProcessor cardProcessorService;

	/**
	 * GET all the accounts
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAllCards", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetAllCardsResponse getAllCreditCardDetails() {
		GetAllCardsResponse response = new GetAllCardsResponse();
		logger.info("getting all cards present in DB ");
		ArrayList<UserAccountDetails> cardList = cardProcessorService.getAllUsers();
		response.setCardListResponse(cardList);
		return response;

	}

	/**
	 * Add a new card
	 * 
	 * @param addCardRequest
	 * @throws InvalidRequestException
	 */
	@PostMapping(value = "/addCard", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCreditCard(@RequestBody AddCardRequest addCardRequest) throws InvalidRequestException {
		RequestValidationUtil.validateAddCardRequest(addCardRequest);
		logger.info("request validated successfully");
		CreditCard creditCard = new CreditCard(addCardRequest.getUserName(), addCardRequest.getCardNumber(),
				addCardRequest.getLimit());
		cardProcessorService.addCreditCard(creditCard);

	}

}
