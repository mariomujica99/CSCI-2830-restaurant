package com.food.pizza.topping;

public class AsiagoTopping extends CheeseTopping {
	public String toString() {
		return "Asiago Topping";
	}
	
	@Override
	public Double getPrice() {
		return 2.55;
	}
}