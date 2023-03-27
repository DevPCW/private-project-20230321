package com.study.devpcw.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserMst {

    private int userId;


    private String username;

    private String password;

    private String repassword;

    private String name;

    private String email;

    private List<RoleDtl> roleDtl;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
