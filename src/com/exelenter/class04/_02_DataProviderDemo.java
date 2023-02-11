package com.exelenter.class04;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _02_DataProviderDemo {
    @Test
    void printData(){
        userList();
        data();
        // DataProvide it works with 2D Array and accepts Object as a Data type
        //Data Driven Testing:Behavior Drive Testing.(BBD,TDD).HR %70 (TestNg,Cucumber,SQL,Java,Python,,Js,Html/Css)
    }
    //Manipulating   DataProvider
    public  void userList(){
        List<String> stringArrayList= new ArrayList<>();
        stringArrayList.add("John");
        stringArrayList.add("Sam");
        //stringArrayList.add.(25);
        List<Object>objectList= new ArrayList<>();
        objectList.add("John");
        objectList.add(25);
        objectList.add(0.95);
        System.out.println("string ArrayList="+stringArrayList);
        System.out.println("objectList="+objectList);

    }
    public void data(){
        //single  object
        Object user= 10;       // All data type accepted , but only ONE at a time.
        // Array of OBJECT
        Object[] users= {"John Doe", "Sam Lee", 'c', 45};  // Now I can accept more than one value And all data types
        //2D Array ,Arrays of Arrays.
        Object[][] users2D={{"John Doe", "Sam Lee", 'c', 45},
                {"John Doe", "Sam Lee", 'c', 45},
                {"John Doe", "Sam Lee", 'c', 45}
        };
        System.out.println("user2D=" + Arrays.deepToString(users2D));

    }
}
