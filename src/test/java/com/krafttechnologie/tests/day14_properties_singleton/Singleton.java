package com.krafttechnologie.tests.day14_properties_singleton;

public class Singleton {
    private Singleton(){

    }
    private static String str;
    public static String getString(){
        if (str==null){
            System.out.println("str is null, assigning a value to it");
            str="chrome";
        }else {
            System.out.println("it has value, just return it");
        }return str;
    }
}
