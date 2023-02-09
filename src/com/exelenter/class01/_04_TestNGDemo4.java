package com.exelenter.class01;

import org.testng.annotations.*;

public class _04_TestNGDemo4 {
    @Test()    // If you want to ignore a test, use attribute 'enabled=false' (do not run this test).
    public void test1() {
        System.out.println("--Test One--");
    }
    @Test()
    public void test2() {
        System.out.println("--Test Two--");
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
        System.out.println("=========> Before Test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("=========> After Test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("=================> Before Class");
    }

    @AfterClass
    void afterClass() {
        System.out.println("=================> After Class");
    }

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After Suite");
    }

}
