package br.com.curso.infrastructure.client;

import br.com.curso.infrastructure.client.dto.response.ApiValidateResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiValidateService {

    private ApiValidateClient apiValidateClient;

    public ApiValidateService(ApiValidateClient apiValidateClient) {
        this.apiValidateClient = apiValidateClient;
    }

    public ApiValidateResponse validate(){
        try {
            return apiValidateClient.validate();
        }catch (Exception e){
            return null;
        }
    }
}
