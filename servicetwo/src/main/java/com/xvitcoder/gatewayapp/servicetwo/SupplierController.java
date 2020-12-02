package com.xvitcoder.gatewayapp.servicetwo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/{supplierId}")
    @ResponseStatus(HttpStatus.OK)
    public Supplier findSupplierById(@PathVariable Long supplierId) {
        return supplierService.findSupplierById(supplierId);
    }
}
