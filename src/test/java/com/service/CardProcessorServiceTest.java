package com.service;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.db.InMemoryDB;
import com.entity.CreditCard;
import com.entity.UserAccountDetails;

import junit.framework.Assert;

public class CardProcessorServiceTest {

	@Mock
	private InMemoryDB mockedDB;

	@InjectMocks
	private CardProcessorServiceImpl cardProcessorService;

	@Spy
	private ArrayList<UserAccountDetails> list;

	@SuppressWarnings("deprecation")
	@Test
	public void getAllCardsTest() {
		String name = "Bob";
		String cardNumber = "12345678903555";
		String limit = "£2000";
		UserAccountDetails userAccountDetails = new UserAccountDetails(new CreditCard(name, cardNumber, limit), "£0");
		list = new ArrayList<UserAccountDetails>();
		list.add(userAccountDetails);
		Mockito.when(mockedDB.getAllCards()).thenReturn(list);
		ArrayList<UserAccountDetails> listResponse = cardProcessorService.getAllUsers();
		Assert.assertEquals(list, listResponse);
	}

	@Test
	public void addCardTest() {
		String name = "Bob";
		String cardNumber = "12345678903555";
		String limit = "£2000";
		CreditCard card = new CreditCard(name, cardNumber, limit);
		Mockito.doNothing().when(mockedDB).addCardDetials(card);
		cardProcessorService.addCreditCard(card);

	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

}
