package com.enetcom.banking.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 4 ,name = "TYPE")


public class BankAccount {

    @Id
    private Long id ;
    private double balance ;
    private Date createdAt ;
    @Enumerated(EnumType.STRING)
    private AccountStatus status ;
    @ManyToOne
    private Customer customer ;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations ;





}
