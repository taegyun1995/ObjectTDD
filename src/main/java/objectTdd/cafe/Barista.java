package objectTdd.cafe;

public class Barista {

    public Barista() {
    }

    public Coffee makeCoffee(Coffee coffee) {
        return new Coffee(coffee.getCoffeeType(), coffee.getCoffeeSize());
    }

    public Coffee serveCoffee(Coffee coffee) {
        return makeCoffee(coffee);
    }

}