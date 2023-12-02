package objectTdd.cafe;

public class Coffee {

    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public CoffeeSize getCoffeeSize() {
        return coffeeSize;
    }

    public Coffee() {
    }

    public Coffee(CoffeeType coffeeType, CoffeeSize coffeeSize) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
    }

}