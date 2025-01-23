package com.gosnack.snack_order_api.controller;

import com.gosnack.snack_order_api.dto.SnackOrdeRecord;
import com.gosnack.snack_order_api.model.SnackOrderModel;
import com.gosnack.snack_order_api.service.SnackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/snack-order")
public class SnackOrderController {


    @Autowired
    SnackOrderService snackOrderService;

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<SnackOrderModel>> getSnackOrder() {

        return ResponseEntity.status(HttpStatus.OK).body(snackOrderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<SnackOrderModel> getSnackOrderById(@PathVariable String orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(snackOrderService.getOrderById(orderId));
    }


    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<SnackOrderModel> createSnackOrder(@RequestBody SnackOrdeRecord snackOrderDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(snackOrderService.createOrder(snackOrderDTO));
    }

    @PatchMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<SnackOrderModel> updateSnackOrder(@PathVariable String orderId, @RequestBody SnackOrdeRecord snackOrderDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(snackOrderService.updateOrder(orderId, snackOrderDTO));
    }

    @DeleteMapping("/{orderId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deleteSnackOrder(@PathVariable String orderId) {
        snackOrderService.deleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
