package com.trilogy.shippingedgeservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "shipping-service")
public interface ShippingClient {
}
