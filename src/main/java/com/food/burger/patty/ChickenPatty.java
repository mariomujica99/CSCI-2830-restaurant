package com.food.burger.patty;

public class ChickenPatty extends BurgerPatty {
	@Override
	public String toString() {
		return "Chicken Patty";
	}

	@Override
	public Double getPrice() {
		return 3.10;
	}
}