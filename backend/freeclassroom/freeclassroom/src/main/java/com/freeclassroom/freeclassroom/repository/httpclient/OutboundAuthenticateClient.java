package com.freeclassroom.freeclassroom.repository.httpclient;

import com.freeclassroom.freeclassroom.dto.request.ExchanceTokenRequest;
import com.freeclassroom.freeclassroom.dto.response.ExchanceTokenResponse;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "outbound-identity", url = "https://oauth2.googleapis.com")
public interface OutboundAuthenticateClient {
    @PostMapping(value = "/token", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ExchanceTokenResponse exchanceToken(@QueryMap ExchanceTokenRequest request);
}
