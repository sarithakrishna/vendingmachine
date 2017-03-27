package com.audition;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVendingMachine {
	
	VendingMachineImpl machine = new VendingMachineImpl();
	
	@Test
	public void testDefaultDisplayAssertEquals() {
		Coin coin = new Coin(0.0,0.0);
		assertEquals(machine.insertCoin(coin),"Insert Coin");
		
	}
	

}
