package com.study.devpcw.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserMst {

    @ApiModelProperty(hidden = true)
    private int userId;


    @NotBlank
    private String username;


    @NotBlank
    private String password;

    @NotBlank
    private String repassword;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private List<RoleDtl> roleDtl;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
