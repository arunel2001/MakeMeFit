package com.company;

import java.io.File;
import java.util.Scanner;

public class goalTracker {
    /**
     * Checking if user achieved his goal in the calculated days
     * @param userName username of the current user
     * @param currentDay the current day
     * @param targetDays The days set as deadline for the user's goal
     * @param targetCalorie The amount of calories user need to eat daily
     * @return 1 if user had chived his goal 2 if user couldn't achieve his goal,else 0 when got some error in execution
     */
    public int checkTargetDays(String userName,int currentDay,int targetDays,double targetCalorie) {
        double totalCalories=0.0;
        File userFile = new File("D:\\Fit\\Data\\" + userName + ".txt");
        try {
            if(currentDay>=targetDays){
                try {
                    Scanner sc = new Scanner(userFile);
                    sc.useDelimiter("[,\n]");
                    while (sc.hasNext()) {
                        String dummy = sc.next();
                        String dayWiseCalories = sc.next();
                        totalCalories+=Double.parseDouble(dayWiseCalories);
                    }
                    sc.close();
                    //if achieved goal
                    if(totalCalories==(targetCalorie*targetDays)){
                        return 1;
                    }
                    else{
                        return 2;
                    }
                }
                catch (Exception e){
                    System.out.println("Error in checking calories"+e);
                }
            }
        }
        catch (Exception e){
            System.out.println("Error in checking target values");
        }
        return 0;
    }
}
