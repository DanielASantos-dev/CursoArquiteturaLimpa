package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        log.info("Verificação de email disponivel::EmailAvailableGatewayImpl");
        return !userEntityRepository.existsByEmail(email);
    }
}
