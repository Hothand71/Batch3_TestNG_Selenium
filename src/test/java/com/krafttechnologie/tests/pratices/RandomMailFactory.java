package com.krafttechnologie.tests.pratices;

import java.util.Random;

public class RandomMailFactory {
    public static String makeEmail(String nickName){
        Random rd=new Random();
        String numbers=String.valueOf(rd.nextInt(1000,100000));
        return nickName+numbers+nickName.toUpperCase().charAt(0)+nickName.toUpperCase().charAt(nickName.length()-1)+"@example.com";

    }
}
