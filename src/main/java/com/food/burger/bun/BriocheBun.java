package com.food.burger.bun;

public class BriocheBun extends BurgerBun {
	@Override
	public String toString() {
		return "Brioche Bun";
	}

	@Override
	public Double getPrice() {
		return 2.00;
	}
}