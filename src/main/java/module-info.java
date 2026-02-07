module com.food {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.food;
    exports com.food.burger;
    exports com.food.pizza;

    opens com.food to javafx.fxml;
}
