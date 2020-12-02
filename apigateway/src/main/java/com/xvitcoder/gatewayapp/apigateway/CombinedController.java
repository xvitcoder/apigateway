package com.xvitcoder.gatewayapp.apigateway;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/combined")
@RequiredArgsConstructor
public class CombinedController {

    private final CombinedService combinedService;

    @GetMapping("/{customerId}/{supplierId}")
    public Mono<CustomerWithSupplier> findCustomerWithSupplier(@PathVariable Long customerId, @PathVariable Long supplierId) {
        return combinedService.findCustomerWithSupplier(customerId, supplierId);
    }
}
