package com.xvitcoder.gatewayapp.serviceone;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findCustomerById(@PathVariable Long customerId) {
        return customerService.findCustomerById(customerId);
    }
}
