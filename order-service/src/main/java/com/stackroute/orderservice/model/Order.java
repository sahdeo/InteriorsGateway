package com.stackroute.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("orderDetails")
@EntityScan
public class Order {
    @Id
    String orderId;
    LocalDateTime orderDated;
    String designId;
    String designName;
    Integer designPrice;


    /*            “customerId”: “String”,
            “customerName”: “String”,
            “customerEmailId”: “String”,
            “designId”: “String”,
            “designName”: “String”,
            “shippingDetails”: “entity”,
            “orderId”: “String”,
            “orderDated”: “String”,
            “productId”: “String”,
            “productName”: “String”,
            “productQuantity”: “Double”,
            “listPrice”: “Double”,
            “discount”: “Double”,
            “sellingPrice”: “Double”,
            “deliveryFee”: “Double”,
            “deliveryDiscount”: “Double”,
            “totalAmount”: “Double”*/
}
