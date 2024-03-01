package br.com.curso.usecase;

import br.com.curso.core.exception.EmailException;

public interface EmailAvailableUseCase {

    Boolean emailAvailableEmail(String email) throws EmailException;
}
