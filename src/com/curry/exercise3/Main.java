package com.curry.exercise3;

import java.util.Scanner;
/*
Drake Curry
1/22/2018
CSCI 1660
 */
public class Main {

    public static void main(String[] args) {

        double convert = 0, answer = 0;

        String input;
        Scanner scanner = new Scanner(System.in);

        while (answer >= -273.3333333333333) {

            try {

                convert = UserInput();

                answer = Convertion(convert);


                System.out.println("Celsius: " + answer);
            } catch (NumberFormatException ex) {
                System.out.print("Actually type a number(Press enter to continue)");
                input = (scanner.nextLine());
            }


        }

    }
