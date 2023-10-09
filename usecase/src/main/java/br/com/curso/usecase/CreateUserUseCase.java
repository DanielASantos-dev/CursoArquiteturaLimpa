package br.com.curso.usecase;

import br.com.curso.core.domain.User;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
