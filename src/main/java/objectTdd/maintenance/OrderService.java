package objectTdd.maintenance;

public class OrderService {

    private final IOrderRepository repository;

    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    public boolean makeOrder() {
        return repository.order();
    }

    public int getListCount() {
        return repository.getOrderCount();
    }

}