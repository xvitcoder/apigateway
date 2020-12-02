package com.xvitcoder.gatewayapp.apigateway;

import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class CombinedService {

    private RSocketRequester customerRequester;
    private RSocketRequester supplierRequester;

    public CombinedService(RSocketRequester.Builder builder) {
        this.customerRequester = builder
                .rsocketConnector(connector -> connector.reconnect(Retry.backoff(10, Duration.ofMillis(500))))
                .dataMimeType(MediaType.APPLICATION_CBOR)
                .tcp("localhost", 6561);


        this.supplierRequester = builder
                .rsocketConnector(connector -> connector.reconnect(Retry.backoff(10, Duration.ofMillis(500))))
                .dataMimeType(MediaType.APPLICATION_CBOR)
                .tcp("localhost", 6562);
    }


    public Mono<CustomerWithSupplier> findCustomerWithSupplier(Long customerId, Long supplierId) {
        Mono<Object> customerMono = customerRequester.route("/api/customers/" + customerId)
                .retrieveMono(Object.class);

        Mono<Object> supplierMono = supplierRequester.route("/api/suppliers/" + supplierId)
                .retrieveMono(Object.class);

        return Mono.zip(customerMono, supplierMono, CustomerWithSupplier::new);
    }
}
