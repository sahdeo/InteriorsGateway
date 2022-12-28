package com.stackroute.orderservice.controller;

import com.stackroute.orderservice.exception.OrderIsNull;
import com.stackroute.orderservice.exception.OrderNotFoundException;
import com.stackroute.orderservice.model.Order;
import com.stackroute.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService orderService;
    @Autowired
    public OrderController(@Valid OrderService service)
    {
        this.orderService=service;
    }

    @PostMapping(value = "/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody @Valid Order order) throws OrderIsNull {
        Order orderCreated=orderService.createOrder(order);
        return new ResponseEntity<Order>(orderCreated,HttpStatus.CREATED);
    }

    @GetMapping(value = "/findBy/Id")
    public ResponseEntity<Order> findById(@RequestParam String orderId) throws OrderNotFoundException{
        return  new ResponseEntity<>(orderService.findOrderById(orderId),HttpStatus.FOUND);
    }

    @GetMapping(value = "/fetchAll/orders")
    public ResponseEntity<List<Order>> fetchAllOrders(){
        return new ResponseEntity<List<Order>>(orderService.listAllOrders(),HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/cancel")
    public ResponseEntity<String> deleteById (@RequestParam String orderId) throws OrderNotFoundException {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>("Order Canceled Successfully", HttpStatus.OK);
    }
}
