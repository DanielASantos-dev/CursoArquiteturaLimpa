package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailableEmail(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
