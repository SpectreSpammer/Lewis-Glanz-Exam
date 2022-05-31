package com.exam.lewis.glanz.service;

import com.exam.lewis.glanz.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class AccountService {
    public List<Account> getAllAccount(){

        List<Account> listOfAccount = new ArrayList<>();
        listOfAccount.add(new Account("12345","Test","09081234567",
                "test123@gmail.com","test","test"
        ));
        listOfAccount.add(new Account("67890","Test1","09087653432",
                "test2123@gmail.com","test2","test2"
        ));

        return listOfAccount;
    }

    public Account getAccountByID(String id){
        Predicate<Account> byId = p -> p.getCustomerNumber().equals(id);
        return filterProducts(byId);


    }

    private Account filterProducts(Predicate<Account> strategy) {
        return getAllAccount().stream().filter(strategy).findFirst().orElse(null);
    }

    public Account addAccount(Account newAccount){
        newAccount.setCustomerNumber("12345678");
        newAccount.setCustomerName("Test4");
        newAccount.setCustomerMobile("090812345678");
        newAccount.getAddress1("test4");
        newAccount.getAddress2("test4");

        return newAccount;
    }

}
