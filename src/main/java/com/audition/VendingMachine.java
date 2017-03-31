package com.audition;

import java.util.List;

/**
 * Declare public API for Vending Machine
 * @author saritha
 *
 */
public interface VendingMachine {
	
	public String insertCoin(Coin coin);
	public String selectItem(Item item);
	public List<Coin> returnChange();
	public List<Coin> returnCoins();

}
