package br.com.curso.core.domain;

import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

public class TaxNumber {
    private String value;

    public TaxNumber(String taxNumber) throws Exception {
        setValue(taxNumber);
    }

    public TaxNumber() {
    }

    public void setValue(String value) throws Exception {
        if (!isValid(value)) throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    private Boolean isValid(String taxNumber) throws Exception {

        if (taxNumber.replaceAll("[^0-9]", "").length() == 11 || taxNumber.replaceAll("[^0-9]", "").length() == 14){
            if (taxNumber.length() == 11){
                return isCpfValid(taxNumber);
            }else{
                return isCnpjValid(taxNumber);
            }
        }else {
            throw new TaxNumberException(ErrorCodeEnum.ON0001.getMessage(), ErrorCodeEnum.ON0001.getCode());
        }
    }

    private Boolean isCpfValid(String cpf) {

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        if (cpf.charAt(9) - '0' != firstDigit) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cpf.charAt(10) - '0' == secondDigit;
    }

    private Boolean isCnpjValid(String cnpj) {
        int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights1[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights2[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        return cnpj.charAt(12) - '0' == secondDigit;
    }
}
