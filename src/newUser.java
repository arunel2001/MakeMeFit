package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class newUser {
    integerInput integerInputObj = new integerInput();
    integerInputWithRange integerInputWithRangeObj = new integerInputWithRange();
    targetCalorieCalculator targetCalorieCalculatorObj = new targetCalorieCalculator();

    /**
     * Getting different data's from user and calculating his target calories and his target day to achieve it and
     * writing al details to user data file
     * @param currentUserName Username of the current user(String)
     */
    public void addingNewUserDetails(String currentUserName){
        String name,strGender,strActivityType="";
        int gender,goal,goalWeight=0,currentWeight,currentHeight,activityType,userAge,recommendedGoal;
        double targetCalories;
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Welcome---------");
        System.out.println("We just need to ask you a few quick questions\nso we can calculate your recommended daily calorie and help you achieve your goals!! ");
        System.out.println("Step: 1/7");
        System.out.println("What is your name?");
        name=sc.nextLine();
        System.out.println("Step: 2/7");
        System.out.println("What's your goal");
        System.out.println("""
                1.Gain weight
                2.Maintain your current weight
                3.Loss weight""");
        goal= integerInputWithRangeObj.integerCheckWithRange(3);
        if(goal==1){
            System.out.println("How much weight you wanna gain?");
            goalWeight=integerInputObj.integerCheck();
        }
        else if(goal==3){
            System.out.println("How much weight you wanna lose?");
            goalWeight= integerInputObj.integerCheck();
        }
        System.out.println("Step: 3/7");
        System.out.println("What's your daily activity level?");
        System.out.println("""
                1.Sedentary
                2.Low active
                3.Active
                4.Very active""");
        activityType= integerInputWithRangeObj.integerCheckWithRange(4);
        switch (activityType) {
            case 1 -> strActivityType = "Sedentary";
            case 2 -> strActivityType = "LowActive";
            case 3 -> strActivityType = "Active";
            case 4 -> strActivityType = "VeryActive";
        }
        System.out.println("Step: 4/7");
        System.out.println("Your Gender?");
        System.out.println("1.Male"+"\n"+"2.Female");
        gender=integerInputWithRangeObj.integerCheckWithRange(2);
        if(gender==1)
            strGender="Male";
        else
            strGender="Female";
        System.out.println("Step: 5/7");
        System.out.println("What's your current weight(in Kg)?");
        currentWeight= integerInputObj.integerCheck();
        System.out.println("Step: 6/7");
        System.out.println("What's your current height(in cm)?");
        currentHeight= integerInputObj.integerCheck();
        System.out.println("Step: 7/7");
        System.out.println("What's your age?");
        userAge= integerInputObj.integerCheck();
        // Calculating BMI and recommending user's ideal goal
        double bmi = currentWeight/((currentHeight/100.0)*(currentHeight/100.0));
        if(bmi<18.5){
            //Gain weight
            recommendedGoal=1;
        }
        else if(bmi>=18.5 && bmi<=25.0){
            // Maintain weight
            recommendedGoal=2;
        }
        else {
            //Loss weight
            recommendedGoal=3;
        }
        if(recommendedGoal==1 && goal!=1){
            System.out.println("According to your BMI it's better for you to gain some weight.\nPress 1 if you still wanna proceed with your own goal or 2 to change it according to your BMI");
            int goalFlag = integerInputWithRangeObj.integerCheckWithRange(2);
            if(goalFlag==2){
                goal=1;
            }
        }
        else if(recommendedGoal==2 && goal!=2){
            System.out.println("According to your BMI it's better for you to maintain your same weight.\nPress 1 if you still wanna proceed with your own goal or 2 to change it according to your BMI");
            int goalFlag = integerInputWithRangeObj.integerCheckWithRange(2);
            if(goalFlag==2){
                goal=2;
            }
        }
        else{
            if(recommendedGoal==3&&goal!=3) {
                System.out.println("According to your BMI it's better for you to lose some weight.\nPress 1 if you still wanna proceed with your own goal or 2 to change it according to your BMI");
                int goalFlag = integerInputWithRangeObj.integerCheckWithRange(2);
                if (goalFlag == 2) {
                    goal = 3;
                }
            }
        }
        targetCalories = targetCalorieCalculatorObj.calorieCalculator(currentWeight,currentHeight,userAge,gender,activityType,goal,goalWeight);
        // writing all user's data into a file
        try {
            File userGeneralData = new File("D:\\Fit\\userData\\" + currentUserName + ".txt");
            FileWriter writing = new FileWriter(userGeneralData);
            writing.write(name+ "," + userAge + "," + strGender + "," + currentWeight + "," + goal + "," + goalWeight + "," + strActivityType+","+currentHeight+","+targetCalories+","+targetCalorieCalculatorObj.targetDays);
            writing.close();
            logStatus logStatusObj = new logStatus();
            logStatusObj.logIn(currentUserName);
        }
        catch (Exception e){
            System.out.println("Error code 001: Error in adding user data");
        }
    }
}
