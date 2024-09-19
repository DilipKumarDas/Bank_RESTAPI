package com.banking.bank.controller;

import com.banking.bank.dto.AccountDto;
import com.banking.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto=accountService.getAccount(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable long id,@RequestBody Map<String,Long> request) {
        double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id,@RequestBody Map<String,Long> request) {
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id, amount);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping("/all-accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts= accountService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted");
    }

}
