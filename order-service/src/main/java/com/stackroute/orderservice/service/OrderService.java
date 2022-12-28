package com.stackroute.orderservice.service;

import com.stackroute.orderservice.exception.OrderIsNull;
import com.stackroute.orderservice.exception.OrderNotFoundException;
import com.stackroute.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order createOrder(Order order) throws OrderIsNull;
    List<Order> listAllOrders();
    Order findOrderById(String orderId) throws OrderNotFoundException;

    Order cancelOrder(String orderId) throws OrderNotFoundException;
}
