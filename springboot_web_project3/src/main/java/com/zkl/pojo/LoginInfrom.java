package com.zkl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zkl
 * @date 2023/5/6
 * @time 19:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfrom {
    private String username;
    private String password;
}
