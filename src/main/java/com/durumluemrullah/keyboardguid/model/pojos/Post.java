package com.durumluemrullah.keyboardguid.model.pojos;

import com.durumluemrullah.keyboardguid.common.annotations.Collumn;
import com.durumluemrullah.keyboardguid.common.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="POST")
public class Post {

    @Collumn(id = true,name = "POST_ID")
    private BigInteger postId;

    @Collumn(id=false,name="USER_ID")
    private BigInteger userId;

    @Collumn(id=false,name="CATEGORY_ID")
    private BigInteger categoryId;

    @Collumn(id=false,name="POST_INFORMATION_ID")
    private BigInteger postInformationId;

    @Collumn(id=false,name="LINK")
    private String link;

    @Collumn(id=false,name="COMMENT")
    private String comment;

    @Collumn(id=false,name="CREATION_DATE")
    private Date creationDate;

    @Collumn(id=false,name="LAST_UPDATE_DATE")
    private Date lastUpdateDate;

}
