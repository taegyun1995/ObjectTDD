package objectTdd.cafe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static objectTdd.cafe.CoffeeSize.VENTI;
import static objectTdd.cafe.CoffeeType.AMERICANO;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KioskTdd {

    @Test
    @DisplayName("키오스크에서 커피를 주문했다. 얼마나 맛있을까 :)")
    void testCoffeeOrder() {
        Customer customer = new Customer();
        Kiosk kiosk = new Kiosk();

        customer.orderCoffee(kiosk, AMERICANO, VENTI);

        assertFalse(kiosk.getOrders().isEmpty());
        assertEquals(AMERICANO, kiosk.getOrders().get(0).getCoffeeType());
        assertEquals(VENTI, kiosk.getOrders().get(0).getCoffeeSize());
    }

}