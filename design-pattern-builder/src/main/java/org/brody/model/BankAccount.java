package org.brody.model;

import org.brody.enums.AccountStatus;
import org.brody.enums.AccountType;

public class BankAccount {
    private Long accountId;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public BankAccount(Long accountId, double balance, String currency, AccountType type, AccountStatus status) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.status = status;
    }

    public BankAccount() {
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }


    public static class AccountBuilder{
        private BankAccount bankAccount = new BankAccount();

        public AccountBuilder accountId(Long id){
            bankAccount.accountId = id;
            return this;
        }

        public AccountBuilder currency(String currency){
            bankAccount.currency = currency;
            return this;
        }

        public AccountBuilder balance(double balance){
            bankAccount.balance = balance;
            return this;
        }

        public AccountBuilder status(AccountStatus status){
            bankAccount.status = status;
            return this;
        }

        public AccountBuilder type(AccountType type){
            bankAccount.type = type;
            return this;
        }

        public BankAccount build(){
            return this.bankAccount;
        }

    }
}
