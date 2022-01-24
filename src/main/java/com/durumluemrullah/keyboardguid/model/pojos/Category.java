package com.durumluemrullah.keyboardguid.model.pojos;

import com.durumluemrullah.keyboardguid.common.annotations.Collumn;
import com.durumluemrullah.keyboardguid.common.annotations.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORIES")
public class Category {

    @Collumn(id=true,name = "CATEGORY_ID")
    private BigInteger categoryId;

    @Collumn(id=false,name="CATEGORY_NAME")
    private String categoryName;
}
