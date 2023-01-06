package com.stackroute.orderservice.controller;

import com.stackroute.orderservice.dto.CreateOrderDTO;
import com.stackroute.orderservice.dto.OrderDetails;
import com.stackroute.orderservice.exception.OrderNotFoundException;
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
@RequestMapping("/orderService")
public class OrderController {

    private OrderService orderService;
    @Autowired
    public OrderController(OrderService service)
    {
        this.orderService=service;
    }

    @PostMapping(value = "/createOrder")
    public ResponseEntity<OrderDetails> createOrder(@RequestBody @Valid CreateOrderDTO order){
        OrderDetails orderCreated=orderService.createOrder(order);
        return new ResponseEntity<OrderDetails>(orderCreated,HttpStatus.CREATED);
    }

    @GetMapping(value = "/findBy/Id")
    public ResponseEntity<OrderDetails> findById(@RequestParam String orderId) throws OrderNotFoundException{
        return  new ResponseEntity<>(orderService.findOrderById(orderId),HttpStatus.FOUND);
    }

    @GetMapping(value = "/fetchAll/orders")
    public ResponseEntity<List<OrderDetails>> fetchAllOrders(){
        return new ResponseEntity<List<OrderDetails>>(orderService.listAllOrders(),HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/cancel")
    public ResponseEntity<String> deleteById (@RequestParam String orderId) throws OrderNotFoundException {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>("Order Canceled Successfully", HttpStatus.OK);
    }

    @GetMapping(value = "OrderIdList/findBy/customerEmailId")
    public ResponseEntity<List<String>> ordersByCustomerEmail(@RequestParam @Valid String customerEmailId) throws OrderNotFoundException{
        List<String> orderIds=orderService.ordersByEmail(customerEmailId);
        return new ResponseEntity<>(orderIds,HttpStatus.FOUND);
    }
}
