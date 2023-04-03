package org.brody.repository.implementation;

import org.brody.enums.AccountStatus;
import org.brody.enums.AccountType;
import org.brody.model.BankAccount;
import org.brody.model.BankDirector;
import org.brody.repository.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountRepositoryImpl implements AccountRepository {

    private static final AccountRepositoryImpl accountRepository;

    static {
        accountRepository = new AccountRepositoryImpl();
    }

    private AccountRepositoryImpl(){
        //disallow instantiation via new outside the class
    }

    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    /*@Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId;
        synchronized (this){//locked this object
            accountId = ++accountsCount;  //critical zone
        }
        bankAccount.setAccountId(accountId);
        synchronized (this) {
            bankAccountMap.put(accountId, bankAccount);
        }
        return bankAccount;
    }*/

    @Override
    public synchronized BankAccount save(BankAccount bankAccount) {
        Long accountId = ++accountsCount;  //critical zone
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId, bankAccount);
        return bankAccount;
    }


    @Override
    public BankAccount update(BankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getAccountId(), bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount bankAccount = bankAccountMap.get(id);
        if(bankAccount == null){
            return Optional.empty();
        }else {
            return Optional.of(bankAccount);
        }
    }

    @Override
    public List<BankAccount> searchBankAccount(Predicate<BankAccount> predicate) {
        return bankAccountMap
                .values()
                .stream()
                .filter(predicate)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public void populate(){
        for (int i=1; i<11; i++){
            BankAccount account = BankDirector.accountBuilder()
                    .balance(10000+Math.random()*90000)
                    .currency(Math.random()>0.5?"EUR":"USD")
                    .status(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .build();
            save(account);
        }

        //print the name of thread
        System.out.println("************************************************************");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count = "+accountsCount);
        System.out.println("Size = "+bankAccountMap.values().size());
        System.out.println("************************************************************");
    }

    public static AccountRepositoryImpl getInstance(){
        /*if(accountRepository == null){

            accountRepository = new AccountRepositoryImpl();
        }*/
        System.out.println("Singleton Instantiation");
        return accountRepository;
    }
}
