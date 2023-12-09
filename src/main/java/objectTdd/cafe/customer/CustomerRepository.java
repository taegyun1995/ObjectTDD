package objectTdd.cafe.customer;

public interface CustomerRepository {

    boolean contains(Customer customer);
    void addCustomer(Customer customer);

}