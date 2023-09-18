package com.workintech.S19D2.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.workintech.S19D2.entity.Member;
import com.workintech.S19D2.entity.Role;
import com.workintech.S19D2.repository.MemberRepository;
import com.workintech.S19D2.repository.RoleRepository;

public class AuthenticationService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member register(String email, String password) {

        Optional<Member> foundMember = memberRepository.findMemberByEmail(email);
        if (foundMember.isPresent()) {
            return null;
        }

        String encodedPassword = passwordEncoder.encode(password);
        Role memberRole = roleRepository.findByAuthority("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(memberRole);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setAuthorities(roles);
        return memberRepository.save(member);
    }
}
