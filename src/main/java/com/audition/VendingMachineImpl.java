package com.audition;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

	private String defaultDisplayText = "Insert Coin";
	private double currentBalance = new Double(0.0);
	private double currentItemPrice;
	private String currentItem;
	private State state;
	private List<Coin> coins = new ArrayList<Coin>();

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
				coins.add(coin);
				returnCoins();
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
			if (currentBalance == currentItemPrice) {

				try {
					productDisposed();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				double inSufficientAmountBalance = currentItemPrice - currentBalance;
				throw new NotFullPaidException("Price not full paid, remaining :", inSufficientAmountBalance);
			}
		}
		else {
			state = State.DEFAULT;
			throw new SoldOutException("Sold Out, Select another item");
		}
		return currentItem;
	}

	private void productDisposed() throws InterruptedException {
		state = State.ITEM_DISPOSED;
		currentBalance = new Double(0.0);
		Thread.sleep(2000);
		state = State.DEFAULT;
	}

	public List<Coin> returnChange() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Coin> returnCoins() {
		// TODO Auto-generated method stub
		List<Coin> coinReturn = coins;
		currentBalance = new Double(0.0);
		state = State.DEFAULT;	
		return coinReturn;
	}

	// method to get currentBalance in the Vending Machine

	public Double getAmount() {

		return currentBalance;
	}

}
