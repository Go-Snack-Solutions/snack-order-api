package com.gosnack.snack_order_api.dto;

import com.gosnack.snack_order_api.utils.SnackOrderStatus;

public record SnackOrderDTO(String orderId, String item, SnackOrderStatus snackOrderStatus) {


}
