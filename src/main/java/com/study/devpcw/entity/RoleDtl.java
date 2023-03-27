package com.study.devpcw.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDtl {

    private int RoleDtlId;

    private int userId;

    private int roleId;

    private RoleMst roleMst;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
