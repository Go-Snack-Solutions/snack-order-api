package com.gosnack.snack_order_api.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemRecord(
        @JsonProperty("item_id") String itemId,
        @JsonProperty("item_name") String itemName,
        @JsonProperty("item_price") double itemPrice
) {

}
