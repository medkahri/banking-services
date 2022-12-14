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
@DiscriminatorValue("CC")
public class CurrentAccount extends BankAccount{

    private double overDraft ;


}
