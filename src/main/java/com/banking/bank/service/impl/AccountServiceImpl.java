package com.banking.bank.service.impl;

import com.banking.bank.dto.AccountDto;
import com.banking.bank.entity.Account;
import com.banking.bank.mapper.AccountMapper;
import com.banking.bank.repository.AccountRepository;
import com.banking.bank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("No account found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("No account found"));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("No account found"));
        double balance=account.getBalance();
        if(balance<amount){throw new RuntimeException("low balance");}
        account.setBalance(account.getBalance() - amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(long id) {
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("No account found"));
        accountRepository.delete(account);

    }
}
