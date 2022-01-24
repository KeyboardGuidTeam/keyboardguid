package com.durumluemrullah.keyboardguid.repository.concreate;

import com.durumluemrullah.keyboardguid.common.annotations.Collumn;
import com.durumluemrullah.keyboardguid.common.annotations.Table;
import com.durumluemrullah.keyboardguid.repository.abstracts.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T> {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper rowMapper;
    private final Class<T> tClass;
    private final Annotation[] declaredAnnotations;
    private final Field[] declaredFields;

    public BaseDaoImpl(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
        this.tClass=(Class<T>)
                ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        this.declaredAnnotations = tClass.getDeclaredAnnotations();
        this.declaredFields= tClass.getDeclaredFields();
    }


    @Override
    public List<T> getAll() {

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM ");

        queryBuilder.append("\"").append(getTableName()).append("\"");

        return jdbcTemplate.query(queryBuilder.toString(),rowMapper);
    }

    @Override
    public void create(T entity) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ").append("\"").append(getTableName()).append("\" (");

        for (Field declaredField : declaredFields) {
            Annotation[] declaredFieldAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredFieldAnnotation : declaredFieldAnnotations) {
                if(declaredFieldAnnotation.annotationType().getName().equals("com.durumluemrullah.keyboardguid.common.annotations.Collumn")){
                    if(!((Collumn) declaredFieldAnnotation).id()){
                        queryBuilder.append("\"")
                                .append(((Collumn) declaredFieldAnnotation).name())
                                .append("\",");
                    }
                }

            }
        }

        queryBuilder.append(") VALUES (");
        Map<String,Object> paramValues = new HashMap<>();


        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Annotation[] declaredFieldAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredFieldAnnotation : declaredFieldAnnotations) {
                if(declaredFieldAnnotation.annotationType().getName().equals("com.durumluemrullah.keyboardguid.common.annotations.Collumn")){
                    if(!((Collumn) declaredFieldAnnotation).id()){
                       queryBuilder.append(":").append(((Collumn) declaredFieldAnnotation).name()).append(",");
                        try {
                            paramValues.put(((Collumn) declaredFieldAnnotation).name(),declaredField.get(entity));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        queryBuilder.append(")");
        String query = queryBuilder.toString();
        query =query.replace(",)",")");



        namedParameterJdbcTemplate.update(query,paramValues);


    }

    @Override
    public void update(T entity) {

        StringBuilder queryBuilder = new StringBuilder();
        String condition="";
        queryBuilder.append("UPDATE ").append(getTableName())
                .append(" SET ");

        Map<String,Object> paramValues = new HashMap<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Annotation[] declaredFieldAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredFieldAnnotation : declaredFieldAnnotations) {
                if(declaredFieldAnnotation.annotationType().getName().equals("com.durumluemrullah.keyboardguid.common.annotations.Collumn")) {
                    if (!((Collumn) declaredFieldAnnotation).id()) {
                        queryBuilder.append("\"").append(((Collumn) declaredFieldAnnotation).name()).append("\"=")
                        .append(":").append(((Collumn) declaredFieldAnnotation).name()).append(",");
                        try {
                            paramValues.put(((Collumn) declaredFieldAnnotation).name(),declaredField.get(entity));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        condition="WHERE "+"\""+((Collumn) declaredFieldAnnotation).name()+"\"="+":"+((Collumn) declaredFieldAnnotation).name();
                        try {
                            paramValues.put(((Collumn) declaredFieldAnnotation).name(),declaredField.get(entity));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }

        queryBuilder.append(condition);
        String query = queryBuilder.toString();
        query = query.replace(",W"," W");

        namedParameterJdbcTemplate.update(query,paramValues);

    }

    @Override
    public void delete(T entity) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("DELETE FROM ").append(getTableName()).append(" WHERE ");

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Annotation[] declaredFieldAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredFieldAnnotation : declaredFieldAnnotations) {
                if(declaredFieldAnnotation.annotationType().getName().equals("com.durumluemrullah.keyboardguid.common.annotations.Collumn")){
                    if(((Collumn) declaredFieldAnnotation).id()){
                        queryBuilder.append(((Collumn) declaredFieldAnnotation).name()).append(" = ");
                        try {
                            queryBuilder.append(declaredField.get(entity));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        jdbcTemplate.execute(queryBuilder.toString());
    }

    @Override
    public T getById(BigInteger id) {

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM").append(getTableName()).append(" WHERE ");

        Map<String,Object> paramValues = new HashMap<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Annotation[] declaredFieldAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredFieldAnnotation : declaredFieldAnnotations) {
                if(((Collumn) declaredFieldAnnotation).id()){
                    queryBuilder.append(((Collumn) declaredFieldAnnotation).name()).append(" = :").append(((Collumn) declaredFieldAnnotation).name());

                    paramValues.put(((Collumn) declaredFieldAnnotation).name(),id);
                }
            }
        }


        return (T) namedParameterJdbcTemplate.queryForObject(queryBuilder.toString(),paramValues,rowMapper);
    }

    private String getTableName (){
        String tableName=null;
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if(declaredAnnotation.annotationType().getName().equals("com.durumluemrullah.keyboardguid.common.annotations.Table")){
                tableName = ((Table)declaredAnnotation).name();
            }
        }
        return tableName;
    }


}
