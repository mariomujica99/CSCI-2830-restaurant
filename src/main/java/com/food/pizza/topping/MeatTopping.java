package com.food.pizza.topping;

public class MeatTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Meat Topping";
	}
	
	@Override
	public Double getPrice() {
		return 2.65;
	}
}