package br.com.curso.infrastructure.controller;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.curso.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception, TransactionPinException {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("Usuário criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build();
    }
}
