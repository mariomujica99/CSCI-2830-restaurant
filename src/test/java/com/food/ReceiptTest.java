package com.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.food.pizza.*;
import com.food.pizza.topping.*;
import com.food.pizza.crust.*;
import com.food.pizza.sauce.*;

import com.food.burger.*;
import com.food.burger.bun.*;
import com.food.burger.patty.*;
import com.food.burger.cheese.*;
import com.food.burger.garnish.*;

public class ReceiptTest {
    @Test
    public void testPizzaOrder() {
        Pizza pizza = new Pizza();
        Receipt receipt = App.getReceipt();

        Double total = receipt.getTotalPrice();
        
        pizza.setCrust(new ThinCrust());
        pizza.setSauce(new TomatoSauce());
        pizza.addTopping(new PepperoniTopping());
        pizza.addTopping(new MozzarellaTopping());

        receipt.addPizza(pizza);

        Double expectedTotal = total + pizza.getPrice();
        assertEquals(expectedTotal, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void testTwoPizzasOrder() {
        Pizza pizza = new Pizza();
        Receipt receipt = App.getReceipt();

        Double total = receipt.getTotalPrice();
        
        pizza.setCrust(new ThinCrust());
        pizza.setSauce(new TomatoSauce());
        pizza.addTopping(new PepperoniTopping());
        pizza.addTopping(new MozzarellaTopping());

        receipt.addPizza(pizza);
        Pizza pizza2 = new Pizza();

        pizza2.setCrust(new ThickCrust());
        pizza2.setSauce(new AlfredoSauce());
        pizza2.addTopping(new SausageTopping());
        pizza2.addTopping(new AsiagoTopping());

        receipt.addPizza(pizza2);

        Double expectedTotal = total + pizza.getPrice() + pizza2.getPrice();
        assertEquals(expectedTotal, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void testBurgerOrder() {
        Burger burger = new Burger();
        Receipt receipt = App.getReceipt();

        Double total = receipt.getTotalPrice();
        
        burger.setBun(new SesameSeedBun());
        burger.setPatty(new BeefPatty());
        burger.setCheese(new AmericanCheese());
        burger.addGarnish(new LettuceGarnish());
        burger.addGarnish(new PickleGarnish());

        receipt.addBurger(burger);

        Double expectedTotal = total + burger.getPrice();
        assertEquals(expectedTotal, receipt.getTotalPrice(), 0.001);
    }

    @Test
    public void testOrderSort() {
        Pizza pizza = new Pizza();
        Receipt receipt = App.getReceipt();
        
        pizza.setCrust(new ThinCrust());
        pizza.setSauce(new TomatoSauce());
        pizza.addTopping(new PepperoniTopping());
        pizza.addTopping(new MozzarellaTopping());

        pizza.sortItems();
        receipt.addPizza(pizza);

        Burger burger = new Burger();

        burger.setBun(new SesameSeedBun());
        burger.setPatty(new BeefPatty());
        burger.setCheese(new AmericanCheese());
        burger.addGarnish(new LettuceGarnish());
        burger.addGarnish(new PickleGarnish());

        burger.sortItems();
        receipt.addBurger(burger);

        Double previousPrice = -1.0;
        Boolean isSorted = true;

        receipt.sortPizzasByPrice();
        receipt.sortBurgersByPrice();

        for (MenuItem m : receipt.getAllItemsSorted()) {
            isSorted = (previousPrice <= m.getPrice());
            previousPrice = m.getPrice();
            if (! isSorted) {
                break;
            }
        }
        assertTrue(isSorted);
    }
}