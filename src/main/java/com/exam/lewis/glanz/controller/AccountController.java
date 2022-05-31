package com.exam.lewis.glanz.controller;


import com.exam.lewis.glanz.model.Account;
import com.exam.lewis.glanz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String accountId ){
        Account account = accountService.getAccountByID(accountId);
        if(account == null){
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account,HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/account")
    public Account addAccount(@RequestBody Account addAccount){
        return accountService.addAccount(addAccount);
    }

    @GetMapping("/hi")
    public String message(){
        return "hello";
    }
}
