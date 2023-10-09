package br.com.curso.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
