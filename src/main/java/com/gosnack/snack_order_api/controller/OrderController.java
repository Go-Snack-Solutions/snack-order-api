package com.gosnack.snack_order_api.controller;

import com.gosnack.snack_order_api.configuration.LoggerConfiguration;
import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.event.KafkaProducer;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.service.OrderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.hibernate.internal.CoreLogging.logger;
import static org.slf4j.LoggerFactory.getLogger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/snack-order")
public class OrderController {

    @Autowired
    OrderService orderService;

    private final Logger logger = getLogger(OrderController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderModel> getSnackOrder() {
        logger.info("Listando todos os pedidos");
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderModel getSnackOrderById(@PathVariable UUID orderId) {
        logger.info("Listando pedido por id {}", orderId);
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderModel createSnackOrder(@RequestBody OrderRecord snackOrderDTO) {
        logger.info("Criando pedido");

        return orderService.createOrder(snackOrderDTO);
    }

    @PatchMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderModel updateSnackOrder(@PathVariable UUID orderId, @RequestBody OrderRecord snackOrderDTO) {
        logger.info("Atualizando pedido por id {}", orderId);
        return orderService.updateOrder(orderId, snackOrderDTO);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Void deleteSnackOrder(@PathVariable UUID orderId) {
        logger.info("Deletando pedido por id {}", orderId);
        orderService.deleteOrder(orderId);
        return null;
    }

}
