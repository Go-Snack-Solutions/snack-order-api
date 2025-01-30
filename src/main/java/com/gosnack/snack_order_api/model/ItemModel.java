package com.gosnack.snack_order_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID itemId;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel orders;

    private String itemName;
    private double itemPrice;

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
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
