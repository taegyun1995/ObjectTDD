package objectTdd.legacyRefactoring.refactoring;

public class RefactoringService {

    private final ILogger logger;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public RefactoringService(ILogger logger, OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.logger = logger;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public boolean processOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            logger.log("Order ID is invalid.");
            return false;
        }

        Order order = orderRepository.getOrder(orderId).orElseThrow(
                () -> new OrderNotFoundException("Order not found for ID: " + orderId)
        );

        if (!paymentRepository.makePayment(order.getTotal())) {
            logger.log("Payment failed for order: " + orderId);
            return false;
        }

        logger.log("Order processed: " + orderId);
        return true;
    }

}