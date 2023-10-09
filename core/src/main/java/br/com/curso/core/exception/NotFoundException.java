package br.com.curso.core.exception;

public class NotFoundException extends Exception{

    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
