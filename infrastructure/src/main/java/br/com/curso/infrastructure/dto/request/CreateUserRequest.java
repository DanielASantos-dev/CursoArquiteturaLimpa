package br.com.curso.infrastructure.dto.request;

import br.com.curso.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin) {
}
