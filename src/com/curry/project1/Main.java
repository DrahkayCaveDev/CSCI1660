package com.curry.project1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        List taskList = new ArrayList();


        while (choice != 0) {
            System.out.printf("%n1: Add a Task %n2: Remove a task %n3: Update a task %n4: List all Tasks %n0: Exit");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("%n%nEnter a number: ");
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                choice = -100;
            }

            if (choice > 1 && taskList.size() == 0) {
                choice = -2;
            }

            switch (choice) {
                case 1:
                    Add(taskList);
                    break;

                case 2:
                    Remove(taskList);
                    break;

                case 3:
                    Update(taskList);
                    break;

                case 4:
                    for (int i = 0; i < taskList.size(); i++) {
                        System.out.println(i + 1 + ": " + taskList.get(i));
                    }
                    System.out.printf("%nPress enter to continue ");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                    }

                case 0:
                    break;
                case -2:
                    System.out.printf("%nYou do not have enough tasks in your list to do that.");
                    break;
                default:
                    System.out.printf("%nHow about actually type in a number given to you.");
                    break;

            }


        }
    }

    public static List Add(List taskList) {
        String user;
        Scanner input = new Scanner(System.in);
        System.out.printf("%nWrite a task to add in: ");
        user = input.nextLine();
        taskList.add(user);

        return taskList;
    }

    public static List Remove(List taskList) {
        int userInt;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ": " + taskList.get(i));
        }

        try {
            Scanner inputInt = new Scanner(System.in);
            System.out.printf("%nChoose a task to remove by typing a number (type zero to not remove anything): ");
            userInt = inputInt.nextInt() - 1;
        } catch (InputMismatchException e) {
            userInt = -1;
        }
        if (taskList.size() < userInt + 1) {
            System.out.printf("%nHow about actually type in a number given to you.");

        } else {
            taskList.remove(taskList.get(userInt));

        }
        return taskList;
    }

    public static List Update(List taskList) {
        Scanner input = new Scanner(System.in);
        String user;
        int userInt;
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ": " + taskList.get(i));
        }
        try {
            Scanner inputInt = new Scanner(System.in);
            System.out.printf("%nChoose a task to update by typing a number (type zero to not update anything): ");
            userInt = inputInt.nextInt() - 1;
        } catch (InputMismatchException e) {
            userInt = -1;
        }
        if (userInt <= -1) {

        } else if (taskList.size() < userInt + 1) {
            System.out.printf("%nHow about actually type in a number given to you.");

        } else {
            System.out.printf("%nType in a new task.");
            user = input.nextLine();
            taskList.remove(userInt);
            if (userInt >= 0) {
                taskList.add(userInt, user);

            } else {
                taskList.add(user);

            }
        }
        return taskList;
    }
}
