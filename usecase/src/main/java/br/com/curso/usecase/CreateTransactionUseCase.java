package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception;
}
