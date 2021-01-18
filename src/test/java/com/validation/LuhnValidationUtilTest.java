package com.validation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.exceptions.InvalidCardNumberException;

public class LuhnValidationUtilTest {

	private static String VALID_CARD_NUMBER = "012850003540600";
	private static String INVALID_CARD_NUMBER = "092850003540600";

	@Test()
	public void testLuhnValidationForValidCard() {
		LuhnValidationUtil.validateCreditCardNumber(VALID_CARD_NUMBER);
	}

	@Test()
	public void testLuhnValidationForInValidCard() {
		Throwable e = null;
		try {
			LuhnValidationUtil.validateCreditCardNumber(INVALID_CARD_NUMBER);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof InvalidCardNumberException);

	}

}
