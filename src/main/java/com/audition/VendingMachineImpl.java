package com.audition;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

	private String defaultDisplayText = "Insert Coin";
	private double currentBalance = new Double(0.0);
	private double currentItemPrice;
	private String currentItem;
	private State state;

	private static List<Coin> validCoin = new ArrayList<Coin>();

	static {
		validCoin.add(new Coin(1, 0.50));
		validCoin.add(new Coin(1, 0.25));
		validCoin.add(new Coin(1, 0.10));
	}

	private static List<Item> validItem = new ArrayList<Item>();

	static {
		validItem.add(new Item("Cola", new Double(1.0)));
		validItem.add(new Item("Chips", new Double(0.50)));
		validItem.add(new Item("Candy", new Double(0.65)));
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

		currentItemPrice = item.getPrice();
		currentItem = item.getName();

		if (!currentItem.isEmpty() && validItem.contains(item)) {

			state = State.ITEM_DISPOSED;
		}
		return currentItem;
	}

	public List<Coin> returnChange() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Coin> returnCoins() {
		// TODO Auto-generated method stub
		return null;
	}

	// method to get currentBalance in the Vending Machine

	public Double getAmount() {

		return currentBalance;
	}

}
