package com.study.devpcw.web.api;

import com.study.devpcw.entity.UserMst;
import com.study.devpcw.security.PrincipalDetails;
import com.study.devpcw.service.AccountService;
import com.study.devpcw.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {


    @Autowired
    private AccountService accountService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<? extends CMRespDto<? extends UserMst>> getUser(@PathVariable int userId) {
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", accountService.getUser(userId)));
    }

    @GetMapping("/principal")
    public ResponseEntity<CMRespDto<? extends PrincipalDetails>> getPrincipalDetails(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        if(principalDetails != null) {
            principalDetails.getAuthorities().forEach(role -> {
                log.info("로그인된 사용자의 권한: {}", role.getAuthority());
            });
        }

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Success", principalDetails));
    }
}
