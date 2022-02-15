package com.durumluemrullah.keyboardguid.business.concretes;

import com.durumluemrullah.keyboardguid.business.abstracts.PostService;
import com.durumluemrullah.keyboardguid.business.constants.CategoryConstants;
import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;
import com.durumluemrullah.keyboardguid.common.utills.result.SuccessDataResult;
import com.durumluemrullah.keyboardguid.model.pojos.Post;
import com.durumluemrullah.keyboardguid.repository.abstracts.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostDao postDao;

    @Override
    public Result create(Post entity) {
        return null;
    }

    @Override
    public Result update(Post entity) {
        return null;
    }

    @Override
    public DataResult<List<Post>> getAll() {
        return new SuccessDataResult<>(CategoryConstants.SUCCESS,postDao.getAll());
    }

    @Override
    public DataResult<Post> getById(int id) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
    }
}
