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
        if (order == null) {
            throw new IllegalArgumentException("주문이 비어있는디요..");
        }

        this.orderRepository.saveOrder(order);
    }

}