package com.food.burger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.food.MenuItem;
import com.food.burger.bun.*;
import com.food.burger.patty.*;
import com.food.burger.cheese.*;
import com.food.burger.garnish.*;

public class BurgerTest {
    @Test
    public void testAddGarnish() {
        Burger burger = new Burger();
        BurgerGarnish tomato = new TomatoGarnish();

        Integer len = burger.getGarnish().size();

        burger.addGarnish(tomato);
        assertEquals(len + 1, burger.getGarnish().size());
    }

    @Test
    public void testBurgerOrder() {
        Burger burger = new Burger();

        Double price = burger.getPrice();
        
        burger.setBun(new SesameSeedBun());
        burger.setPatty(new BeefPatty());
        burger.setCheese(new AmericanCheese());
        burger.addGarnish(new LettuceGarnish());
        burger.addGarnish(new PickleGarnish());

        Double expectedTotal = price + burger.getPrice();
        assertEquals(expectedTotal, burger.getPrice(), 0.001);
    }
    
    @Test
    public void testMenuSort() {
        Burger burger = new Burger();

        burger.setBun(new SesameSeedBun());
        burger.setPatty(new BeefPatty());
        burger.setCheese(new AmericanCheese());
        burger.addGarnish(new LettuceGarnish());
        burger.addGarnish(new PickleGarnish());

        Double previousPrice = -1.0;
        Boolean isSorted = true;
        burger.sortItems();
        for (MenuItem m : burger.getSelectionList()) {
            isSorted = (previousPrice < m.getPrice());
            previousPrice = m.getPrice();
            if (! isSorted) {
                break;
            }
        }
        assertTrue(isSorted);
    }
}