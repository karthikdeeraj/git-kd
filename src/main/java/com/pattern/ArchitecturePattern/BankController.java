package com.pattern.ArchitecturePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @RequestMapping(value="/getName", method = RequestMethod.GET)
    public String getNameOfAccountHolder(@RequestParam int number){
        return bankService.getNameFromAccountNumber(number);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addAccount(Account account){
        bankService.insertAccount(account);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateAccountBalance(int number, long balance){
        bankService.updateBalance(number, balance);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAccount(Account account){
        bankService.deleteAccount(account);
    }

    @RequestMapping(value="/getBalance", method = RequestMethod.GET)
    public long getAccountBalance(@RequestParam int number){
        return bankService.getBalanceFromAccountNumber(number);
    }

    /*@RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String getGreeting(@RequestParam String name) {
        return "Hello, " + name + "!"; }*/

    @RequestMapping(value = "/helloByNumber", method = RequestMethod.GET)
    public String getHelloMessage(@RequestParam int number) {
        String name = bankService.getNameFromAccountNumber(number);
        return "Hello, " + name + "!";}
}

