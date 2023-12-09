package objectTdd.cafe;

import objectTdd.cafe.kiosk.Kiosk;
import objectTdd.cafe.order.Order;
import objectTdd.cafe.order.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class KioskTdd {

    @Test
    @DisplayName("키오스크에서 커피를 주문했다. 얼마나 맛있을까 :)")
    void testCoffeeOrder() {
        Order mockOrder = mock(Order.class);
        OrderRepository mockOrderRepository = mock(OrderRepository.class);

        Kiosk kiosk = new Kiosk(mockOrderRepository);
        kiosk.placeOrder(mockOrder);

        verify(mockOrderRepository, times(1)).saveOrder(mockOrder);
    }

}