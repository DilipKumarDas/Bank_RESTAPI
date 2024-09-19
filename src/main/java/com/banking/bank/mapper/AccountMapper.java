package com.banking.bank.mapper;

import com.banking.bank.dto.AccountDto;
import com.banking.bank.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {

        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getBalance()
        );
    }
}
