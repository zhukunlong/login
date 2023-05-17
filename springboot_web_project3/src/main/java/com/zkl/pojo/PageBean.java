package com.zkl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zkl
 * @date 2023/4/22
 * @time 16:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;
    private List rows;
}
