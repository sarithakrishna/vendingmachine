package com.audition;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVendingMachine {

	VendingMachineImpl machine = new VendingMachineImpl();

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

}
