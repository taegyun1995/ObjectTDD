package objectTdd.cafe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static objectTdd.cafe.CoffeeSize.*;
import static objectTdd.cafe.CoffeeType.AMERICANO;
import static objectTdd.cafe.CoffeeType.LATTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaristaTdd {

    @Test
    @DisplayName("커피 주문이다 !! 맛있게 만들어줘야지 !")
    void testMakeCoffee() {
        Barista barista = new Barista();
        Coffee coffee = new Coffee(AMERICANO, VENTI);

        Coffee makeCoffee = barista.makeCoffee(coffee);

        assertNotNull(makeCoffee);
        assertEquals(AMERICANO, makeCoffee.getCoffeeType());
        assertEquals(VENTI, makeCoffee.getCoffeeSize());
    }

    @Test
    @DisplayName("커피 나왔습니다 ~ 감사합니다 :)")
    void testServeCoffee() {
        Barista barista = new Barista();
        Coffee coffee = new Coffee(LATTE, TALL);

        Coffee makeCoffee = barista.makeCoffee(coffee);
        Coffee serveCoffee = barista.serveCoffee(makeCoffee);

        assertNotNull(serveCoffee);
        assertEquals(LATTE, serveCoffee.getCoffeeType());
        assertEquals(TALL, serveCoffee.getCoffeeSize());
    }

}