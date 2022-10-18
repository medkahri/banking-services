package com.enetcom.banking.services;

import com.enetcom.banking.models.BankAccount;
import com.enetcom.banking.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BankAccountService {


    BankAccount saveSavingAccount(double intitialBalance  ,Long customerId,double interest);

    BankAccount saveCurrentAccount(double intitialBalance  ,Long customerId,double overdraft);

    BankAccount getAccount(Long id);
    void credit(Long accountId,double amount,String description);
    void debit(Long accountId,double amount,String description);
    void transfer(Long accountIdSource,Long accountIdDestination ,double amount , String description);

}
