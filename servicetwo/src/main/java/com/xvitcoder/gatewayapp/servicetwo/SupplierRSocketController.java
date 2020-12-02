package com.xvitcoder.gatewayapp.servicetwo;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class SupplierRSocketController {

    private final SupplierService supplierService;

    @MessageMapping("/api/suppliers/{supplierId}")
    public Mono<Supplier> findSupplierById(@DestinationVariable Long supplierId) {
        return Mono.just(supplierService.findSupplierById(supplierId));
    }
}
