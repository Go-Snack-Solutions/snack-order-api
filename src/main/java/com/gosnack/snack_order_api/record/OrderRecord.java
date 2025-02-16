package com.gosnack.snack_order_api.record;

import com.gosnack.snack_order_api.utils.OrderStatus;
import java.util.List;
import java.util.UUID;

public record OrderRecord(
        String orderId,
        List<ItemRecord> items,
        OrderStatus orderStatus
) {


    public OrderRecord {
            orderId = "ORDER_" + UUID.randomUUID().toString().toUpperCase(); // Gera um UUID automaticamente
            orderStatus = OrderStatus.PEDIDO_ACEITO; // Define status padrão

    }

}
