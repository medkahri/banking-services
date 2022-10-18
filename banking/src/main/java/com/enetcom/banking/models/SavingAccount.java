package com.enetcom.banking.models;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@DiscriminatorValue("SC")
public class SavingAccount extends BankAccount{

    private double interestRate ;

}
