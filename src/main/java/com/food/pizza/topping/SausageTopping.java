package com.food.pizza.topping;

public class SausageTopping extends MeatTopping {
	public String toString() {
		return "Sausage Topping";
	}
	
	@Override
	public Double getPrice() {
		return 2.75;
	}
}