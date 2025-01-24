package com.gosnack.snack_order_api.service;

import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.repository.OrderRepository;
import com.gosnack.snack_order_api.utils.OrderStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository snackOrderRepository;

    @Autowired
    ItemService itemService;

    public List<OrderModel> getAllOrders() {
        return snackOrderRepository.findAll();
    }

    public OrderModel getOrderById(Long orderId) {
        return snackOrderRepository.findById(orderId).orElseThrow();
    }

    public OrderModel createOrder(OrderRecord orderDTO) {
        var orderModel = new OrderModel();

        orderModel.setOrderStatus(OrderStatus.PEDIDO_ACEITO);


//        BeanUtils.copyProperties(orderDTO, orderModel, "items");

        if (orderDTO.items() != null) {
            List<ItemModel> itemModels = orderDTO.items().stream().map(itemRecord -> {
                var itemModel = new ItemModel();
                itemModel.setItemName(itemRecord.itemName());
                itemModel.setItemPrice(itemRecord.itemPrice());
                itemModel.setOrders(orderModel); // Relaciona com o pedido
                return itemModel;
            }).toList();

            orderModel.setItems(itemModels);
        }

        return snackOrderRepository.save(orderModel);
    }

    public OrderModel updateOrder(Long orderId, OrderRecord snackOrderDTO) {
        OrderModel snackOrderModel = snackOrderRepository.findById(orderId).orElseThrow();
        BeanUtils.copyProperties(snackOrderDTO, snackOrderModel);
        return snackOrderRepository.save(snackOrderModel);
    }

    public void deleteOrder(Long orderId) {
        OrderModel snackOrderModel = snackOrderRepository.findById(orderId).orElseThrow();
        snackOrderRepository.delete(snackOrderModel);
    }

}
