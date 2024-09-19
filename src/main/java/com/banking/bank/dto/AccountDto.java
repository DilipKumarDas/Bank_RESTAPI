package com.banking.bank.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private long id;
    private String name;
    private double balance;
}
