package com.food.burger.patty;

public class ImpossiblePatty extends BurgerPatty {
	@Override
	public String toString() {
		return "Impossible Patty";
	}

	@Override
	public Double getPrice() {
		return 4.00;
	}
}