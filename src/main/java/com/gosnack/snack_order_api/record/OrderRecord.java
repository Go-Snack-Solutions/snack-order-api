package com.gosnack.snack_order_api.record;

import com.gosnack.snack_order_api.utils.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRecord(
        String orderId,
        List<ItemRecord> items,
        OrderStatus orderStatus,
        String orderObservation,
        LocalDateTime orderTime,
        LocalDateTime updateOrderTime,
        LocalDateTime orderAccept,
        LocalDateTime orderCanceled,
        LocalDateTime orderInPreparation,
        LocalDateTime orderReady,
        LocalDateTime orderOutToDelivery,
        LocalDateTime orderDelivered
) {


}
