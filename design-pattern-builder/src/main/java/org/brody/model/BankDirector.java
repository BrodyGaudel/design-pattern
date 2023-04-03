/**
 * Dans cette classe , nous implémentons tous les Builders
 */

package org.brody.model;

public class BankDirector {
    public static BankAccount.AccountBuilder accountBuilder(){
        return new BankAccount.AccountBuilder();
    }
}
