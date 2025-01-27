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
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items;

    private OrderStatus orderStatus;


    //TODO
    // trazer lógica da data e hora do pedido para cá
    // criar lógica de observação do pedido

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





}
