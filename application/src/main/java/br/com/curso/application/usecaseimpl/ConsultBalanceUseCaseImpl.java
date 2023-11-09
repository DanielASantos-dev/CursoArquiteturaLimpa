package br.com.curso.application.usecaseimpl;

import br.com.curso.usecase.ConsultBalanceUseCase;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
