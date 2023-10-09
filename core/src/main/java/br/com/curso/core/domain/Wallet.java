package br.com.curso.core.domain;

import br.com.curso.core.domain.enums.UserTypeEnum;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value){
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if (this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(value);
    }

    public void receiveTransfer(BigDecimal value){
        this.balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet wallet)) return false;

        if (getId() != null ? !getId().equals(wallet.getId()) : wallet.getId() != null) return false;
        if (!getTransactionPin().equals(wallet.getTransactionPin())) return false;
        if (!getBalance().equals(wallet.getBalance())) return false;
        if (!getUser().equals(wallet.getUser())) return false;
        if (!getCreatedAt().equals(wallet.getCreatedAt())) return false;
        return getUpdateAt() != null ? getUpdateAt().equals(wallet.getUpdateAt()) : wallet.getUpdateAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getTransactionPin().hashCode();
        result = 31 * result + getBalance().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        return result;
    }
}
