package com.enetcom.banking;

import com.enetcom.banking.models.BankAccount;
import com.enetcom.banking.models.CurrentAccount;
import com.enetcom.banking.models.Customer;
import com.enetcom.banking.services.BankAccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);





    }

/*    @Bean
    CommandLineRunner commandLineRunner(BankAccountServiceImpl bankAccountService){
        return args -> {
            Customer customer = new Customer();
            customer.setFirstname("taher");
            customer.setEmail("taher@gmail.com");
            customer.setLastname("kahri");

            Customer customer2 = new Customer();
            customer2.setLastname("kahri");
            customer2.setEmail("oussema@gmail.com");
            customer2.setFirstname("oussema");
            customer = bankAccountService.saveCustomer(customer);

            CurrentAccount account = new CurrentAccount();
            bankAccountService.saveCurrentAccount(6000,customer.getId(),4000);




        };
    }*/

}
