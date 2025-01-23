package com.gosnack.snack_order_api.model;

import com.gosnack.snack_order_api.utils.SnackOrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "snack_order")
public class SnackOrderModel  implements Serializable {

    @Id
    private String orderId;
    private String item;
    private SnackOrderStatus snackOrderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public SnackOrderStatus getSnackOrderStatus() {
        return snackOrderStatus;
    }

    public void setSnackOrderStatus(SnackOrderStatus snackOrderStatus) {
        this.snackOrderStatus = snackOrderStatus;
    }




}
