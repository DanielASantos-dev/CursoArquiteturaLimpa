package br.com.curso.application.gateway;

import br.com.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
