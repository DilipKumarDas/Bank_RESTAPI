package com.banking.bank.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Account {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @Column
    private String name;
    private double balance;
}