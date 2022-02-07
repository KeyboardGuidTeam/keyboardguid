package com.durumluemrullah.keyboardguid.common.utills.result;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataResult<T> extends Result{
    private T data;

    public DataResult(boolean status , String message,T data){
        super(status,message);
        this.data= data;
    }
}
