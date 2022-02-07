package com.durumluemrullah.keyboardguid.model.pojos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;

import static org.junit.Assert.*;


public class CategoryTest {

    @InjectMocks
    Category category;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldFillPojo() {
        category.setCategoryId(BigInteger.ONE);
        category.setCategoryName("");

        category.getCategoryName();
        category.getCategoryId();

        category= new Category();

        Assert.assertNotNull(category);
    }
}