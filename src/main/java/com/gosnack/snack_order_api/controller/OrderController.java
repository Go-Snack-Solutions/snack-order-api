package com.gosnack.snack_order_api.controller;

import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/snack-order")
public class OrderController {


    @Autowired
    OrderService orderService;

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<OrderModel>> getSnackOrder() {

        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderModel> getSnackOrderById(@PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(orderId));
    }


    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderModel> createSnackOrder(@RequestBody OrderRecord snackOrderDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(snackOrderDTO));
    }

    @PatchMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<OrderModel> updateSnackOrder(@PathVariable Long orderId, @RequestBody OrderRecord snackOrderDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderId, snackOrderDTO));
    }

    @DeleteMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deleteSnackOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
