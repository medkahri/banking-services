package com.enetcom.banking.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @NotEmpty
    @NotBlank
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
