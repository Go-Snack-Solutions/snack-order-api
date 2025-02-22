package com.gosnack.snack_order_api.utils;

import com.gosnack.snack_order_api.record.ItemRecord;
import com.gosnack.snack_order_api.record.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;

import java.time.LocalDateTime;
import java.util.List;

public class Converters {

    public OrderModel convertOrderRecordToOrderModel(OrderRecord orderRecord) {

        var orderModel = new OrderModel();

        orderModel.setOrderId(orderRecord.orderId());

        if (orderRecord.items() != null) {
            List<ItemModel> itemModels = orderRecord.items().stream().map(itemRecord -> {
                var itemModel = new ItemModel();
                itemModel.setItemId(itemRecord.itemId());
                itemModel.setItemName(itemRecord.itemName());
                itemModel.setItemPrice(itemRecord.itemPrice());
                itemModel.setOrders(orderModel);
                return itemModel;
            }).toList();

            orderModel.setItems(itemModels);
        }

        orderModel.setOrderStatus(orderRecord.orderStatus());

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

