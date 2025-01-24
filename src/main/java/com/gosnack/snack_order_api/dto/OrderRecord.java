package com.gosnack.snack_order_api.dto;

import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.utils.OrderStatus;

import java.util.List;

public record OrderRecord(Long orderId, List<ItemRecord> items, OrderStatus snackOrderStatus) {


}
