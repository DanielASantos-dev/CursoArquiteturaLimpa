package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    @Override
    public boolean validate(TransactionPin transactionPin, String pin) {
        log.info("Inicio da validação da senha de transação::TransactionPinValidateGatewayImpl");
        if (!Objects.equals(transactionPin.getPin(), pin)){
            log.info("Senha incorreta::TransactionPinValidateGatewayImpl");
            return false;
        }
        log.info("Senha correta::TransactionPinValidateGatewayImpl");
        return true;
    }
}
