package com.gosnack.snack_order_api.utils;

import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;

import java.util.List;

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
}
