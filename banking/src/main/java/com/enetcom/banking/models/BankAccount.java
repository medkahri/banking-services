package com.enetcom.banking.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 4 ,name = "TYPE")


public abstract class BankAccount {

    @Id
    @SequenceGenerator(name = "account_sequence",sequenceName = "account_sequence",allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id ;
    private double balance ;
    private Date createdAt ;
    @Enumerated(EnumType.STRING)
    private AccountStatus status ;
    @ManyToOne
    private Customer customer ;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations ;

    public BankAccount(double balance, Date createdAt, AccountStatus status, Customer customer, List<AccountOperation> accountOperations) {
        this.balance = balance;
        this.createdAt = createdAt;
        this.status = status;
        this.customer = customer;
        this.accountOperations = accountOperations;
    }
}
