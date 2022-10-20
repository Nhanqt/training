package com.amaris.service.impl;


import com.amaris.config.SecurityConfig;
import com.amaris.dto.request.AccountDto;
import com.amaris.dto.request.CreateAccountDto;
import com.amaris.entity.AccountEntity;
import com.amaris.entity.RoleEntity;
import com.amaris.exception.exceptions.NotAllowException;
import com.amaris.repository.AccountRepository;
import com.amaris.repository.RoleRepository;
import com.amaris.service.AccountInterface;
import com.amaris.service.mapper.AccountMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountService implements AccountInterface {

    private final SecurityConfig securityConfig;
    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;
    private final AccountMapper accountMapper;

    public AccountService(RoleRepository roleRepository, AccountRepository accountRepository, AccountMapper accountMapper, SecurityConfig securityConfig) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.securityConfig = securityConfig;
    }

    @Override
    @Transactional
    public AccountDto createAccount(CreateAccountDto accountDto) {
        String password = securityConfig.passwordEncoder().encode(accountDto.getPassword());
        accountDto.setCreatedDate(LocalDateTime.now());
        accountDto.setPassword(password);
        AccountEntity account = accountMapper.createToEntity(accountDto);
        List<RoleEntity> roles = roleRepository.findAllById(accountDto.getRoleIds());

        account.setRole(roles);
        AccountEntity accountEntity = accountRepository.save(account);
        return accountMapper.toDto(accountEntity);
    }

    @Override
    @Transactional
    public Page<AccountDto> getAll(String firstname, String lastname, String email, String phone, String accountNumber) {
        return null;
    }

    @Override
    public List<AccountDto> getAll() {
        List<AccountEntity> accountEntities = accountRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        for (AccountEntity accountEntity: accountEntities) {
           // System.out.println("----------" + accountEntity.getId());
            List<RoleEntity> roleEntities = roleRepository.findByAccountId(accountEntity.getId());
          //  System.out.println(roleEntities);
            accountEntity.setRole(roleEntities);
            List<AccountDto> accountDto = accountMapper.toDtoList(accountEntities);
            return accountDto;
        }

        return null;
    }

    @Override
    @Transactional
    public AccountDto updateAccount(AccountDto accountDto) {
        accountDto.setUpdatedDate(LocalDateTime.now());
        AccountEntity account = accountMapper.toEntity(accountDto);

        AccountEntity accountEntity = accountRepository.save(account);

        return accountMapper.toDto(accountEntity);
    }


}
