package com.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersAndGroups {
    @Parameters({"he"})
    @Test(groups = "babes")
    public void test1(String s){
        System.out.println(s);
        System.out.println("test1 = group smoke");
    }

    @Test(groups = "regression")
    public void test2(){
        System.out.println();
        System.out.println("test2 = group regression");
    }

    @Test(groups = "babes")
    public void test3(){
        System.out.println();
        System.out.println("test3 = group smoke");
    }
}
