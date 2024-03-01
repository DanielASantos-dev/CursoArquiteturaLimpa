package br.com.curso.usecase;

import br.com.curso.core.exception.TaxNumberException;

public interface TaxNumberAvailableUseCase {
    Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException;
}
