package com.durumluemrullah.keyboardguid.repository.concreate;

import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Category category){



        String sqlQuery= "INSERT INTO CATEGORIES (\"NAME\") VALUES ( ? )";
        jdbcTemplate.update(sqlQuery,new Object[]{category.getCategoryName()});
    }
}
