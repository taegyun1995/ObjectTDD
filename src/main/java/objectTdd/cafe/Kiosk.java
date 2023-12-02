package objectTdd.cafe;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private List<Coffee> orders = new ArrayList<>();

    public Kiosk() {
    }

    public void order(Coffee coffee) {
        orders.add(coffee);
    }

    public List<Coffee> getOrders() {
        return new ArrayList<>(orders);
    }

}