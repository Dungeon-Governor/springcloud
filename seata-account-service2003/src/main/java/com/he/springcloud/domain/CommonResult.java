package com.he.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//自动为所有字段添加@ToString, @EqualsAndHashCode, @Getter方法，为非final字段添加@Setter,和@RequiredArgsConstructor!
@Data
//自动生成全参数构造函数。
@AllArgsConstructor
//自动生成无参数构造函数。
@NoArgsConstructor
public class CommonResult<T> {

    //    状态码
    private Integer code;

    //     信息
    private String message;

    //     传递对象
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}