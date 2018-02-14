package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        List fullList =  new ArrayList();
        List city =  new ArrayList();
        List<Double> avgTemp =  new ArrayList();
        double i = 0, temp, avg = 0;
        Scanner scan = new Scanner(System.in);
        String choice;
        int place = 0;


        while (0==0){
            System.out.println("Type the name of a city. Type END to stop entering cities.");
            choice = scan.nextLine();
            choice.trim();
            if (choice.equals("END")){
                break;
            }else{
                if (choice.equals("")){

                }
                else{
                    city.add(choice);
                    fullList.add(choice);
                }

            }
        }

        while(place < city.size()){
            createTemp(avgTemp, city, place);
            fullList.add(avgTemp);
            place++;
            avg = calcAvg(avgTemp);
            fullList.add(avg);
            avgTemp = new ArrayList();
        }

        printAvg(place, fullList);



}

    public static List createTemp(List avgTemp, List city, int place) {
        double temp;
        int i = 0;
        String choice;
        while(i<5){
            Scanner fix = new Scanner(System.in);

            try{

                System.out.println("Type in a temperature for day " + (i+1) + " in the city " + city.get(place));
                temp = fix.nextDouble();
                avgTemp.add(temp);
                i++;
            }
            catch (InputMismatchException ex){
                System.out.println("Type in a number this time. Push enter to continue.");
                choice = fix.nextLine();
            }
        }
    return avgTemp;
    }

    public static double calcAvg(List<Double> avgTemp) {
        double avg = 0;

        for(int i = 0; i < avgTemp.size(); i++){
            avg += avgTemp.get(i);
        }
        avg = avg/5;
        return avg;
    }

    public static void printAvg(int place, List fullList) {
        for(int i = 0; i < place; i++){
            System.out.println("For the city " + fullList.get(i) + " the average was: " + fullList.get(place + i*2 + 1));
        }
    }
}
