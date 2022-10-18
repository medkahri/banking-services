package com.enetcom.banking.services;

import com.enetcom.banking.models.*;
import com.enetcom.banking.repositories.AccountOperationRepository;
import com.enetcom.banking.repositories.BankAccountRepository;
import com.enetcom.banking.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {


    private BankAccountRepository bankAccountRepository ;
    private CustomerRepository customerRepository;
    private AccountOperationRepository accountOperationRepository;




    @Override
    public BankAccount saveSavingAccount(double intitialBalance, Long customerId, double interest) {
        SavingAccount bankAccount = new SavingAccount() ;

        bankAccount.setBalance(intitialBalance);
        bankAccount.setCreatedAt(new Date());
        bankAccount.setCustomer(customerRepository.findById(customerId).orElse(null));
        bankAccount.setStatus(AccountStatus.CREATED);
        bankAccount.setInterestRate(interest);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return savedBankAccount;
    }

    @Override
    public BankAccount saveCurrentAccount(double intitialBalance,  Long customerId, double overdraft) {
        CurrentAccount bankAccount = new CurrentAccount();
        bankAccount.setBalance(intitialBalance);
        bankAccount.setCreatedAt(new Date());
        bankAccount.setCustomer(customerRepository.findById(customerId).orElse(null));
        bankAccount.setStatus(AccountStatus.CREATED);
        bankAccount.setOverDraft(overdraft);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return savedBankAccount;
    }





    @Override
    public BankAccount getAccount(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    @Override
    public void credit(Long accountId, double amount, String description) {
        BankAccount bankAccount = getAccount(accountId);
        if(bankAccount.getBalance()<amount){
            throw  new RuntimeException("Not enough Balance");
        } else {
            bankAccount.setBalance(bankAccount.getBalance()-amount);
            AccountOperation accountOperation = new AccountOperation();
            accountOperation.setBankAccount(bankAccount);
            accountOperation.setCreatedAt(new Date());
            accountOperation.setDescription(description);
            accountOperationRepository.save(accountOperation);
            bankAccountRepository.save(bankAccount);
        }

    }

    @Override
    public void debit(Long accountId, double amount, String description) {

        BankAccount bankAccount = getAccount(accountId);
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setBankAccount(bankAccount);
        accountOperation.setCreatedAt(new Date());
        accountOperation.setDescription(description);
        accountOperationRepository.save(accountOperation);

        bankAccount.setBalance(bankAccount.getBalance()+amount);
        bankAccountRepository.save(bankAccount);

    }

    @Override
    public void transfer(Long accountIdSource, Long accountIdDestination, double amount, String description) {

    credit(accountIdSource,amount,"Transfer to"+accountIdDestination);
    debit(accountIdDestination,amount,"Received from"+accountIdSource);


    }
}
