package com.stackroute.orderservice.service;

import com.stackroute.orderservice.dto.AddCart;
import com.stackroute.orderservice.dto.CartDetails;
import com.stackroute.orderservice.exception.NoItemsExistsException;
import com.stackroute.orderservice.model.Cart;
import com.stackroute.orderservice.repository.CartRepository;
import com.stackroute.orderservice.util.CartUtil;
import com.stockroute.designerservice.design.model.Design;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;
    private CartUtil cartUtil;

    @Autowired
    public CartServiceImpl(CartRepository repository,CartUtil util){
        this.cartRepository=repository;
        this.cartUtil=util;
    }
    @Override
    public CartDetails addDesignInCart(AddCart requestData){
        Cart cart= new Cart();
        cart.setCustomerEmailId(requestData.getCustomerEmailId());
        cart.setCartAddedDated(LocalDateTime.now());
        cart.setDesignList(requestData.getDesignList());
        cart.setDiscount(requestData.getDiscount());
        cart.setTotalAmount(requestData.getTotalAmount());

        cartRepository.save(cart);
        CartDetails cartDetails=cartUtil.toCartDetails(cart);
        return cartDetails;
    }

    @Override
    public List<Design> findDesignsByCustomerEmailId(String customerEmailId)throws NoItemsExistsException {
        List<Cart> carts=cartRepository.findAll();
        if(carts.isEmpty())
            throw new NoItemsExistsException("No designs exists in cart for "+customerEmailId);
        Optional<List<Design>> optionalDesignList=carts.stream().filter(c->c.getCustomerEmailId().equals(customerEmailId)).map(c->c.getDesignList()).findAny();
        return optionalDesignList.get();
    }
}
