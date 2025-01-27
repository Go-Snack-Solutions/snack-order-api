package com.gosnack.snack_order_api.service;

import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.repository.OrderRepository;
import com.gosnack.snack_order_api.utils.OrderStatus;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class OrderService {

    @Autowired
    OrderRepository snackOrderRepository;

    private final Logger logger = getLogger(OrderService.class);

    public List<OrderModel> getAllOrders() {
        logger.info("Iniciando busca de pedidos.");
        List<OrderModel> orders = snackOrderRepository.findAll();

        logger.info("Pedidos encontrados com sucesso.");

        return orders;
    }

    public OrderModel getOrderById(Long orderId) {
        logger.info("Iniciando busca de pedido pelo id.");
        OrderModel order = snackOrderRepository.findById(orderId).orElseThrow();

        logger.info("Pedido com id: {} encontrado com sucesso.", orderId);

        return order;
    }

    public OrderRecord createOrder(OrderRecord orderDTO) {
        var orderModel = new OrderModel();

        orderModel.setOrderStatus(OrderStatus.PEDIDO_ACEITO);

        if (orderDTO.items() != null) {
            List<ItemModel> itemModels = orderDTO.items().stream().map(itemRecord -> {
                var itemModel = new ItemModel();
                itemModel.setItemName(itemRecord.itemName());
                itemModel.setItemPrice(itemRecord.itemPrice());
                itemModel.setOrders(orderModel);
                return itemModel;
            }).toList();

            orderModel.setItems(itemModels);
        }

        snackOrderRepository.save(orderModel);

        logger.info("Pedido realizado com sucesso.");

        return orderDTO;
    }

    public OrderModel updateOrder(Long orderId, OrderRecord snackOrderDTO) {
        logger.info("Iniciando atualização de pedido.");

        OrderModel snackOrderModel = snackOrderRepository.findById(orderId).orElseThrow();
        BeanUtils.copyProperties(snackOrderDTO, snackOrderModel);
        //TODO
        // Implementar a lógica de atualização de pedido

        logger.info("Pedido com id: {} atualizado com sucesso.", orderId);
        return snackOrderRepository.save(snackOrderModel);
    }

    public void deleteOrder(Long orderId) {
        logger.info("Iniciando exclusão de pedido.");
        OrderModel snackOrderModel = snackOrderRepository.findById(orderId).orElseThrow();

        logger.info("Pedido com id: {} excluído com sucesso.", orderId);
        snackOrderRepository.delete(snackOrderModel);
    }

}
