package com.company;

import jdk.management.cmm.SystemResourcePressureMXBean;

import java.io.IOException;
import java.util.*;

public class Main {

    static Input user = new Input();

    public static void main(String[] args) {

        boolean valid = false;

        while (!valid){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Type in a String: ");
                String string = scan.nextLine();
                user.input(string);
                valid = true;

            }catch (InputMismatchException ex){

            }
        }
        valid = false;
        while (!valid){
            try{

                Scanner scan = new Scanner(System.in);
                System.out.println("Type in an Integer: ");
                int integer = scan.nextInt();
                user.input(integer);
                valid = true;

            }catch (InputMismatchException ex){
                String exit;
                Scanner scan = new Scanner(System.in);
                System.out.println("That is not an Integer(Press enter to continue)");
                exit = scan.nextLine();
            }
        }
        valid = false;

        while (!valid){
            try{

                Scanner scan = new Scanner(System.in);
                System.out.println("Type in a Double: ");
                Double doub = scan.nextDouble();
                user.input(doub);
                valid = true;

            }catch (InputMismatchException ex){
                String exit;
                Scanner scan = new Scanner(System.in);
                System.out.println("That is not a Double(Press enter to continue)");
                exit = scan.nextLine();
            }
        }

        System.out.println("Wow you typed in valid values. Good Job");
        System.out.println("String: " + user.getString());
        System.out.println("Integer: " + user.getInteger());
        System.out.println("Double: " + user.getDoub());

    }


    public static class Input{

        static String string;
        static int integer;
        static double doub;

        public Input(){
        }

        public static void input(String value){

            string = value;
        }

        public static void input(Integer value){
            integer = value;
        }

        public static void input(Double value){
            doub = value;
        }

        public int getInteger() {
            return integer;
        }

        public String getString() {
            return string;
        }

        public double getDoub() {
            return doub;
        }
    }
}
