package br.com.curso.infrastructure.config;

import br.com.curso.application.gateway.*;
import br.com.curso.application.usecaseimpl.*;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.BadRequestException;
import br.com.curso.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway) {
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationUseCase userNotificationUseCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationUseCaseImpl(userNotificationGateway);
    }

    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(UpdateTransactionPinGateway updateTransactionPinGateway) {
        return new UpdateTransactionPinUseCaseImpl(updateTransactionPinGateway);
    }

    @Bean
    public TransactionPinValidateUseCase transactionPinValidateUseCase(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidateUseCaseImpl(transactionPinValidateGateway, updateTransactionPinUseCase);
    }

    @Bean
    public TransferUseCase transferUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        return new TransferUseCaseImpl(findWalletByTaxNumberUseCase, transactionValidateUseCase, createTransactionUseCase, transferGateway, userNotificationUseCase, transactionPinValidateUseCase);
    }
}
