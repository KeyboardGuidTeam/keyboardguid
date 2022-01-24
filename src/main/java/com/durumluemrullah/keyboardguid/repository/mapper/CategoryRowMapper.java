package com.durumluemrullah.keyboardguid.repository.mapper;

import com.durumluemrullah.keyboardguid.model.pojos.Category;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setCategoryId((BigInteger.valueOf(rs.getInt("CATEGORY_ID"))));
        category.setCategoryName(rs.getString("CATEGORY_NAME"));
        return category;
    }
}
