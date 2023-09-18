package com.workintech.S19D2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.S19D2.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
