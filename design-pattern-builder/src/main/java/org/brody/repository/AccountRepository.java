package org.brody.repository;

import org.brody.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepository {
    BankAccount save(BankAccount bankAccount);
    BankAccount update(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id);
    List<BankAccount> searchBankAccount(Predicate<BankAccount> predicate);
    void deleteById(Long id);
}
