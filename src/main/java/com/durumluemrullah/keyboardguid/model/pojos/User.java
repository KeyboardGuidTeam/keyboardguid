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

    private BigInteger userId;
    private BigInteger companyId;
    private BigInteger departmentId;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private String password;
    private Date creationDate;
}
