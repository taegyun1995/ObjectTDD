package objectTdd.cafe;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public Kiosk() {
    }

    public void order(Order order) {
        orders.add(order);
    }
}