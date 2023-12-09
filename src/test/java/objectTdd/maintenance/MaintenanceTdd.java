package objectTdd.maintenance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MaintenanceTdd {

    private IOrderRepository mockRepository;
    private OrderService sut;

    @BeforeEach
    void setup() {
        mockRepository = mock(IOrderRepository.class);
        sut = new OrderService(mockRepository);
    }

    @Test
    void testStateBased() {
        when(mockRepository.order()).thenReturn(true);
        when(mockRepository.getOrderCount()).thenReturn(1);

        boolean orderResult = sut.makeOrder();

        assertTrue(orderResult);
        assertEquals(1, sut.getListCount());
    }

    @Test
    void testBehaviorBased() {
        IOrderRepository mockRepository = mock(IOrderRepository.class);
        when(mockRepository.order()).thenReturn(true);

        OrderService sut = new OrderService(mockRepository);
        sut.makeOrder();

        verify(mockRepository).order();
    }

    @Test
    void testBehaviorBasedV2() {
        when(mockRepository.order()).thenReturn(true);

        sut.makeOrder();

        verify(mockRepository).order();
    }

}