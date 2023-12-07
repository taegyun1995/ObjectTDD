package objectTdd.cafe;

import objectTdd.cafeTdd.cafe.Cafe;
import objectTdd.cafeTdd.customer.Customer;
import objectTdd.cafeTdd.customer.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CafeTdd {

    @Test
    @DisplayName("카페에 손님이 들어왔다!!")
    void testUserComeInCafe() {
        Customer mockCustomer = mock(Customer.class);
        List<Customer> customers = new ArrayList<>();
        customers.add(mockCustomer);

        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.contains(mockCustomer)).thenReturn(false);

        Cafe cafe = new Cafe(customerRepository);
        cafe.welcome(customers);

        verify(customerRepository, times(1)).contains(mockCustomer);
        verify(customerRepository, times(1)).addCustomer(mockCustomer);
    }

    @Test
    @DisplayName("아니 뭐야 저 사람 들어와있는데 어떻게 또 들어온거지..?")
    void testDoppelgangerUser() {
        Customer mockCustomer = mock(Customer.class);
        List<Customer> customers = new ArrayList<>();
        customers.add(mockCustomer);

        CustomerRepository customerRepository = mock(CustomerRepository.class);
        when(customerRepository.contains(mockCustomer)).thenReturn(true);

        Cafe cafe = new Cafe(customerRepository);

        assertThrows(IllegalArgumentException.class, () -> cafe.welcome(customers));
    }

    @Test
    @DisplayName("영업 종료했습니다:) 감사합니다ㅎㅎ ")
    void testCloseOfCafe() {
        List<Customer> customers = new ArrayList<>();

        CustomerRepository customerRepository = mock(CustomerRepository.class);
        Cafe cafe = new Cafe(customerRepository);

        cafe.welcome(customers);

        verify(customerRepository, never()).contains(any(Customer.class));
        verify(customerRepository, never()).addCustomer(any(Customer.class));
    }

}