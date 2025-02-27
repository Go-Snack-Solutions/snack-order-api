package com.gosnack.snack_order_api.model;

import com.gosnack.snack_order_api.utils.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items;

    private OrderStatus orderStatus;

    private LocalDateTime orderTime = LocalDateTime.now();

    private LocalDateTime updateOrderTime;

    private String orderObservation;

    private LocalDateTime orderAccept;

    private LocalDateTime orderCanceled;

    private LocalDateTime orderInPreparation;

    private LocalDateTime orderReady;

    private LocalDateTime orderOutToDelivery;

    private LocalDateTime orderDelivered;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderObservation() {
        return orderObservation;
    }

    public void setOrderObservation(String orderObservation) {
        this.orderObservation = orderObservation;
    }

    public LocalDateTime getUpdateOrderTime() {
        return updateOrderTime;
    }

    public void setUpdateOrderTime(LocalDateTime updateOrderTime) {
        this.updateOrderTime = updateOrderTime;
    }

    public LocalDateTime getOrderAccept() {
        return orderAccept;
    }

    public void setOrderAccept(LocalDateTime orderAccept) {
            this.orderAccept = orderAccept;
    }

    public LocalDateTime setOrderCanceled(){
        return orderCanceled;
    }

    public void setOrderCanceled(LocalDateTime orderCanceled) {
        this.orderCanceled = orderCanceled;
    }

    public LocalDateTime setOrderInPreparation() {
        return orderInPreparation;
    }

    public void setOrderInPreparation(LocalDateTime orderInPreparation) {
        this.orderInPreparation = orderInPreparation;
    }

    public LocalDateTime setOrderReady() {
        return orderReady;
    }

    public void setOrderReady(LocalDateTime orderReady) {
        this.orderReady = orderReady;
    }

    public LocalDateTime setOrderOutToDelivery() {
        return orderOutToDelivery;
    }

    public void setOrderOutToDelivery(LocalDateTime orderOutToDelivery) {
        this.orderOutToDelivery = orderOutToDelivery;
    }

    public LocalDateTime setOrderDelivered() {
        return orderDelivered;
    }

    public void setOrderDelivered(LocalDateTime orderDelivered) {
        this.orderDelivered = orderDelivered;
    }
}
