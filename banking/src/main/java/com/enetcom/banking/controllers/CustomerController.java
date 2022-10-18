package com.enetcom.banking.controllers;

import com.enetcom.banking.dtos.CustomerDTO;
import com.enetcom.banking.models.CuAccount;
import com.enetcom.banking.models.CurrentAccount;
import com.enetcom.banking.models.Customer;
import com.enetcom.banking.repositories.CustomerRepository;
import com.enetcom.banking.services.BankAccountService;
import com.enetcom.banking.services.BankAccountServiceImpl;
import com.enetcom.banking.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@AllArgsConstructor

public class CustomerController {

private BankAccountServiceImpl bankAccountService ;
private CustomerService customerService;
@GetMapping(path = "/all")
public List<CustomerDTO> getCustomers() {
    return customerService.listCustomers();
    }
@PostMapping(path="/add")
public String saveCustomer(@RequestBody CustomerDTO customerdto){
    customerService.saveCustomer(customerdto);
    return "created";
}
@GetMapping(path = "/{id}")
public CustomerDTO getCustomer(@PathVariable(name = "id") Long id){
    return customerService.getCustomer(id) ;

}


/*@PostMapping(path = "/cu")
    public void saveAccount(@RequestBody CuAccount cuAccount){
    bankAccountService.saveCurrentAccount(cuAccount.getIBalance(), cuAccount.getCuId(), cuAccount.getOverdraft());

}*/





}
