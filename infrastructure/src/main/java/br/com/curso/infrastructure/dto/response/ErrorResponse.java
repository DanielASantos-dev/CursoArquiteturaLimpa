package br.com.curso.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse( String message, String code, List<ValidationError> validitions){}
