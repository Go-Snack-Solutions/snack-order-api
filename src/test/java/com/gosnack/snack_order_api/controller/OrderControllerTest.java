//package com.gosnack.snack_order_api.controller;
//
//import com.gosnack.snack_order_api.model.OrderModel;
//import com.gosnack.snack_order_api.service.OrderService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class OrderControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private OrderService orderService;
//
//    @InjectMocks
//    private OrderController orderController;
//
//    private List<OrderModel> mockOrders;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
//
//        // Criando pedidos de exemplo para o teste
//        OrderModel order1 = mock(OrderModel.class);
//        OrderModel order2 = mock(OrderModel.class);
//        mockOrders = Arrays.asList(order1, order2);
//    }
//
//    @Test
//    void getOrder_ShouldReturnListOfOrders() throws Exception {
//        when(orderService.getAllOrders()).thenReturn(mockOrders);
//
//        mockMvc.perform(get("/snack-order")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(mockOrders.size()));
//
//        verify(orderService, times(1)).getAllOrders();
//    }
//}
