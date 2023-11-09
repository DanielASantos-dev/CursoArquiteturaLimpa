package br.com.curso.infrastructure.client.usernotificate;

import org.springframework.stereotype.Service;

@Service
public class NotificateClientService {

    private NotificationClient notificationClient;

    public NotificateClientService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public Boolean notificate(){
        var response = notificationClient.notificate();
        return response.success();
    }
}
