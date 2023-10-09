package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.*;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;
    private TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pín) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveTransfer(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmain())){
            throw new NotificationException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        return true;
    }
}
