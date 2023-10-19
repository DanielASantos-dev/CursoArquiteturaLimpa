package br.com.curso.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}
