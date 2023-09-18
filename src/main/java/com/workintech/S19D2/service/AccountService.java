package com.workintech.S19D2.service;

import java.util.List;

import com.workintech.S19D2.entity.Account;

public interface AccountService {
    List<Account> findAll();

    Account findById(int id);

    Account save(Account account);

    Account delete(int id);
}
