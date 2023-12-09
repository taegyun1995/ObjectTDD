package objectTdd.legacyRefactoring.refactoring;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> getOrder(String orderId);

}