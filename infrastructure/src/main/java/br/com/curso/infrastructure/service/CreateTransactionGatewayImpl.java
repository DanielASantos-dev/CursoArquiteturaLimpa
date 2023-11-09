package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction){
        try {
            log.info("Inicio da criação da transação::CreateTransactionGatewayImpl");
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        }catch (Exception e){
            log.error("Houve erro ao criar a transação::CreateTransactionGatewayImpl");
            return null;
        }
    }
}
