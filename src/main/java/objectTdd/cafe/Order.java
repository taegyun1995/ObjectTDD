package objectTdd.cafe;

public class Order {

    private Coffee coffee;

    public Coffee getCoffee() {
        return coffee;
    }

    public Order() {
    }

    public Order(Coffee coffee) {
        this.coffee = coffee;
    }

}