package com.enetcom.banking.repositories;

import com.enetcom.banking.models.AccountOperation;
import com.enetcom.banking.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
