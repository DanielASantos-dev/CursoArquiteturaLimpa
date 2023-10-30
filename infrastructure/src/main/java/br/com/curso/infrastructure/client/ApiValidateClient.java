package br.com.curso.infrastructure.client;

import br.com.curso.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ApiValidateClient", url = "${client.url}")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse validate();
}
