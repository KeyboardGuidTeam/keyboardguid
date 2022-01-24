package com.durumluemrullah.keyboardguid.repository.concreate;

import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;
import com.durumluemrullah.keyboardguid.repository.mapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CategoryDaoImpl (){
        super(new CategoryRowMapper());
    }


}
