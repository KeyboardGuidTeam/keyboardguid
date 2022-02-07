package com.durumluemrullah.keyboardguid.business.rules;

import com.durumluemrullah.keyboardguid.business.constants.CategoryConstants;
import com.durumluemrullah.keyboardguid.common.utills.result.ErrorResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;
import com.durumluemrullah.keyboardguid.common.utills.result.SuccessResult;
import com.durumluemrullah.keyboardguid.model.pojos.Category;
import com.durumluemrullah.keyboardguid.repository.abstracts.CategoryDao;

import java.util.List;
import java.util.Locale;

public class CategoryRules {

    private CategoryRules(){
        throw new IllegalCallerException();
    }

    public static Result isExist(Category newCategory, CategoryDao categoryDao){
        List<Category> categories = categoryDao.getAll();
        for (Category category : categories) {
            if(category.getCategoryName().trim().toUpperCase(Locale.ROOT).equals(category.getCategoryName().trim().toUpperCase(Locale.ROOT))){
                return new ErrorResult(CategoryConstants.ALREADY_EXIST);
            }
        }
        return new SuccessResult(CategoryConstants.SUCCESS);
    }


    public static Result isSameName(Category updateCategory , CategoryDao categoryDao){
        Category category = categoryDao.getById(updateCategory.getCategoryId());

        if(category.getCategoryName().trim().equals(updateCategory.getCategoryName().trim())){
            return new ErrorResult(CategoryConstants.SAME_NAME);
        }
        return new SuccessResult(CategoryConstants.SUCCESS);
    }
}
