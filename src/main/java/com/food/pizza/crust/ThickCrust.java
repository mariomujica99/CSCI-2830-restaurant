package com.food.pizza.crust;

public class ThickCrust extends PizzaCrust {
	@Override
	public String toString() {
		return "Thick Crust";
	}

	public String toNiceString() {
		return super.toNiceString();
	}

	@Override
	public Double getPrice() {
		return 5.00;
	}
}