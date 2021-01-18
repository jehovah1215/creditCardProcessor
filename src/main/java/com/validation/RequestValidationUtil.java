package com.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exceptions.InvalidRequestException;
import com.requests.AddCardRequest;

public class RequestValidationUtil {
	
	public static void validateAddCardRequest(AddCardRequest addCardRequest) throws InvalidRequestException{
		String cardNumber = addCardRequest.getCardNumber();
		String limit = addCardRequest.getLimit();
		String userName = addCardRequest.getUserName();
		LuhnValidationUtil.validateCreditCardNumber(cardNumber);
		if(!validateUserName(userName))
			throw new InvalidRequestException("user name is of invalid format");
		AmountValidationUtil.validateAmount(limit);	
	}
	/*
	 * basic name validator
	 */
	private static boolean validateUserName(String userName) {
		String regx = "^[a-zA-Z\\\\s]*$";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(userName);
	    return matcher.find();

		
	}

}
