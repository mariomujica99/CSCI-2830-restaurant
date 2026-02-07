package com.food.burger.patty;

public class VeggiePatty extends BurgerPatty {
	@Override
	public String toString() {
		return "Veggie Patty";
	}

	@Override
	public Double getPrice() {
		return 3.55;
	}
}