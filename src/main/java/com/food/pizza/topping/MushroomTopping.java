package com.food.pizza.topping;

public class MushroomTopping extends VeggieTopping {
	public String toString() {
		return "Mushroom Topping";
	}
	
	@Override
	public Double getPrice() {
		return 2.35;
	}
}