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
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items;

    private OrderStatus orderStatus;

    private LocalDateTime orderTime = LocalDateTime.now();

    private LocalDateTime updateOrderTime;

    private String orderObservation;

    private LocalDateTime pedidoAceito;

    private LocalDateTime pedidoCancelado;

    private LocalDateTime pedidoEmPreparo;

    private LocalDateTime pedidoPronto;

    private LocalDateTime pedidoSaiuParaEntrega;

    private LocalDateTime pedidoEntregue;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
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

    public LocalDateTime getpedidoAceito() {
        return pedidoAceito;
    }

    public void setPedidoAceito(LocalDateTime pedidoAceito) {
            this.pedidoAceito = pedidoAceito;
    }

    public LocalDateTime getPedidoCancelado(){
        return pedidoCancelado;
    }

    public void setPedidoCancelado(LocalDateTime pedidoCancelado) {
        this.pedidoCancelado = pedidoCancelado;
    }

    public LocalDateTime getPedidoEmPreparo() {
        return pedidoEmPreparo;
    }

    public void setPedidoEmPreparo(LocalDateTime pedidoEmPreparo) {
        this.pedidoEmPreparo = pedidoEmPreparo;
    }

    public LocalDateTime getPedidoPronto() {
        return pedidoPronto;
    }

    public void setPedidoPronto(LocalDateTime pedidoPronto) {
        this.pedidoPronto = pedidoPronto;
    }

    public LocalDateTime getPedidoSaiuParaEntrega() {
        return pedidoSaiuParaEntrega;
    }

    public void setPedidoSaiuParaEntrega(LocalDateTime pedidoSaiuParaEntrega) {
        this.pedidoSaiuParaEntrega = pedidoSaiuParaEntrega;
    }

    public LocalDateTime getPedidoEntregue() {
        return pedidoEntregue;
    }

    public void setPedidoEntregue(LocalDateTime pedidoEntregue) {
        this.pedidoEntregue = pedidoEntregue;
    }
}
