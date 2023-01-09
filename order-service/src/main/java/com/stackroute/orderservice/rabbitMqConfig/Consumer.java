package com.stackroute.orderservice.rabbitMqConfig;

import com.stackroute.orderservice.Domain.DesignDto;
import com.stackroute.orderservice.dto.CreateOrderDTO;
import com.stackroute.orderservice.service.OrderServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class Consumer {

    @Autowired
    private OrderServiceImpl orderService;

//    @Autowired
//    private EmailServiceJavaApi emailServiceJavaApi;
    @RabbitListener(queues="design-queue")
    public void getDataFromRabbitmq(DesignDto request) throws Exception{
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setDesignId(request.getDesignId());
        createOrderDTO.setDesignName(request.getDesignName());
        createOrderDTO.setDesignPrice(request.getDesignPrice());
        System.out.println(request);
        orderService.createOrder(createOrderDTO);
    }


}
