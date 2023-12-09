package objectTdd.legacyRefactoring.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        mockOrder = new Order("orderId", 100.0);
    }

    @Test
    @DisplayName("결제가 성공적으로 이루어졌네요! :)")
    void testSuccessOrder() {
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

    @Test
    @DisplayName("입력 값 orderId가 null인 경우")
    void testNullOrderId() {
        boolean result = sut.processOrder(null);

        assertFalse(result);
        verify(mockLogger).log("Order ID is invalid.");
    }

    @Test
    @DisplayName("입력 값 orderId가 비어있는 경우")
    void testEmptyOrderId() {
        String emptyOrderId = "";

        boolean result = sut.processOrder(emptyOrderId);

        assertFalse(result);
        verify(mockLogger).log("Order ID is invalid.");
    }

    @Test
    @DisplayName("어 그 주문 없는건데..?")
    void testInvalidOrderId() {
        String orderId = "orderId";

        when(mockOrderRepository.getOrder(orderId)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> sut.processOrder(orderId));
        verify(mockOrderRepository, times(1)).getOrder(orderId);
    }

    @Test
    @DisplayName("잉 결제가 안됐으요;;")
    void testFailOrder() {
        String orderId = "orderId";
        double pay = 100.0;

        when(mockOrderRepository.getOrder(orderId)).thenReturn(Optional.of(mockOrder));
        when(mockPaymentRepository.makePayment(pay)).thenReturn(false);

        boolean result = sut.processOrder(orderId);

        assertFalse(result);
        verify(mockPaymentRepository, times(1)).makePayment(pay);
    }

}
