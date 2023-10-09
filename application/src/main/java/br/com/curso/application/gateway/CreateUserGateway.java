package br.com.curso.application.gateway;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);
}
