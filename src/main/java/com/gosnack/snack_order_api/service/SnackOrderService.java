package com.gosnack.snack_order_api.service;

import com.gosnack.snack_order_api.dto.SnackOrderDTO;
import com.gosnack.snack_order_api.model.SnackOrderModel;
import com.gosnack.snack_order_api.repository.SnackOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SnackOrderService {

    @Autowired
    SnackOrderRepository snackOrderRepository;

    public List<SnackOrderModel> getAllOrders() {
        return snackOrderRepository.findAll();
    }

    public SnackOrderModel getOrderById(String orderId) {
        return snackOrderRepository.findById(UUID.fromString(orderId)).orElseThrow();
    }

    public SnackOrderModel createOrder(SnackOrderDTO snackOrderDTO) {
        var snackOrderModel = new SnackOrderModel();
        BeanUtils.copyProperties(snackOrderDTO, snackOrderModel);
        return snackOrderRepository.save(snackOrderModel);
    }

    public SnackOrderModel updateOrder(String orderId, SnackOrderDTO snackOrderDTO) {
        SnackOrderModel snackOrderModel = snackOrderRepository.findById(UUID.fromString(orderId)).orElseThrow();
        BeanUtils.copyProperties(snackOrderDTO, snackOrderModel);
        return snackOrderRepository.save(snackOrderModel);
    }

    public SnackOrderModel deleteOrder(String orderId) {
        SnackOrderModel snackOrderModel = snackOrderRepository.findById(UUID.fromString(orderId)).orElseThrow();
        snackOrderRepository.delete(snackOrderModel);
        return snackOrderModel;
    }

}
