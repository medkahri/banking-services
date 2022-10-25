package com.enetcom.banking.repositories;

import com.enetcom.banking.models.AccountOperation;
import com.enetcom.banking.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
