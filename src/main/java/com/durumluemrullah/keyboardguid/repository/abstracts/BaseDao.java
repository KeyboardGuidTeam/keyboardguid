package com.durumluemrullah.keyboardguid.repository.abstracts;

import java.math.BigInteger;
import java.util.*;
public interface BaseDao<T> {

    List<T> getAll();
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    T getById(BigInteger id);
}
