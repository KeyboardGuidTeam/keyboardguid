package com.durumluemrullah.keyboardguid.common.utills.result;


public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(String message,T data){
        super(true,message,data);
    }
}
