package com.durumluemrullah.keyboardguid.repository.concreate;

import com.durumluemrullah.keyboardguid.model.pojos.Post;
import com.durumluemrullah.keyboardguid.repository.abstracts.PostDao;

import com.durumluemrullah.keyboardguid.repository.mapper.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostDaoImpl (){
        super(new PostRowMapper());
    }
}
