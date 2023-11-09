package br.com.curso.application.gateway;

import br.com.curso.core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {

    TransactionPin update(TransactionPin transactionPin);
}
