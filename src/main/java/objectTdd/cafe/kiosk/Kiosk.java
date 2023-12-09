package objectTdd.cafe.kiosk;

import objectTdd.cafe.order.Order;
import objectTdd.cafe.order.OrderRepository;

public class Kiosk {

    private OrderRepository orderRepository;

    public Kiosk() {
    }

    public Kiosk(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        this.orderRepository.saveOrder(order);
    }

}