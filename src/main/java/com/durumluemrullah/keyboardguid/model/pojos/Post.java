package com.durumluemrullah.keyboardguid.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private BigInteger postId;
    private BigInteger userId;
    private BigInteger categoryId;
    private BigInteger postInformationId;
    private String link;
    private String comment;
    private Date creationDate;
    private Date lastUpdateDate;

}
