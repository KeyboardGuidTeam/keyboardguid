package com.durumluemrullah.keyboardguid.business.concretes;

import com.durumluemrullah.keyboardguid.business.abstracts.CategoryService;
import com.durumluemrullah.keyboardguid.business.constants.CategoryConstants;
import com.durumluemrullah.keyboardguid.business.rules.CategoryRules;
import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;
import com.durumluemrullah.keyboardguid.common.utills.result.SuccessDataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.SuccessResult;
import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Result create(Category category) {
        List<Result> rules = Arrays.asList(CategoryRules.isExist(category,categoryDao));

        for (Result rule : rules) {
            if(!rule.isStatus()){
                return rule;
            }
        }
        categoryDao.create(category);
        return new SuccessResult(CategoryConstants.SUCCESS);
    }

    @Override
    public Result update(Category category) {
        List<Result> rules = Arrays.asList(CategoryRules.isExist(category,categoryDao));

        for (Result rule : rules) {
            if(!rule.isStatus()){
                return rule;
            }
        }
        categoryDao.update(category);
        return new SuccessResult(CategoryConstants.SUCCESS);
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(CategoryConstants.SUCCESS,categoryDao.getAll());
    }

    @Override
    public DataResult<Category> getById(int id) {
        return new SuccessDataResult<>(CategoryConstants.SUCCESS,categoryDao.getById(BigInteger.valueOf(id)));
    }

    @Override
    public Result delete(int id) {
        categoryDao.delete(getById(id).getData());
        return new SuccessResult(CategoryConstants.SUCCESS);
    }
}
