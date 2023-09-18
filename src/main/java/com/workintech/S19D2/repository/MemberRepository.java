package com.workintech.S19D2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workintech.S19D2.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findMemberByEmail(String email);
}
