package br.com.curso.infrastructure.controller;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.usecase.CreateUserUseCase;
import br.com.curso.usecase.EmailAvailableUseCase;
import br.com.curso.usecase.TaxNumberAvailableUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.curso.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    final private CreateUserUseCase createUserUseCase;
    final private UserMapper userMapper;
    final private EmailAvailableUseCase emailAvailableUseCase;
    final private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, EmailAvailableUseCase emailAvailableUseCase, TaxNumberAvailableUseCase taxNumberAvailableUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception, TransactionPinException {
        log.info("Inicio da criação do usuário::UserController");
        emailAvailableUseCase.emailAvailableEmail(request.email());
        taxNumberAvailableUseCase.taxNumberAvaliable(request.taxNumber());
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Usuário criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build();
    }
}
