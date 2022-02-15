package com.durumluemrullah.keyboardguid.business.abstracts;

import com.durumluemrullah.keyboardguid.common.utills.result.DataResult;
import com.durumluemrullah.keyboardguid.common.utills.result.Result;


import java.util.List;

public interface BaseService<T> {

    Result create(T entity);
    Result update (T entity);
    DataResult<List<T>> getAll();
    DataResult<T> getById(int id);
    Result delete(int id);
}
