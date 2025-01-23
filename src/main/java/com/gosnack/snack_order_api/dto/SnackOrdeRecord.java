package com.gosnack.snack_order_api.dto;

import com.gosnack.snack_order_api.utils.SnackOrderStatus;

public record SnackOrdeRecord(String orderId, String item, SnackOrderStatus snackOrderStatus) {


}
