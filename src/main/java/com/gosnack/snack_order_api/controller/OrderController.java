package com.gosnack.snack_order_api.controller;

import com.gosnack.snack_order_api.configuration.LoggerConfiguration;
import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.service.OrderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import static org.hibernate.internal.CoreLogging.logger;
import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/snack-order")
public class OrderController {

    @Autowired
    OrderService orderService;

    private final Logger logger = getLogger(OrderController.class);

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<OrderModel>> getSnackOrder() {
        logger.info("Listando todos os pedidos");
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderModel> getSnackOrderById(@PathVariable Long orderId) {
        logger.info("Listando pedido por id {}", orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(orderId));
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderRecord> createSnackOrder(@RequestBody OrderRecord snackOrderDTO) {
        logger.info("Criando pedido");
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(snackOrderDTO));
    }

    @PatchMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderModel> updateSnackOrder(@PathVariable Long orderId, @RequestBody OrderRecord snackOrderDTO) {
        logger.info("Atualizando pedido por id {}", orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderId, snackOrderDTO));
    }

    @DeleteMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deleteSnackOrder(@PathVariable Long orderId) {
        logger.info("Deletando pedido por id {}", orderId);
        orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
