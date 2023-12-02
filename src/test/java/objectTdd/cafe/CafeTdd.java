package objectTdd.cafe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CafeTdd {

    @Test
    @DisplayName("카페에 손님이 들어왔다!!")
    void testUserComeInCafe() {
        Cafe cafe = new Cafe();
        Customer customer = new Customer();

        cafe.welcome(customer);

        assertNotNull(cafe);
        assertEquals(cafe.inUsers(), 1);
    }

    @Test
    @DisplayName("아니 뭐야 저 사람 들어와있는데 어떻게 또 들어온거지..?")
    void testDoppelgangerUser() {
        Cafe cafe = new Cafe();
        Customer customer = new Customer();

        cafe.welcome(customer);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cafe.welcome(customer);
        });
    }

    @Test
    @DisplayName("카페 영업 종료 했습니다.. 감사합니다 :)")
    void testUserGetOutCafe() {
        Cafe cafe = new Cafe();
        Customer customer = new Customer();

        cafe.getOut(customer);

        assertEquals(cafe.inUsers(), 0);
    }

}