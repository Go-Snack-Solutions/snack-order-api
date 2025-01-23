package com.gosnack.snack_order_api.model;

import com.gosnack.snack_order_api.utils.SnackOrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "snack_order")
public class SnackOrderModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;
    private String item;
    private SnackOrderStatus snackOrderStatus;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
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
