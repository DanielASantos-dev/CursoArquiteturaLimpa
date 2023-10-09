package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;
    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet =  findWalletByTaxNumberGateway.findByTazNumber(taxNumber);
        if (wallet == null){
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
