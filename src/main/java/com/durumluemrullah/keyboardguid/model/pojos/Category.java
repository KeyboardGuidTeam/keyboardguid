package com.durumluemrullah.keyboardguid.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    private BigInteger categoryId;
    private String categoryName;
}
