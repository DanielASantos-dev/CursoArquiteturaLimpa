package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserAuthenticateGateway;
import br.com.curso.core.exception.AuthenticateException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }


    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
         if (!userAuthenticateGateway.authenticate(username, password)){
             throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
         }
         return true;
    }
}
