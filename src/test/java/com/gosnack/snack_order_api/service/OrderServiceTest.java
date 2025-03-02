//package com.gosnack.snack_order_api.service;
//
//import com.gosnack.snack_order_api.dto.ItemRecord;
//import com.gosnack.snack_order_api.dto.OrderRecord;
//import com.gosnack.snack_order_api.model.OrderModel;
//import com.gosnack.snack_order_api.repository.OrderRepository;
//import com.gosnack.snack_order_api.utils.Converters;
//import com.gosnack.snack_order_api.utils.OrderStatus;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class OrderServiceTest {
//
//    @Mock
//    private OrderRepository snackOrderRepository;
//
//    @Mock
//    private Converters converters;
//
//    @InjectMocks
//    private OrderService orderService;
//
//    private OrderModel orderModel;
//    private OrderRecord orderRecord;
//    private UUID orderId;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        orderId = UUID.randomUUID();
//        orderModel = new OrderModel(); // Dados fictícios do pedido
//        orderRecord = new OrderRecord(
//                1L,
//                List.of(new ItemRecord(1L, "Item Teste", 10.0)),
//                OrderStatus.PEDIDO_ACEITO
//        );
//    }
//
//    // CENÁRIOS POSITIVOS
//
//    @Test
//    void testGetAllOrders() {
//        when(snackOrderRepository.findAll()).thenReturn(List.of(orderModel));
//
//        List<OrderModel> orders = orderService.getAllOrders();
//
//        assertNotNull(orders);
//        assertFalse(orders.isEmpty());
//        verify(snackOrderRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testGetOrderById() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.of(orderModel));
//
//        OrderModel result = orderService.getOrderById(orderId);
//
//        assertNotNull(result);
//        verify(snackOrderRepository, times(1)).findById(orderId);
//    }
//
//    @Test
//    void testCreateOrder() {
//        when(converters.convertOrderRecordToOrderModel(orderRecord)).thenReturn(orderModel);
//        when(snackOrderRepository.save(orderModel)).thenReturn(orderModel);
//
//        OrderModel result = orderService.createOrder(orderRecord);
//
//        assertNotNull(result);
//        verify(converters, times(1)).convertOrderRecordToOrderModel(orderRecord);
//        verify(snackOrderRepository, times(1)).save(orderModel);
//    }
//
//    @Test
//    void testUpdateOrder() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.of(orderModel));
//        when(snackOrderRepository.save(orderModel)).thenReturn(orderModel);
//
//        OrderModel result = orderService.updateOrder(orderId, orderRecord);
//
//        assertNotNull(result);
//        verify(snackOrderRepository, times(1)).findById(orderId);
//        verify(converters, times(1)).convertItemRecordToItemModel(orderRecord.items(), orderModel);
//        verify(snackOrderRepository, times(1)).save(orderModel);
//    }
//
//    @Test
//    void testDeleteOrder() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.of(orderModel));
//        doNothing().when(snackOrderRepository).delete(orderModel);
//
//        orderService.deleteOrder(orderId);
//
//        verify(snackOrderRepository, times(1)).findById(orderId);
//        verify(snackOrderRepository, times(1)).delete(orderModel);
//    }
//
//    // CENÁRIOS NEGATIVOS
//
//    @Test
//    void testGetOrderByIdNotFound() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> orderService.getOrderById(orderId));
//
//        verify(snackOrderRepository, times(1)).findById(orderId);
//    }
//
//    @Test
//    void testCreateOrderConversionFails() {
//        when(converters.convertOrderRecordToOrderModel(orderRecord)).thenThrow(new RuntimeException("Erro na conversão"));
//
//        assertThrows(RuntimeException.class, () -> orderService.createOrder(orderRecord));
//
//        verify(converters, times(1)).convertOrderRecordToOrderModel(orderRecord);
//        verifyNoInteractions(snackOrderRepository);
//    }
//
//    @Test
//    void testCreateOrderRepositoryFails() {
//        when(converters.convertOrderRecordToOrderModel(orderRecord)).thenReturn(orderModel);
//        when(snackOrderRepository.save(orderModel)).thenThrow(new RuntimeException("Erro ao salvar no repositório"));
//
//        assertThrows(RuntimeException.class, () -> orderService.createOrder(orderRecord));
//
//        verify(converters, times(1)).convertOrderRecordToOrderModel(orderRecord);
//        verify(snackOrderRepository, times(1)).save(orderModel);
//    }
//
//    @Test
//    void testDeleteOrderNotFound() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> orderService.deleteOrder(orderId));
//
//        verify(snackOrderRepository, times(1)).findById(orderId);
//        verify(snackOrderRepository, never()).delete(any());
//    }
//
//    @Test
//    void testUpdateOrderNotFound() {
//        when(snackOrderRepository.findById(orderId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> orderService.updateOrder(orderId, orderRecord));
//
//        verify(snackOrderRepository, times(1)).findById(orderId);
//        verify(snackOrderRepository, never()).save(any());
//    }
//}