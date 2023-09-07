package com.krafttechnologie.tests.day20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object [][] tvAndRating(){
        String[][] data={
                {"Game Of Thrones","10"},
                {"Breaking Bad","9"},
                {"Prison Break","10"},
                {"The Billion Dollar Code","9"},
                {"Chernobyl","10"},
                {"The Walking Dead","9"},
                {"Kurtlar Vadisi","8"},
                {"Geniş Aile","8"}
        };
        return data;
    }
    @Test(dataProvider = "tvAndRating")
    public void testTvShow(String tvShow,String rating){
        System.out.println("Tv show " + tvShow + "has rating " + rating);
    }
}
