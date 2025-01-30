package com.gosnack.snack_order_api.utils;

import com.gosnack.snack_order_api.dto.ItemRecord;
import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Converters {

    public OrderModel convertOrderRecordToOrderModel(OrderRecord orderRecord) {
        var orderModel = new OrderModel();

        orderModel.setOrderStatus(OrderStatus.PEDIDO_ACEITO);

        if (orderRecord.items() != null) {
            List<ItemModel> itemModels = orderRecord.items().stream().map(itemRecord -> {
                var itemModel = new ItemModel();
                itemModel.setItemName(itemRecord.itemName());
                itemModel.setItemPrice(itemRecord.itemPrice());
                itemModel.setOrders(orderModel);
                return itemModel;
            }).toList();

            orderModel.setItems(itemModels);
        }

        return orderModel;
    }

    public void convertItemRecordToItemModel(List<ItemRecord> itemRecords, OrderModel orderModel) {

        List<ItemModel> existingItems = orderModel.getItems();

        existingItems.clear();

        orderModel.setUpdateOrderTime(LocalDateTime.now());

        for (var itemRecord : itemRecords) {
            var itemModel = new ItemModel();
            itemModel.setItemName(itemRecord.itemName());
            itemModel.setItemPrice(itemRecord.itemPrice());
            itemModel.setOrders(orderModel); // Relaciona ao pedido

            existingItems.add(itemModel);
        }
    }

}

