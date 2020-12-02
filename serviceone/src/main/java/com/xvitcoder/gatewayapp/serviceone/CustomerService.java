package com.xvitcoder.gatewayapp.serviceone;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer findCustomerById(Long customerId) {
        return new Customer(customerId, "Customer " + customerId);
    }
}
