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
public class RoleMst {

    private int roleId;

    private String roleName;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
