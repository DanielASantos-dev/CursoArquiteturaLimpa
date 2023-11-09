package br.com.curso.infrastructure.service;

import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.usernotificate.NotificateClientService;
import org.springframework.stereotype.Service;

import static br.com.curso.infrastructure.utils.Utilities.log;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    private NotificateClientService notificateClientService;

    public UserNotificationGatewayImpl(NotificateClientService notificateClientService) {
        this.notificateClientService = notificateClientService;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        log.info("Iniciando processo de notificação do usuário::UserNotificationGatewayImpl");
        var response = notificateClientService.notificate();

        if (response == true) {
            log.info("Usuário notificado com sucesso::UserNotificationGatewayImpl");
        }

        return response;
    }
}
