package com.study.devpcw.service;

import com.study.devpcw.entity.UserMst;
import com.study.devpcw.exception.CustomValidationException;
import com.study.devpcw.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void duplicateUsername(String username) {
        UserMst user = accountRepository.findUserByUsername(username);
        if(user != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "이미 존재하는 사용자 아이디입니다.");

            throw new CustomValidationException(errorMap);
        }
    }

    public void compareToPassword(String password, String repassword) {
        if(!password.equals(repassword)) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("repassword", "비밀번호가 일치하지 않습니다.");

            throw  new CustomValidationException(errorMap);
        }
    }

    public UserMst getUser(int userId) {
        return accountRepository.findUserByUserId(userId);
    }
}
