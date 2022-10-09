package com.enetcom.banking.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence",sequenceName = "customer_sequence",allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id ;
    private String firstname ;
    private String lastname;
    private String email ;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts ;

    public Customer(String firstname,String lastname , String email){
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.email = email;

    }




}
