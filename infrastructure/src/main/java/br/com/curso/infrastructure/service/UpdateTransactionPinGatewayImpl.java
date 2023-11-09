package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.UpdateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.mapper.TransactionPinMapper;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {

    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;

    public UpdateTransactionPinGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        log.info("Inicia da atualização da senha de transação");
        return transactionPinMapper.toTransactionPin(transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntityUpdate(transactionPin)));
    }
}
