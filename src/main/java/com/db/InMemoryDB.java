package com.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.entity.CreditCard;
import com.entity.UserAccountDetails;
import com.exceptions.CardAlreadyExistsException;

/**
 * TODO :: Make this class as singleton so that single instance of map is set
 * throughout.
 */
@Repository
public class InMemoryDB {
	private static final Map<String, UserAccountDetails> inMemoryDB = new HashMap<String, UserAccountDetails>();
	private static final String DEFAULT_AMOUNT = "\u00A3" + "0";

	public ArrayList<UserAccountDetails> getAllCards() {
		ArrayList<UserAccountDetails> result = new ArrayList<UserAccountDetails>();
		for (Map.Entry<String, UserAccountDetails> itr : inMemoryDB.entrySet())
			result.add(itr.getValue());
		return result;
	}

	/**
	 * Add card to DB
	 * @param card
	 * @throws CardAlreadyExistsException
	 */
	public void addCardDetials(CreditCard card) throws CardAlreadyExistsException {
		if (checkIfCardExists(card.getCardNumber()))
			throw new CardAlreadyExistsException(" card by this number already exists , cannot add card");
		UserAccountDetails userDetails = new UserAccountDetails(card, DEFAULT_AMOUNT);
		inMemoryDB.put(card.getCardNumber(), userDetails);
	}

	/**
	 * Check if card already exists
	 * @param cardNumber
	 * @return
	 */
	public boolean checkIfCardExists(String cardNumber) {
		return inMemoryDB.containsKey(cardNumber);
	}


}
