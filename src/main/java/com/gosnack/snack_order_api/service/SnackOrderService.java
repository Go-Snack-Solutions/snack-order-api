package com.gosnack.snack_order_api.service;

import com.gosnack.snack_order_api.dto.SnackOrdeRecord;
import com.gosnack.snack_order_api.model.SnackOrderModel;
import com.gosnack.snack_order_api.repository.SnackOrderRepository;
import com.gosnack.snack_order_api.utils.SnackOrderStatus;
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

    public SnackOrderModel createOrder(SnackOrdeRecord snackOrderDTO) {
        var snackOrderModel = new SnackOrderModel();
        snackOrderModel.setOrderId("ORDER_" + UUID.randomUUID());
        snackOrderModel.setSnackOrderStatus(SnackOrderStatus.PEDIDO_ACEITO);
        snackOrderModel.setItem(snackOrderDTO.item());

        return snackOrderRepository.save(snackOrderModel);
    }

    public SnackOrderModel updateOrder(String orderId, SnackOrdeRecord snackOrderDTO) {
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
