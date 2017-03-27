package com.audition;

public class Coin {
	
	private double size, weight;

	public Coin(double size, double weight) {
		this.size = size;
		this.weight = weight;
	}
	
	public double getValue() {
		
		return weight / size ;
	}

	
}
