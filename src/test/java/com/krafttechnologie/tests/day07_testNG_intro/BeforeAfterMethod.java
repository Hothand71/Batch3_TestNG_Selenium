package com.krafttechnologie.tests.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass
    public void setUpClass(){
        System.out.println("-----Before Class-----");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("****Before Method=> WebDriver, Opening Browser ****");
    }
    @Test
        public void test1(){
        System.out.println("First Test Case");
    }
    @Test
        public void test2(){
        System.out.println("Second Test Case");
    }
    @Test @Ignore
    public void test3() {
        System.out.println("Third Test Case");
    }
    @AfterMethod
        public void tearDown(){
        System.out.println("****After Method=> Closing Browser, Quit****");
    }
    @AfterClass
        public void tearDownClass(){
        System.out.println("-----After Class-----");
    }
}
