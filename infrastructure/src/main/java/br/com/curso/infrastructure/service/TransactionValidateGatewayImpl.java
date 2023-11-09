package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.apivalidate.ApiValidateService;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {
    private ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        log.info("Inicio da validação da transação por serviço externo::TransactionValidateGatewayImpl");
        var response = apiValidateService.validate();
        if (response == null){
            log.info("Transação rejeitada::TransactionValidateGatewayImpl");
            return false;
        }
        log.info("Transação aprovada::TransactionValidateGatewayImpl");
        return response.success();
    }
}
