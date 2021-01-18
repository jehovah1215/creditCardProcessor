package com.validation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.exceptions.InvalidCardNumberException;
import com.exceptions.InvalidRequestException;
import com.requests.AddCardRequest;

public class ValidationUtilTest {

	private static String VALID_CARD_NUMBER = "12345678903555";
	private static String INVALID_CARD_NUMBER = "092850003540600";

	@Test()
	public void luhnValidationForInValidCardTest() {
		Throwable e = null;
		try {
			LuhnValidationUtil.validateCreditCardNumber(INVALID_CARD_NUMBER);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof InvalidCardNumberException);

	}
	
	@Test()
	public void invalidNameRequestTest() {
		String name = "Bob@@";
		String cardNumber = "12345678903555";
		String limit = "£2000";
		AddCardRequest addcardReq = new AddCardRequest();
		addcardReq.setCardNumber(cardNumber);
		addcardReq.setLimit(limit);
		addcardReq.setUserName(name);
		Throwable e = null;
		try {
			RequestValidationUtil.validateAddCardRequest(addcardReq);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof InvalidRequestException);
	}
	
	@Test()
	public void invalidAmountRequestTest() {
		String name = "Bob";
		String cardNumber = "12345678903555";
		String limit = "V20ccc00";
		AddCardRequest addcardReq = new AddCardRequest();
		addcardReq.setCardNumber(cardNumber);
		addcardReq.setLimit(limit);
		addcardReq.setUserName(name);
		Throwable e = null;
		try {
			RequestValidationUtil.validateAddCardRequest(addcardReq);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof InvalidRequestException);
	}
	
	@Test()
	public void testLuhnValidationForValidCard() {
		LuhnValidationUtil.validateCreditCardNumber(VALID_CARD_NUMBER);
	}


}
