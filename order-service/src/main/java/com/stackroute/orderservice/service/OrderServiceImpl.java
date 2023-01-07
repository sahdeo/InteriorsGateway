package com.stackroute.orderservice.service;

import com.stackroute.orderservice.dto.CreateOrderDTO;
import com.stackroute.orderservice.dto.OrderDetails;
import com.stackroute.orderservice.exception.OrderNotFoundException;
import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.repository.OrderRepository;
import com.stackroute.orderservice.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository repository;
    private OrderUtil orderUtil;

    @Autowired
    public OrderServiceImpl(OrderRepository dao,OrderUtil orderUtil){
        this.repository=dao;
        this.orderUtil=orderUtil;
    }
    @Override
    public OrderDetails createOrder(CreateOrderDTO requestData){
        Order order=new Order();
        /*order.setOrderId(requestData.getOrderId());
        order.setOrderDated(LocalDateTime.now());
        order.setCustomerEmailId(requestData.getCustomerEmailId());
        order.setCustomerName(requestData.getCustomerName());
        order.setDesignId(requestData.getDesignId());
        order.setDesignName(requestData.getDesignName());
        order.setDesignPrice(requestData.getDesignPrice());
        order.setShippingDetails(requestData.getShippingDetails());
        order.setDiscount(requestData.getDiscount());
        order.setTotalAmount(requestData.getTotalAmount());*/
        order.setOrderId(requestData.getOrderId());
        order.setOrderDated(requestData.getOrderDated());
        order.setDesignName(requestData.getDesignName());
        order.setDesignId(requestData.getDesignId());
        order.setDesignPrice(requestData.getDesignPrice());
        repository.save(order);
        OrderDetails orderDetails=orderUtil.toOrderDetails(order);
        return orderDetails;
    }

    @Override
    public List<OrderDetails> listAllOrders() {
        List<Order> list=repository.findAll();
        List<OrderDetails> desiredList=orderUtil.toOrderDetailList(list);
        return desiredList;
    }

    @Override
    public OrderDetails findOrderById(String orderId) throws OrderNotFoundException {
        Optional<Order> optionalOrder=repository.findById(orderId);
        if(optionalOrder.isEmpty()){
                throw new OrderNotFoundException("Order not found for id= "+orderId);
            }
        OrderDetails details=orderUtil.toOrderDetails(optionalOrder.get());
        return details;
    }

    @Override
    public OrderDetails cancelOrder(String orderId) throws OrderNotFoundException{
        OrderDetails found=findOrderById(orderId);
        Order order=orderUtil.fromOrderDetailsToOrder(found);
        repository.delete(order);
        return found;
    }

   /* public List<String> ordersByEmail(String customerEmailId) throws OrderNotFoundException{
        List<Order> orders=repository.findAll();
        if(orders.isEmpty())
            throw new OrderNotFoundException("Orders not found for customer= "+customerEmailId);
        List<String> orderIds=orders.stream().filter(o-> o.getCustomerEmailId().equals(customerEmailId)).map(o->o.getOrderId()).collect(Collectors.toList());
        return orderIds;
    }*/
}
