package com.zkl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zkl
 * @date 2023/4/20
 * @time 18:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(){
        return (new Result(200,"success",null));
    }
    public static Result success(Object data){
        return (new Result(200,"success",data));
    }
    public static Result error(String msg){
        return (new Result(403,msg,null));
    }

}
