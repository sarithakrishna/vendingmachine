package com.audition;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {

	private String defaultDisplayText = "Insert Coin";

	public String insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		if (coin.getValue() > 0) {
			return null;
		} else {
			return defaultDisplayText;
		}
	}

	public String selectItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Coin> returnChange() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Coin> returnCoins() {
		// TODO Auto-generated method stub
		return null;
	}

}
