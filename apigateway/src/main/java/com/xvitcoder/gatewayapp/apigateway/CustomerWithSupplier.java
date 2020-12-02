package com.xvitcoder.gatewayapp.apigateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWithSupplier {
    private Object customer;
    private Object supplier;
}
