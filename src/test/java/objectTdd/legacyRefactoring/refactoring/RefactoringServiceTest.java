package objectTdd.legacyRefactoring.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class RefactoringServiceTest {

    private ILogger mockLogger;
    private OrderRepository mockOrderRepository;
    private PaymentRepository mockPaymentRepository;
    private RefactoringService sut;
    private Order mockOrder;

    @BeforeEach
    void setUp() {
        mockLogger = mock(ILogger.class);
        mockOrderRepository = mock(OrderRepository.class);
        mockPaymentRepository = mock(PaymentRepository.class);
        sut = new RefactoringService(mockLogger, mockOrderRepository, mockPaymentRepository);
        mockOrder = new Order("validOrderId", 100.0); // 실제 Order 객체 생성
    }

    @Test
    @DisplayName("결제가 성공적으로 이루어졌네요! :)")
    void processValidOrder() {
        String orderId = "orderId";
        Double pay = 100.0;

        when(mockOrderRepository.getOrder(orderId)).thenReturn(Optional.of(mockOrder));
        when(mockPaymentRepository.makePayment(pay)).thenReturn(true);

        boolean result = sut.processOrder(orderId);

        assertTrue(result);
        verify(mockOrderRepository, times(1)).getOrder(orderId);
        verify(mockPaymentRepository, times(1)).makePayment(pay);
        verify(mockLogger).log("Order processed: " + orderId);
    }

}
