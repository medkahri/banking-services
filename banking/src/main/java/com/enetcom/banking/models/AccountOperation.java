package com.enetcom.banking.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class AccountOperation {
    @Id
    @SequenceGenerator(name = "operation_sequence",sequenceName = "operation_sequence",allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "operation_sequence"
    )

    private Long id;
    private Date createdAt;
    private OperationType type;
    @ManyToOne
    private BankAccount bankAccount ;
    private String description;



}
