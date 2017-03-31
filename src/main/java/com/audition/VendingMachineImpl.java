package com.audition;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Vending Machine Interface
 * @author saritha
 *
 */
public class VendingMachineImpl implements VendingMachine {

	private String defaultDisplayText = "Insert Coin";
	private double currentBalance = new Double(0.0);
	private double currentItemPrice;
	private String currentItem;
	private State state;
	private List<Coin> coins = new ArrayList<Coin>();
	private double currentCoinValue;

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

	public String insertCoin(Coin coin) throws InvalidInsertCoinsException {
		// TODO Auto-generated method stub
		if (coin.getValue() > 0) {
			if (validCoin.contains(coin)) {
				currentCoinValue = coin.getValue();
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

	public String selectItem(Item item) throws NotFullPaidException {
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

			} else if (currentBalance > currentItemPrice) {

				returnChange();

			}

			else {

				double inSufficientAmountBalance = currentItemPrice - currentBalance;
				throw new NotFullPaidException("Price not full paid, remaining :", inSufficientAmountBalance);
			}
		} else {
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
		double changeAmount = currentBalance - currentCoinValue;
		List<Coin> change = getChange(changeAmount);
		currentBalance = new Double(0.0);
		state = State.DEFAULT;
		return change;
	}

	private List<Coin> getChange(double amount) throws NotSufficientChangeException {
		// TODO Auto-generated method stub
		List<Coin> changes = new ArrayList<Coin>();

		if (amount > 0) {

			double balance = amount;
			while (balance > 0) {

				if ((balance >= 0.25) && (validCoin.contains(new Coin(1, 0.25)))) {

					changes.add(new Coin(1, 0.25));
					balance = balance - 0.25;
					continue;

				} else if ((balance >= 0.50) && (validCoin.contains(new Coin(1, 0.50)))) {

					changes.add(new Coin(1, 0.50));
					balance = balance - 0.50;
					continue;
				} else if ((balance >= 0.10) && (validCoin.contains(new Coin(1, 0.10)))) {

					changes.add(new Coin(1, 0.10));
					balance = balance - 0.10;
					continue;
				}
				else {
					
					state = State.NO_CHANGE_DEFAULT;
					throw new NotSufficientChangeException("Not Sufficient Change, please try another Item");
				}
			}
		}
		return changes;
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
