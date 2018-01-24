package com.curry.exercise3;

import java.util.Scanner;
/*
Drake Curry
1/22/2018
CSCI 1660
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );
        double convert = 0;
        String input;

        while(convert >= -267.77777777777777){

            try{
                System.out.print( "Feed me a fahrenheit temperature(type -451 or lower to end my suffering): " );

                input = (scanner.nextLine());

                convert = Double.parseDouble(input);

                convert =(convert - 32)*5/9;

                System.out.println( "Celsius: " + convert);
            }
            catch(NumberFormatException ex){
                System.out.print("Actually type a number(Press enter to continue)");
                input = (scanner.nextLine());
            }


        }

    }
}