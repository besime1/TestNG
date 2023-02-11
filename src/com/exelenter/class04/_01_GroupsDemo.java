package com.exelenter.class04;

import org.testng.annotations.Test;

public class _01_GroupsDemo {
    @Test(dependsOnMethods = "test2")
    void test1(){
        System.out.println("Test 1");
    }
    @Test(groups="smoke")
    void test2(){
        System.out.println("Test 2");

    }
    @Test(groups="regression")
    void test3(){
        System.out.println("Test 3");
    }

    @Test(groups={"smoke","regression"})

    void test4(){
        System.out.println("Test 4");
    }
    @Test
    void test5(){
        System.out.println("test 5");
    }

    @Test
    void test6(){
        System.out.println("test6");
    }

}
