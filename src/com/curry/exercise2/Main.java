package com.curry.exercise2;

public class Main {
/*
Drake Curry
1/22/2018
CSCI 1660
 */
    public static void main(String[] args) {
        /*
        Drake Curry
        1/22/2018
        CSCI 1660
         */
        int[] temp = {45, 29, 10, 22, 41, 28, 33}, rain = {95, 60, 25, 5, 0, 75, 90};

        int x;

        for(x=0; x<6; x++)
        {
            if(temp[x]<=32 && rain[x] > 50 ){
                System.out.println("The high for the day is: " + temp[x] + " and the chance of snow is: " + rain[x] + "%");
            }

        }
        System.out.println("Those are the days that are likely to snow.");
    }
}