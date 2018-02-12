package com.company;

import jdk.management.cmm.SystemResourcePressureMXBean;

import java.io.IOException;
import java.util.*;

public class Main {

    static Address address = new Address();

    public static void main(String[] args) {
        int choice = 1;


        String email, name;

        while (choice != 0) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.printf("Choose an action by typing a number");
                System.out.printf("%n1: Enter an email %n2: View emails %n3: Select email");
                choice = scan.nextInt();
            } catch (InputMismatchException ex) {
                choice = 5;
            }

            switch (choice) {
                case 1:
                    collect();
                    break;
                case 2:
                    address.view();
                    break;
                case 3:
                    address.search();
                    break;

                default:
                    Scanner scan = new Scanner(System.in);
                    String exit;
                    System.out.printf("Hows about type a number given to you jerk (Press Enter to continue)");
                    exit = scan.nextLine();
                    break;

            }
        }

    }

    public static void collect() {
        String email, name, valid = "False";

        while (valid.equals("False")) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a name: ");
            name = scan.nextLine();
            if (name.equals("")) {
                valid = "False";
                System.out.println("Sorry not a valid name.");
            } else {
                System.out.println("Enter an email: ");
                email = scan.nextLine();
                Person mail = new Person(email, name);
                address.save(mail.getPersonEmail(), mail.getPersonName());
                valid = "True";
            }
        }


    }

    public static class Person {
        static String personEmail, personName;

        public Person(String email, String name) {
            System.out.println("Your name is " + name + " and your email is " + email);
            personEmail = email;
            personName = name;

        }

        public static String getPersonEmail() {
            return personEmail;
        }

        public static String getPersonName() {
            return personName;
        }
    }

    public static class Address {
        static HashMap<String, String> book = new HashMap<String, String>();
        static List<String> keys = new ArrayList<String>();

        public Address() {
        }

        public static void save(String email, String name) {
            book.put(name, email);
            keys.add(name);
        }

        public static void view() {
            boolean valid = false;
            for (int i = 0; i < keys.size(); i++) {
                System.out.println("Name: " + keys.get(i) + ", Address: " + book.get(keys.get(i)));
                Scanner scan = new Scanner(System.in);
                String exit;
                System.out.println("Press enter to continue");
                exit = scan.nextLine();
                valid = true;
            }

            if (valid == false){
                String exit;
                Scanner scan = new Scanner(System.in);
                System.out.println("No Emails to view(Press enter to continue).");
                exit = scan.nextLine();
            }
        }

        public static void search() {
            Scanner scan = new Scanner(System.in);
            String choice = "", exit;
            int condtion = 1;

            if (keys.size() == 0) {
                System.out.println("No Emails to view(Press enter to continue).");
                exit = scan.nextLine();

            } else {
                while (condtion != 0) {
                    scan = new Scanner(System.in);
                    System.out.println("Type in the name of a person who's email you want or push enter without typing anything to stop");
                    choice = scan.nextLine();

                    if (choice.equals("")) {
                        condtion = 0;
                    } else {
                        if (book.get(choice) != null) {
                            System.out.println(choice + "'s email: " + book.get(choice));
                        } else {
                            System.out.println("Try again");
                            scan = new Scanner(System.in);
                            System.out.println(choice + " is not a valid user (Press enter to continue).");
                            exit = scan.nextLine();
                            choice = " ";
                        }
                    }

                }
            }
        }
    }
}
