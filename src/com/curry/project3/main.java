import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int choice = -1;

        Checklist checklist = new Checklist();

        while (choice != 0) {
            System.out.printf("%n1: Add a Task %n2: Remove a task %n3: Update a task %n4: List all Tasks %n0: Exit");
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.printf("%n%nEnter a number: ");
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                choice = -100;
            }

            if (choice > 1 && checklist.check() == 0) {
                choice = -2;
            }

            switch (choice) {
                case 1:
                    checklist.add();
                    break;

                case 2:
                    checklist.remove();
                    break;

                case 3:
                    checklist.update();
                    break;

                case 4:
                    checklist.sort();
                    checklist.read();
                    break;

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

}

interface SortViewer{
    void read();
    void sort();
}

class Checklist implements SortViewer {

    HashMap<Integer, List> taskList = new HashMap<>();
    ArrayList<Integer> size = new ArrayList<>();

    public void add() {
        List<String> user = new ArrayList<>();
        Boolean valid = false;
        int priority = 0;

        Scanner input = new Scanner(System.in);
        System.out.printf("%nWrite a task to add in: ");
        user.add(input.nextLine());
        System.out.printf("%nWrite a Description for said task: ");
        user.add(input.nextLine());

        while (!valid) {

            try {
                input = new Scanner(System.in);
                System.out.printf("%nWrite a priority this task between 0-5 (5 is highest priority): ");
                priority = input.nextInt();
                valid = true;
            } catch (InputMismatchException ex) {
                String exit;
                input = new Scanner(System.in);
                System.out.printf("%nChoose a number between 0-5(Press Enter to continue): ");
                exit = input.nextLine();
            }
        }

        user.add(String.valueOf(priority));
        size.add(taskList.size());
        taskList.put(taskList.size(), user);
    }

    public void remove() {
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
            taskList.remove(userInt);
        }
    }

    public void update() {
        int userInt;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ": " + taskList.get(i));
        }

        try {
            Scanner inputInt = new Scanner(System.in);
            System.out.printf("%nChoose a task to update by typing a number (type zero to not remove anything): ");
            userInt = inputInt.nextInt() - 1;
        } catch (InputMismatchException e) {
            userInt = -1;
        }
        if (taskList.size() < userInt + 1) {
            System.out.printf("%nHow about actually type in a number given to you.");

        } else {
            taskList.remove(userInt);

            List<String> user = new ArrayList<>();
            Boolean valid = false;
            int priority = 0;

            input = new Scanner(System.in);
            System.out.printf("%nWrite a task to add in: ");
            user.add(input.nextLine());
            System.out.printf("%nWrite a Description for said task: ");
            user.add(input.nextLine());

            while (!valid) {

                try {
                    input = new Scanner(System.in);
                    System.out.printf("%nWrite a priority this task between 0-5 (5 is highest priority): ");
                    priority = input.nextInt();
                    valid = true;
                } catch (InputMismatchException ex) {
                    String exit;
                    input = new Scanner(System.in);
                    System.out.printf("%nChoose a number between 0-5(Press Enter to continue): ");
                    exit = input.nextLine();
                }
            }
            user.add(String.valueOf(priority));
            if (userInt >= 0) {
                taskList.put(userInt, user);

            } else {

            }
        }
    }

    @Override
    public void read() {
        for (int i : size) {
            System.out.println(i + 1 + ": " + taskList.get(i));
        }
        System.out.printf("%nPress enter to continue ");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }


    public Integer check() {
        int valid = taskList.size();
        return valid;
    }

    @Override
    public void sort() {

        List<List> user = new ArrayList<>();

        ArrayList<String> newList = new ArrayList<>();
        for (int i : size) {
            newList.add(taskList.get(i).get(0).toString());
            taskList.put((i + size.size()), taskList.get(i));
            taskList.remove(i);
        }

        Collections.sort(newList);

        for (int i : size) {
            for (int q : size) {
                if (taskList.get(q + size.size()).get(0).equals(newList.get(i))) {
                    user.add(taskList.get(q + size.size()));
                    taskList.put(i, user.get(0));
                    user.removeAll(user);
                }
            }
        }


        for (int i : size) {
            taskList.put((i + size.size()), taskList.get(i));
            taskList.remove(i + size.size());
        }

        System.out.println(taskList);
    }
}
