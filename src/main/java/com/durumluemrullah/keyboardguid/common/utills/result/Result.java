package com.durumluemrullah.keyboardguid.common.utills.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private boolean status;
    private String message;

    public Result(){}

    public Result (boolean status,String message){
        this.status = status;
        this.message = message;
    }


}
