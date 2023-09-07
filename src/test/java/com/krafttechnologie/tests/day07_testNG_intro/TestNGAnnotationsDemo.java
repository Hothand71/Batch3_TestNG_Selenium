package com.krafttechnologie.tests.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Opening Browser");
    }
    @Test
    public void test1() {
        System.out.println("First Assertions");
        String actualTitle="Kraft";
        String expectedTitle="Kraft";
        Assert.assertEquals(actualTitle,expectedTitle,"Verify That actual");
        System.out.println("Second Assertions");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test2() {
        System.out.println("Second Assertions");
        Assert.assertEquals("test2","test2");
    }
    @Test
    public void test3() {
        String actualTitle="KraftTech";
        String expectedTitle="Kraft";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify that title starting Kraft");
    }
    @Test
    public void test4() {
        String email="krafttech@gmail.com";
        Assert.assertTrue(email.contains("@"));
    }
    @Test
    public void test5() {
     Assert.assertFalse(0>1,"Verify that 0 is not greater than 1");
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("Kraft","KRaft");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}
