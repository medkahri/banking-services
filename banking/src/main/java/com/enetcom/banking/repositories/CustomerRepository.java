package com.enetcom.banking.repositories;

import com.enetcom.banking.models.BankAccount;
import com.enetcom.banking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
