package com.gosnack.snack_order_api.repository;

import com.gosnack.snack_order_api.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, String> {

}
