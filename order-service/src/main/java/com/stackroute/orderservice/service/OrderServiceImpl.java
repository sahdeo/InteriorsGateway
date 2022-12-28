package com.stackroute.orderservice.service;

import com.stackroute.orderservice.exception.OrderIsNull;
import com.stackroute.orderservice.exception.OrderNotFoundException;
import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository dao){
        this.repository=dao;
    }
    @Override
    public Order createOrder(Order order) throws OrderIsNull{
        if(order==null)
            throw new OrderIsNull("Order can't be empty");
        order.setOrderDated(LocalDateTime.now());
        repository.save(order);
        return order;
    }

    @Override
    public List<Order> listAllOrders() {
        return repository.findAll();
    }

    @Override
    public Order findOrderById(String orderId) throws OrderNotFoundException {
        Optional<Order> optionalOrder=repository.findById(orderId);
        if(optionalOrder.isEmpty()){
                throw new OrderNotFoundException("product not found for id="+orderId);
            }
        return optionalOrder.get();
    }

    @Override
    public Order cancelOrder(String orderId) throws OrderNotFoundException{
        Order order=findOrderById(orderId);
        repository.delete(order);
        return order;
    }
}
