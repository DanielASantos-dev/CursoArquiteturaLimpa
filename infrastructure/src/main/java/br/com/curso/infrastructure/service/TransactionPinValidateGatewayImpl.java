package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    private TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if (transactionPinSaved.isEmpty()){
            return false;
        }
        if (transactionPinSaved.get().getPin() != transactionPin.getPin()){
            return false;
        }
        return true;
    }
}
