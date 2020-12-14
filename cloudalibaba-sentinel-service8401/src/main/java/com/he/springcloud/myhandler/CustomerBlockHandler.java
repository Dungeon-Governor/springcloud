package com.he.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.he.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

//    兜底方法，必须是静态的，并且返回值类型要和被兜底方法一致
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(444,"handlerException------1");
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"handlerException------2");
    }

}
