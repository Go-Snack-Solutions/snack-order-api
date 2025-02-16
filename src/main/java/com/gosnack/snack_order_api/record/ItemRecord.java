package com.gosnack.snack_order_api.record;

import java.util.UUID;

public record ItemRecord(String itemId, String itemName, double itemPrice) {

    public ItemRecord {
            itemId = "ITEM_" + UUID.randomUUID().toString().toUpperCase(); // Gera um UUID automaticamente
    }
}
