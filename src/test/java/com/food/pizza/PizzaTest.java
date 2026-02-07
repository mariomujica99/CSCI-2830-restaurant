package com.food.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.food.MenuItem;
import com.food.pizza.topping.*;
import com.food.pizza.crust.*;
import com.food.pizza.sauce.*;

public class PizzaTest {
    @Test
    public void testAddTopping() {
        Pizza pizza = new Pizza();
        PizzaTopping pepperoni = new PepperoniTopping();

        Integer len = pizza.getTopping().size();

        pizza.addTopping(pepperoni);
        assertEquals(len + 1, pizza.getTopping().size());
    }

    @Test
    public void testPizzaOrder() {
        Pizza pizza = new Pizza();

        Double price = pizza.getPrice();
        
        pizza.setCrust(new ThinCrust());
        pizza.setSauce(new TomatoSauce());
        pizza.addTopping(new PepperoniTopping());
        pizza.addTopping(new MozzarellaTopping());

        Double expectedTotal = price + pizza.getPrice();
        assertEquals(expectedTotal, pizza.getPrice(), 0.001);
    }

    @Test
    public void testMenuSort() {
        Pizza pizza = new Pizza();

        pizza.setCrust(new ThinCrust());
        pizza.setSauce(new TomatoSauce());
        pizza.addTopping(new PepperoniTopping());
        pizza.addTopping(new MozzarellaTopping());

        Double previousPrice = -1.0;
        Boolean isSorted = true;
        pizza.sortItems();
        for (MenuItem m : pizza.getSelectionList()) {
            isSorted = (previousPrice < m.getPrice());
            previousPrice = m.getPrice();
            if (! isSorted) {
                break;
            }
        }
        assertTrue(isSorted);
    }
}