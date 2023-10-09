package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private UserNotificationGateway userNotificationGateway;
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
