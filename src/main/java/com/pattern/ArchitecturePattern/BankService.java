package com.pattern.ArchitecturePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BankService {

    @Autowired
    BankRepo bankRepo;

    public String getNameFromAccountNumber(int accountNumber){
        Optional<Account> account = bankRepo.findById(accountNumber);
        return account.get().getName();
    }

    public void insertAccount(Account account){
        bankRepo.save(account);
    }

    public void updateBalance(int number, long balance){
        bankRepo.updateBalance(balance, number);
    }

    public void deleteAccount(Account account) { bankRepo.delete(account);}

    public long getBalanceFromAccountNumber(int accountNumber) { Optional<Account> account=bankRepo.findById(accountNumber);
        return account.get().getBalance();}

    private String generateNameByNumber(int number) {
        return "User" + number;}
}
