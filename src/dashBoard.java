package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Main Dashboard of the app
 */
public class dashBoard {
    integerInput integerInputObj = new integerInput();
    integerInputWithRange integerInputWithRangeObj = new integerInputWithRange();
    Scanner sc = new Scanner(System.in);
    public static double todayTotalCalories,snacksAndOtherCalories,breakfastCalories,lunchCalories,dinnerCalories,calorieValue;
    getUserDetails getUserDetailsObj = new getUserDetails();
    stringInput stringInputObj = new stringInput();
    day dayObj = new day();

    /**
     * Tracking user's breakfast,lunch,dinner,snacks calories also providing feature to see reports and log out
     * @param userName username of the current user
     */
    public int calorieTracker(String userName) {
        getUserDetailsObj.gettingUserDetails(userName);
        double targetCalories = getUserDetailsObj.targetCalories;
        int targetDays = getUserDetailsObj.targetDays;
        int CD = dayObj.getCurrentDay(userName);

        System.out.println("Target Days:"+(targetDays-(CD-1)));
        System.out.println("Calories Consumed " + todayTotalCalories);
        if (targetCalories > todayTotalCalories) {
            System.out.println("Calories Remaining " + (targetCalories - todayTotalCalories));
        }
        else if(targetCalories<(todayTotalCalories+200)){
            System.out.println("You have consumed extra today");
        }
        else{
            System.out.println("You have achieved today's goal");
        }
        System.out.println("1.Breakfast\n2.Lunch\n3.Dinner\n4.Snacks and others\n5.Fill average for today?\n6.Start workout\n7.Report\n8.Settings");
        int choice = integerInputWithRangeObj.integerCheckWithRange(8);
        if (choice == 5) {
            //average
            average averageObj = new average();
            averageObj.fillAverage(userName);
        } else if (choice == 6) {
            //workout
            workoutSession workoutSessionObj = new workoutSession();
            int restDayFlag = workoutSessionObj.workoutDetails(userName);
            if (restDayFlag == 0) {
                System.out.println("Today is your rest day");
            }
        } else if (choice == 7) {
            //report
            report reportObj = new report();
            System.out.println("1.Any specific day report?");
            System.out.println("2.Full report ");
            int reportChoice = integerInputWithRangeObj.integerCheckWithRange(2);
            if (reportChoice == 1) {
                System.out.println("Which day report you wanna see?");
                int day = integerInputObj.integerCheck();
                reportObj.showDaySpecificData(userName, day);
            } else {
                reportObj.fullDayReport(userName);
            }
        } else if (choice == 8) {
            //settings
            settings settingsObj = new settings();
            int logOutFlag = settingsObj.settingOptions(userName);
            if(logOutFlag==1){
                return 1;
            }
        } else {
            foodData foodDataobj = new foodData();
            System.out.println("Select the food");
            //displaying available food
            foodDataobj.showFoodData();
            String foodNo = sc.nextLine();
            if (!foodNo.equals("a")) {
                double foodCalories = foodDataobj.foodSearch(foodNo);
                System.out.println("Enter the quantity:");     //getting quantity and calculating the calories
                int quantity = integerInputObj.integerCheck();
                calorieValue = (foodCalories * quantity);
            } else {
                System.out.println("Enter the food name:");
                String foodName = sc.nextLine();
                System.out.println("Enter the quantity of " + foodName + " you ate today(If it's something like rice and measured in grams or cups feel free to enter it)");
                int quantity = integerInputObj.integerCheck();
                System.out.println("Enter the calories of it");
                calorieValue = sc.nextDouble();
                foodDataobj.addFood(foodName, quantity, calorieValue);
            }
            todayTotalCalories += calorieValue;
            switch (choice) {
                case 1 -> breakfastCalories += calorieValue;
                case 2 -> lunchCalories += calorieValue;
                case 3 -> dinnerCalories += calorieValue;
                case 4 -> snacksAndOtherCalories += calorieValue;
            }
        }
        return 0;
    }

    /**
     * Storing the calories in taken by the user on the full day
     * @param currentUserName username of the current user
     * @param newUserFlag 1 if the user is a new user and creating his first file,else 0
     * @return current day of the user
     */
    public int writingCalorieData(String currentUserName,int newUserFlag){            //storing data into the file
        File dayFile = new File("D:\\Fit\\Data\\"+currentUserName+".txt");
        if(newUserFlag==1){
            try {
                FileWriter writing = new FileWriter(dayFile, true);
                writing.write("1" + "," + todayTotalCalories);
                writing.append(System.lineSeparator());
                writing.write("2"); //adding the next day count into the file
                writing.close();
            }
            catch (Exception e){
                System.out.println("New user day adding error");
            }
        }
        else {
            try {
                BufferedReader input = new BufferedReader(new FileReader(dayFile));
                String last = "", line;
                while ((line = input.readLine()) != null) {
                    last = line;
                }
                int currentDay = Integer.parseInt(last); //retrieving day count from data file
                RandomAccessFile f = new RandomAccessFile(dayFile, "rw");
                long length = f.length() - 1;
                byte b = 0;
                do {             // deleting the current day line in the file
                    length -= 1;
                    f.seek(length);
                    b = f.readByte();
                } while (b != 10);
                f.setLength(length + 1);
                f.close();
                FileWriter writing = new FileWriter(dayFile, true);
                writing.write(currentDay + "," + todayTotalCalories);
                writing.append(System.lineSeparator());
                writing.write(String.valueOf(currentDay + 1)); //adding the next day count into the file
                writing.close();
                return currentDay;
            } catch (Exception e) {
                System.out.println("User data corrupted,try creating a new account" + e);
            }
        }
        return 1;
    }

    /**
     * Storing user's data in a structured format as breakfast,lunch,snacks respectively
     * @param userName username of teh current user
     * @param day Current day of the user
     */
    public void writingDayWise(String userName,int day){
        File dayWiseFile = new File("D:\\Fit\\DaywiseData\\"+userName+".txt");
        try{
        FileWriter writing = new FileWriter(dayWiseFile,true);
        writing.write(day+","+breakfastCalories+","+lunchCalories+","+dinnerCalories+","+snacksAndOtherCalories);
        writing.append(System.lineSeparator());
        writing.close();
        }
        catch (Exception e){
            System.out.println("error in writing day wise data");
        }
    }
}
