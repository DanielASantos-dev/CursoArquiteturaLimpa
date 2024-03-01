package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {
    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvaliable(String taxNumber) throws TaxNumberException {

        if (!taxNumberAvailableGateway.taxNumberAvailable(taxNumber)) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        return true;
    }
}
