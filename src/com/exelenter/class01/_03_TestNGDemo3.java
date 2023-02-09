package com.exelenter.class01;

import org.testng.annotations.*;

public class _03_TestNGDemo3 {
    @Test(enabled = true)    // If you want to ignore a test, use attribute 'enabled=false' (do not run this test).
    public void test1() {
        System.out.println("-- Test One --");
    }
    @Test
    public void test2() {
        System.out.println("-- Test Two --");
    }
    @Test
    public void test3() {
        System.out.println("-- Test Three --");
    }
    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("After Method");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("===> Before Test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("===> After Test");
    }

}
