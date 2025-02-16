package com.gosnack.snack_order_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.event.KafkaProducer;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.repository.OrderRepository;
import com.gosnack.snack_order_api.utils.Converters;
import com.gosnack.snack_order_api.utils.OrderStatus;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class OrderService {

    @Autowired
    OrderRepository snackOrderRepository;

    @Autowired
    KafkaProducer kafkaProducer;


    private final Logger logger = getLogger(OrderService.class);

    private final Converters converters = new Converters();

    public List<OrderModel> getAllOrders() {
        logger.info("Iniciando busca de pedidos.");
        List<OrderModel> orders = snackOrderRepository.findAll();

        logger.info("Pedidos encontrados com sucesso.");

        return orders;
    }

    public OrderModel getOrderById(UUID orderId) {
        logger.info("Iniciando busca de pedido pelo id.");
        OrderModel order = snackOrderRepository.findById(orderId).orElseThrow();

        logger.info("Pedido com id: {} encontrado com sucesso.", orderId);

        return order;
    }

    public OrderModel createOrder(OrderRecord orderDTO) {

        OrderModel orderModel = converters.convertOrderRecordToOrderModel(orderDTO);

        snackOrderRepository.save(orderModel);

        try {
            String jsonMessage = new ObjectMapper().writeValueAsString(orderDTO);

            kafkaProducer.sendEvent("snack-order", jsonMessage);
        } catch (JsonProcessingException e) {
            logger.error("Erro ao converter objeto para JSON", e);
            throw new RuntimeException("Falha ao processar JSON", e);
        }

        logger.info("Pedido realizado com sucesso.");

        return orderModel;
    }

    public OrderModel updateOrder(UUID orderId, OrderRecord orderDTO) {
        logger.info("Iniciando atualização de pedido.");

        OrderModel orderModel = snackOrderRepository.findById(orderId).orElseThrow();

        converters.convertItemRecordToItemModel(orderDTO.items(), orderModel);

        logger.info("Pedido com id: {} atualizado com sucesso.", orderId);
        return snackOrderRepository.save(orderModel);
    }


    public void deleteOrder(UUID orderId) {
        logger.info("Iniciando exclusão de pedido.");
        OrderModel snackOrderModel = snackOrderRepository.findById(orderId).orElseThrow();

        logger.info("Pedido com id: {} excluído com sucesso.", orderId);
        snackOrderRepository.delete(snackOrderModel);
    }

}
