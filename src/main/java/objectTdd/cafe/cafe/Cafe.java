package objectTdd.cafe.cafe;

import objectTdd.cafe.customer.Customer;
import objectTdd.cafe.customer.CustomerRepository;

import java.util.List;

public class Cafe {

    private CustomerRepository customerRepository;

    public Cafe() {
    }

    public Cafe(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void welcome(List<Customer> customers) {
        customers.forEach(customer -> {
            if (this.customerRepository.contains(customer)) {
                throw new IllegalArgumentException("뭐야.. 도플갱어다..");
            }
            this.customerRepository.addCustomer(customer);
        });
    }

}