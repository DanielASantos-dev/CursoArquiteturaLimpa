package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UpdateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {

    private UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return updateTransactionPinGateway.update(transactionPin);
    }
}
