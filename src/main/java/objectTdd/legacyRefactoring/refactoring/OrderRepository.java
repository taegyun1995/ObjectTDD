package objectTdd.legacyRefactoring.refactoring;

import objectTdd.legacyRefactoring.legacy.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> getOrder(String orderId);

}