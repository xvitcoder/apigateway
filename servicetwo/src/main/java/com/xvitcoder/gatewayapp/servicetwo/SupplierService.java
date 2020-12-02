package com.xvitcoder.gatewayapp.servicetwo;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SupplierService {
    private Random random = new Random();

    public Supplier findSupplierById(Long supplierId) {
        return new Supplier(supplierId, "Supplier " + supplierId, String.valueOf(Math.abs(random.nextLong())));
    }
}
