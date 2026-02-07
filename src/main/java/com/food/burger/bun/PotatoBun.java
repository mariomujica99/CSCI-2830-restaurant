package com.food.burger.bun;

public class PotatoBun extends BurgerBun {
	@Override
	public String toString() {
		return "Potato Bun";
	}

	@Override
	public Double getPrice() {
		return 1.50;
	}
}