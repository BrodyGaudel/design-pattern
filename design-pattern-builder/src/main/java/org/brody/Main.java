/**
 * the pattern builder is used to build complex objects
 *
 */

package org.brody;

import org.brody.enums.AccountType;
import org.brody.model.BankAccount;
import org.brody.repository.implementation.AccountRepositoryImpl;
import org.brody.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();

        /**
         *  these two instantiations of Account RepositoryImpl refer to a single object-intance in memory:
         *  this is the singleton pattern
         */
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance();
        //accountRepository.populate();

        for(int i=0; i<10; i++){
            new Thread( () -> {
                accountRepository.populate();
            }).start();
        }
        System.out.println("tape a character");
        System.in.read();


        System.out.println("-----------------------searchBankAccount----------------------------------");
        List<BankAccount> bankAccountList = accountRepository
                .findAll();
        bankAccountList.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

    }
}