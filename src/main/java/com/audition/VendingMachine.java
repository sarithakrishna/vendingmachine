package com.audition;

import java.util.List;

public interface VendingMachine {
	
	public String insertCoin(Coin coin);
	public String selectItem(Item item);
	public List<Coin> returnChange();
	public List<Coin> returnCoins();

}
