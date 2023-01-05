package com.stackroute.orderservice.util;

import com.stackroute.orderservice.dto.CreateOrderDTO;
import com.stackroute.orderservice.dto.OrderDetails;
import com.stackroute.orderservice.model.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
<<<<<<< HEAD
=======

>>>>>>> 7d47d8aa118702ce090b8b489dcea0d13caff078
@Component
public class OrderUtil {

    public OrderDetails toOrderDetails(Order order){
        OrderDetails details=new OrderDetails();
        details.setOrderId(order.getOrderId());
        details.setOrderDated(order.getOrderDated());
        details.setCustomerEmailId(order.getCustomerEmailId());
        details.setCustomerName(order.getCustomerName());
        details.setDesignId(order.getDesignId());
        details.setDesignName(order.getDesignName());
        details.setDesignPrice(order.getDesignPrice());
        details.setShippingDetails(order.getShippingDetails());
        details.setDiscount(order.getDiscount());
        details.setTotalAmount(order.getTotalAmount());
        return details;
    }
    public Order fromOrderDetailsToOrder(OrderDetails orderDetails){
        Order order=new Order();
        order.setOrderId(orderDetails.getOrderId());
        order.setOrderDated(orderDetails.getOrderDated());
        order.setCustomerEmailId(orderDetails.getCustomerEmailId());
        order.setCustomerName(orderDetails.getCustomerName());
        order.setDesignId(orderDetails.getDesignId());
        order.setDesignName(orderDetails.getDesignName());
        order.setDesignPrice(orderDetails.getDesignPrice());
        order.setShippingDetails(orderDetails.getShippingDetails());
        order.setDiscount(orderDetails.getDiscount());
        order.setTotalAmount(orderDetails.getTotalAmount());
        return order;
    }
    public Order fromRequestDataToOrder(CreateOrderDTO requestData){
        Order order=new Order();
        order.setOrderId(requestData.getOrderId());
        order.setOrderDated(requestData.getOrderDated());
        order.setCustomerEmailId(requestData.getCustomerEmailId());
        order.setCustomerName(requestData.getCustomerName());
        order.setDesignId(requestData.getDesignId());
        order.setDesignName(requestData.getDesignName());
        order.setDesignPrice(requestData.getDesignPrice());
        order.setShippingDetails(requestData.getShippingDetails());
        order.setDiscount(requestData.getDiscount());
        order.setTotalAmount(requestData.getTotalAmount());
        return order;
    }
    public List<OrderDetails> toOrderDetailList(Collection<Order> orders){
            List<OrderDetails> list=  orders.stream()
                    .map(this::toOrderDetails)
                    .collect(Collectors.toList());
            return list;
        }
}
