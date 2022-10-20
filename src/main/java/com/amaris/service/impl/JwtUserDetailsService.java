//package com.amaris.service.impl;
//
//import com.amaris.entity.AccountEntity;
//import com.amaris.repository.AccountRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class JwtUserDetailsService {
//
////    private final AccountRepository accountRepository;
////
////
////    public JwtUserDetailsService(AccountRepository accountRepository) {
////        this.accountRepository = accountRepository;
////    }
////
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        AccountEntity account = accountRepository.findByEmail(email);
////        System.out.println(email);
////        if (account == null) {
////            throw new UsernameNotFoundException("Invalid User");
////
////        } else {
////            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//////            for (Role role : user.getRoles()){
//////                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
//////            }
////
////
////            return new org
////                    .springframework
////                    .security
////                    .core
////                    .userdetails
////                    .User(account.getEmail(), account.getPassword(), grantedAuthorities);
////
////        }
////    }
//
//
//}
