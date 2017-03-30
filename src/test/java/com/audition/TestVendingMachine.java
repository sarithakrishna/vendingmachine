package com.audition;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVendingMachine {

	VendingMachineImpl machine = new VendingMachineImpl();

	// TestCases for Accept Coin

	@Test
	public void testDefaultDisplayAssertEquals() {
		Coin coin = new Coin(0.0, 0.0);
		assertEquals(machine.insertCoin(coin), "Insert Coin");

	}

	@Test
	public void testInsertCoinForNickelAssertEquals() {
		Coin coin = new Coin(1.0, 0.5);
		assertEquals(machine.insertCoin(coin), "0.5");
	}

	@Test
	public void testInsertCoinForDimeAssertEquals() {
		Coin coin = new Coin(1.0, 0.1);
		assertEquals(machine.insertCoin(coin), "0.1");
	}

	@Test
	public void testInsertCoinForQuarterAssertEquals() {
		Coin coin = new Coin(1.0, 0.25);
		assertEquals(machine.insertCoin(coin), "0.25");
	}

	@Test
	public void testInsertCoinForInvalidCoinAssertEquals() {
		Coin coin = new Coin(1.0, 0.01);
		assertEquals(machine.insertCoin(coin), "Invalid Coin!, Insert nickels,dimes or quarters");
	}

	@Test
	public void testInsertCoinForDollarAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));

		assertEquals(new Double(1.0), machine.getAmount());
	}

	@Test
	public void testInsertMultipleValidCoinAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.5));
		machine.insertCoin(new Coin(1.0, 0.1));

		assertEquals(new Double(0.85), machine.getAmount());
	}

	@Test
	public void testInsertInvalidCoinWithValidCoinAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.01));

		assertEquals(new Double(0.26), "Invalid Coin!, Insert nickels,dimes or quarters");
	}

	// TestCases for Select Product

	@Test
	public void testSelectItemForChipsAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.50));
		assertEquals(machine.selectItem(new Item("Chips", 0.50)), "Chips");
	}

	@Test
	public void testSelectItemForColaAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));
		machine.insertCoin(new Coin(1.0, 0.25));

		assertEquals(machine.selectItem(new Item("Cola", 1.0)), "Cola");
	}

	@Test
	public void testSelectItemForCandyAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.10));
		machine.insertCoin(new Coin(1.0, 0.10));
		machine.insertCoin(new Coin(1.0, 0.10));
		machine.insertCoin(new Coin(1.0, 0.10));
		machine.insertCoin(new Coin(1.0, 0.25));

		assertEquals(machine.selectItem(new Item("Candy", 0.65)), "Candy");
	}
	
	@Test
	public void testSelectItemWithInsufficientBalanceAssertEquals() {
		machine.insertCoin(new Coin(1.0, 0.10));
		machine.insertCoin(new Coin(1.0, 0.10));
		Item item = new Item("Chips", 0.50);
		assertEquals(machine.selectItem(item), "Price not full paid, remaining: ");
	}

}
