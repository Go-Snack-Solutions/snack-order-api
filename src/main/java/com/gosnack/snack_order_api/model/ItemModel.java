package com.gosnack.snack_order_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "snack-items")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel orders; // Relacionamento com OrderModel

    private String itemName;
    private double itemPrice;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public OrderModel getOrders() {
        return orders;
    }

    public void setOrders(OrderModel orders) {
        this.orders = orders;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
