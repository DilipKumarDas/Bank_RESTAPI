package com.banking.bank.service;

import com.banking.bank.dto.AccountDto;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(long id);
    AccountDto deposit(long id, double amount);
    AccountDto withdraw(long id, double amount);
    List<AccountDto> getAccounts();
    void deleteAccount(long id);
}
