package com.curry.exercise1;

public class Main {
    /*
    Drake Curry
    1/22/2018
    CSCI 1660
     */
    public static void main(String[] args) {

        int[] avgHigh = {32, 25, 27, 40, 45};

        double avg = 0;

        int zip, i;

        String city;

        for (i = 0; i <= 4; i++) {
            avg += avgHigh[i];
        }

        System.out.println("The average high is :" + avg/5);

        city = "Columbus";

        System.out.println("The city is " + city);

        zip = 43215;

        System.out.println("The zip code is " + zip);


        int x = 21;
        while (x < 20) {
            System.out.println("Do you know da wae");
        }
    }
}