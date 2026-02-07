package com.food.burger.cheese;

public class CheddarCheese extends BurgerCheese {
	@Override
	public String toString() {
		return "Cheddar Cheese";
	}

	@Override
	public Double getPrice() {
		return .65;
	}
}