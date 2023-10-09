package br.com.curso.application.gateway;

import br.com.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
