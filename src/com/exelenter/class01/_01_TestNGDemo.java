package com.exelenter.class01;

import org.testng.annotations.*;

public class _01_TestNGDemo {

    /**
     *  TestNG Methods run by ascending order (alphabetically, alphanumeric).
     *  sayH  <=== this runs second
     *  sayB  <=== this runs first
     */

    @Test
    public void test1() {               // each one considered as a Test Case and Method.
        System.out.println("Test One");
    }
    @Test
    public void test2() {
        System.out.println("Test Two");
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
        System.out.println("Before Test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test");
    }

}
