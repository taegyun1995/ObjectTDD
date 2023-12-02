package objectTdd.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private List<Customer> customers = new ArrayList<>();

    public Cafe() {
    }

    public Cafe(List<Customer> customers) {
        this.customers = customers;
    }

    public void welcome(Customer customer) {
        customers.add(customer);
    }

    public int inUsers() {
        return customers.size();
    }

    public void getOut(Customer customer) {
        customers.remove(customer);
    }

}