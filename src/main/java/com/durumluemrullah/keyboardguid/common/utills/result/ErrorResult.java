package com.durumluemrullah.keyboardguid.common.utills.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResult extends Result{

    public ErrorResult(String message){
        super(false,message);
    }
}
