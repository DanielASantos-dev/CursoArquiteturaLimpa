package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction) throws Exception;
}
