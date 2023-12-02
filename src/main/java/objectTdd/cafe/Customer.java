package objectTdd.cafe;

public class Customer {

    public Customer() {
    }

    public void orderCoffee(Kiosk kiosk, CoffeeType coffeeType, CoffeeSize coffeeSize) {
        Coffee coffee = new Coffee(coffeeType, coffeeSize);
        kiosk.order(new Order(coffee));
    }

}