package com.company;

import java.io.File;
import java.util.Scanner;

public class getUserDetails {
    int userAge,currentWeight,goal,goalWeight,currentHeight,gender,activityType,targetDays;
    double targetCalories;
    String name,strActivityType;

    /**
     * Retrieving user's data from file and saving in respective variables
     * @param userName username of the current user
     */
    public void gettingUserDetails(String userName){
        File userDataFile = new File("D:\\Fit\\User'sData\\" + userName + ".txt");
        try {
            Scanner sc = new Scanner(userDataFile);
            sc.useDelimiter("[,]");
            name = sc.next();
            userAge = Integer.parseInt(sc.next());
            String strGender = sc.next();
            currentWeight = Integer.parseInt(sc.next());
            goal = Integer.parseInt(sc.next());
            goalWeight = Integer.parseInt(sc.next());
            strActivityType = sc.next();
            currentHeight = Integer.parseInt(sc.next());
            targetCalories = Double.parseDouble(sc.next());
            targetDays= Integer.parseInt(sc.next());
            if (strGender.equals("m")) {
                gender = 1;
            } else {
                gender = 2;
            }
            switch (strActivityType) {
                case "Sedentary" -> activityType = 1;
                case "LowActive" -> activityType = 2;
                case "Active" -> activityType = 3;
                case "VeryActive" -> activityType = 4;
            }
        }
        catch (Exception e){
            System.out.println("Error code 004: problem in getting user details"+e);
        }
    }
}

