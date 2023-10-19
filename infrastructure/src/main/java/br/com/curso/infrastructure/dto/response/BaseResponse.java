package br.com.curso.infrastructure.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private Boolean success;
    private String message;
    private T result;
    private ErrorResponse error;
}
