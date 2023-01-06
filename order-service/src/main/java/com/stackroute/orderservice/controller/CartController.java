//package com.stackroute.orderservice.controller;
//
//import com.stackroute.orderservice.dto.AddCart;
//import com.stackroute.orderservice.dto.CartDetails;
//import com.stackroute.orderservice.exception.NoItemsExistsException;
//import com.stackroute.orderservice.service.CartService;
//import com.stockroute.designerservice.design.model.Design;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Validated
//@RestController
//@RequestMapping("cart")
//public class CartController {
//
//    private CartService cartService;
//
//    @Autowired
//    public CartController(CartService service){
//        this.cartService=service;
//    }
//
//    @PostMapping(value = "/AddDesigns/Inside/Cart")
//    public ResponseEntity<CartDetails> addDesignsInsideCart(@Valid @RequestBody AddCart requestData){
//        CartDetails cartDetails=cartService.addDesignInCart(requestData);
//        return new ResponseEntity<>(cartDetails, HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/Designs/CustomerEmailId")
//    public ResponseEntity<List<Design>> cartItemsByEmail(@Valid @RequestParam String customerEmailId) throws NoItemsExistsException {
//        List<Design> designs=cartService.findDesignsByCustomerEmailId(customerEmailId);
//        return new ResponseEntity<>(designs,HttpStatus.FOUND);
//    }
//}
