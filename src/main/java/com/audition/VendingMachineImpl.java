package com.audition;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

	private String defaultDisplayText = "Insert Coin";
	private double currentBalance = new Double(0.0);

	private static List<Coin> validCoin = new ArrayList<Coin>();

	static {
		validCoin.add(new Coin(1, 0.50));
		validCoin.add(new Coin(1, 0.25));
		validCoin.add(new Coin(1, 0.10));
	}

	public String insertCoin(Coin coin) {
		// TODO Auto-generated method stub
		if (coin.getValue() > 0) {
			if (validCoin.contains(coin)) {

				currentBalance = currentBalance + coin.getValue();
				return Double.toString(currentBalance);

			} else {
			
				throw new InvalidInsertCoinsException("Invalid Coin!, Insert nickels,dimes or quarters");
				
				
			}

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
