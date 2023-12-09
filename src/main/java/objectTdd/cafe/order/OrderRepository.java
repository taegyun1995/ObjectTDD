package objectTdd.cafe.order;

public interface OrderRepository {

    void addOrder(Order order);
    void saveOrder(Order mockOrder);

}