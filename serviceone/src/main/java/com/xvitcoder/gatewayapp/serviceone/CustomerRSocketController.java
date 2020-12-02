package com.xvitcoder.gatewayapp.serviceone;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerRSocketController {

    private final CustomerService customerService;

    @MessageMapping("/api/customers/{customerId}")
    public Mono<Customer> findCustomerById(@DestinationVariable Long customerId) {
        return Mono.just(customerService.findCustomerById(customerId));
    }
}
