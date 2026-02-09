## Rio's Restaurant Ordering System

## Overview

Rio's Restaurant is an interactive ordering application that allows customers to build custom pizzas and burgers with various ingredients. The application tracks user selections, calculates prices dynamically, and generates an itemized receipt with all items sorted by price. This project is a JavaFX-based food ordering application developed for CSCI 2830: Object-Oriented Software Engineering. I used OOP principles including inheritance, polymorphism, encapsulation, and the MVC design pattern.

## Demo Video

<div align="center">

### Application Walkthrough

https://github.com/user-attachments/assets/b02f2b6b-f9b1-482c-9924-df9cb6346db9

**Watch the complete demo showing pizza building, burger customization, and checkout process**

</div>

## Technologies
- Java
- JavaFX
- Maven
- FXML

## Features

Build-Your-Own Pizza
- Choice of crust type (thin or thick) and ingredient (flour or cauliflower)
- Multiple sauce options (tomato or alfredo)
- Six topping varieties organized by category (meat, veggie, cheese)
- Real-time price calculation

Build-Your-Own Burger
- Three bun options (sesame seed, brioche, potato)
- Four patty types (beef, chicken, veggie, impossible)
- Four cheese varieties (american, swiss, cheddar, pepperjack)
- Seven garnish options (tomato, lettuce, pickle, bacon, guacamole, onion rings, fried egg)
- Real-time price calculation

Order Management
- Add multiple pizzas and burgers to a single order
- View itemized breakdown for each item
- Automatic sorting of items by price
- Running total calculation
- Receipt generation with order summary

User Interface
- Input validation (create button disabled until all required selections made)
- Clear visual feedback for selections
- Easy navigation between screens
- Professional receipt display

## Usage

Homepage
 - Select "Build Pizza" or "Build Burger"

Build Your Item
 - Pizza: Select crust type, crust ingredient, sauce, and at least one topping
 - Burger: Select bun, patty, cheese, and at least one garnish
 - The "Create" button enables once all required selections are made

Review and Add to Order
 - View the itemized breakdown with prices
 - Return to homepage to add more items or proceed to checkout

Checkout
 - View complete order summary on receipt page
 - Items automatically sorted by price
 - Total price calculated at bottom
 - Click "Complete Order" to finalize

Complete Order
 - Thank you message displayed
 - Exit application when ready

## Learning Outcomes

### Design Patterns
- MVC (Model-View-Controller): Separation of concerns with distinct controller classes for each view
- Template Method Pattern: Abstract base classes define common behavior while subclasses implement specifics
- Strategy Pattern: Composition-based design for combining pizza/burger components

### Object-Oriented Engineering Principles

#### Inheritance Hierarchies
```
MenuItem (Interface)
├── Pizza
├── Burger
├── PizzaCrust
│   ├── ThinCrust
│   └── ThickCrust
├── PizzaSauce
│   ├── TomatoSauce
│   └── AlfredoSauce
├── PizzaTopping
│   ├── MeatTopping
│   │   ├── PepperoniTopping
│   │   └── SausageTopping
│   ├── VeggieTopping
│   │   ├── PepperTopping
│   │   └── MushroomTopping
│   └── CheeseTopping
│       ├── MozzarellaTopping
│       └── AsiagoTopping
├── BurgerBun
│   ├── SesameSeedBun
│   ├── BriocheBun
│   └── PotatoBun
├── BurgerPatty
│   ├── BeefPatty
│   ├── ChickenPatty
│   ├── VeggiePatty
│   └── ImpossiblePatty
├── BurgerCheese
│   ├── AmericanCheese
│   ├── SwissCheese
│   ├── CheddarCheese
│   └── PepperjackCheese
└── BurgerGarnish
    ├── TomatoGarnish
    ├── LettuceGarnish
    ├── PickleGarnish
    ├── BaconGarnish
    ├── GuacamoleGarnish
    ├── OnionRingGarnish
    └── FriedEggGarnish
```

#### Polymorphism
- All food components implement the `MenuItem` interface
- Enables consistent price calculation and display across different item types
- `Comparable<MenuItem>` implementation allows automatic sorting by price

#### Encapsulation
- Private fields with public getter/setter methods
- Component lists managed internally by Pizza and Burger classes
- Centralized receipt management through the App class

#### Composition
- Pizza and Burger classes composed of multiple MenuItem components
- Flexible combination of ingredients through ArrayList collections

## Academic Integrity Notice

This project is submitted as academic work for CSCI 2830: Object-Oriented Software Engineering. The code is provided for portfolio purposes. Please do not copy or reproduce for academic submissions.
