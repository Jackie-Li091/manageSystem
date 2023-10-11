package com.zoe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;  //reaction code, 1 for success, 0 for fail
    private String msg;    //reaction message
    private Object data;   //return data

    public static Result success() { return new Result(1, "success", null);}
    public static Result success(Object data) { return new Result(1, "success", data);}
    public static Result error(String mes) { return new Result(0, mes, null);}
}
