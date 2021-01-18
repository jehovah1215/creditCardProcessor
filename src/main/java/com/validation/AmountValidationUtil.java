package com.validation;

import com.exceptions.InvalidRequestException;

public class AmountValidationUtil {

	/*
	 * 
	 * Basic vaidation just checking the numeric value and skipping the currency
	 * check as of now .
	 */
	public static void validateAmount(String amount) throws InvalidRequestException {

		// TODO: add currency checker and validate amounts properly

		String currencySymbol = amount.substring(0, 1);
		String value = amount.substring(1);
		boolean isNumeric = value.chars().allMatch(Character::isDigit);
		if (!isNumeric)
			throw new InvalidRequestException(" amount entered is not valid , it contains invalid characters");

	}
}
