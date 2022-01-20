package com.durumluemrullah.keyboardguid.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    // github linked google
    private BigInteger userId;
    private BigInteger companyId;
    private BigInteger departmentId;
    private String userName;
    private String userEmail; // email ile doğrulama
    private String phoneNumber; // phone number ile doğrulama
    private String password;
    private Date creationDate;

    // auth -> jwt

}
