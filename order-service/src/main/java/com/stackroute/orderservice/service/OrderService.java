package com.stackroute.orderservice.service;

import com.stackroute.orderservice.dto.CreateOrderDTO;
import com.stackroute.orderservice.dto.OrderDetails;
import com.stackroute.orderservice.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    OrderDetails createOrder(CreateOrderDTO order);
    List<OrderDetails> listAllOrders();
    OrderDetails findOrderById(String orderId) throws OrderNotFoundException;

    OrderDetails cancelOrder(String orderId) throws OrderNotFoundException;
    List<String> ordersByEmail(String customerEmailId) throws OrderNotFoundException;

}
