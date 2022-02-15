package com.durumluemrullah.keyboardguid.repository.mapper;

import com.durumluemrullah.keyboardguid.model.pojos.Post;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

        Post post = new Post();
        post.setPostId(BigInteger.valueOf(rs.getInt("POST_ID")));
        post.setUserId(BigInteger.valueOf(rs.getInt("USER_ID")));
        post.setCategoryId(BigInteger.valueOf(rs.getInt("CATEGORY_ID")));
        post.setPostInformationId(BigInteger.valueOf(rs.getInt("POST_INFORMATION_ID")));
        post.setLink(rs.getString("LINK"));
        post.setComment(rs.getString("COMMENT"));
        post.setCreationDate(rs.getDate("CREATION_DATE"));
        post.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
        return post;
    }
}
