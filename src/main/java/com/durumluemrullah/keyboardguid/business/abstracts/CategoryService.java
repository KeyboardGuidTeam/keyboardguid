package com.durumluemrullah.keyboardguid.business.abstracts;

import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;
import com.durumluemrullah.keyboardguid.model.pojos.Category;

import java.util.List;

public interface CategoryService {

    Result create(Category category);
    Result update (Category category);
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
    Result delete(int id);
}
