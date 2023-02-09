package com.exelenter.class03;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertRecap {

    @Test
    public void testCase() {
        // Note: Please only use one at a time.

        // Example of Hard Assert
//        System.out.println("Before Assert");
//        Assert.assertTrue(false);
//        System.out.println("After Assert");       // This line won't print if Assert before it fails.

        // Example of Soft Assert
        System.out.println("Before Soft Assert");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(true);
        System.out.println("After Soft Assert");  // This line will print, even if soft Assert before it fails.
        soft.assertAll();
        System.out.println("ALL test steps passed.");  // This line will print if ALL steps pass, otherwise it will not print.
    }

    // Remember: Use only one Assertion per Test Case (@Test method).
    // I am using multiple because of hard and soft assertion demonstration.
}
