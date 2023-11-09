package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class TransferGatewayImpl implements TransferGateway {
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;
    private TransactionMapper transactionMapper;
    private TransactionEntityRepository transactionEntityRepository;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper, TransactionEntityRepository transactionEntityRepository) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            log.info("Inicio da transferencia ::TransferGatewayImpl");
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getToWallet()));
            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            log.info("Transferencia concluida::TransferGatewayImpl");
            return true;
        }catch (Exception e){
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            log.info("Transferencia cancelada::TransferGatewayImpl");
            return false;
        }
    }
}
