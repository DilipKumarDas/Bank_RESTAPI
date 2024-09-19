package com.banking.bank.repository;

import com.banking.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
