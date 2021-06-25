package com.company;

import java.util.Scanner;

public class calorieCheck {
    integerInput integerInputObj = new integerInput();
    stringInput stringInputObj = new stringInput();
    Scanner sc = new Scanner(System.in);
    /**
     * To Check if user had ate extra calories fot the current day
     * If user had taken some extra calories,recommending him certain workout to burn that excess calories
     * Providing user a option if he wants to do his own type of workout and saving the info of that workout in our database
     * @param todayTotalCalorie the amount of calories the user taken today
     * @param targetCalorie the amount of calories the user must take
     */
    public void loseWeight(double todayTotalCalorie, double targetCalorie) {
        workoutData workoutDataObj = new workoutData();
        if (todayTotalCalorie > targetCalorie) {
            double calorieNeedToBurn = todayTotalCalorie - targetCalorie;
            System.out.println("Today you took " + (calorieNeedToBurn) + " extra calories");
            //recommending workouts
            double calorieBurnRecommened = workoutDataObj.workoutRecommendation(calorieNeedToBurn);
            System.out.print("You can also do your own workout if you need,Press 1 if you wanna provide us the info of your workout so it would be east for you next time else 2");
            int choice = integerInputObj.integerCheck();
            if (choice == 1) {
                System.out.println("Enter your workout name:");
                String workoutName = stringInputObj.getStringInput();
                int flag = workoutDataObj.workoutSearch(workoutName);
                if (flag == 1) {
                    double calorieBurns = workoutDataObj.caloriesBurned;
                    int reps = (int) Math.round(calorieNeedToBurn / calorieBurns);
                    System.out.println("You need to do " + workoutName + " " + reps + " reps");
                    dashBoard.todayTotalCalories -= calorieBurns * reps;
                } else {
                    System.out.println("Sorry we currently don't hv info about this workout,provide as some info");
                    System.out.println("How many reps have you done?");
                    int reps = integerInputObj.integerCheck();
                    System.out.println("How much calorie it burns?");
                    double calorie = sc.nextDouble();
                    workoutDataObj.addWorkoutData(workoutName, reps, calorie);
                    System.out.println("Thank you for providing us with data");
                    dashBoard.todayTotalCalories -= calorie;
                }
            } else {
                dashBoard.todayTotalCalories -= calorieBurnRecommened;
            }
        }
    }

    /**
     * To Check if user is lacking some calories for the current day
     * Recommending him certain food to gain that lacking calories
     * Providing user a option if he wants to eat his own food and saving the info of that food in our database
     * @param todayTotalCalorie the amount of calories the user taken today
     * @param targetCalorie the amount of calories the user must take
     */
    public void gainWeight(double todayTotalCalorie, double targetCalorie) {
        foodData foodDataObj = new foodData();
        if (todayTotalCalorie < targetCalorie) {
            double calorieNeedToGain = targetCalorie - todayTotalCalorie;
            System.out.println("You still need " + (calorieNeedToGain) + " calorie today");
            //recommending foods
            Double calorieRecommended = foodDataObj.foodRecommendation(calorieNeedToGain);
            System.out.println("If you wanna eat you own food feel free to eat it press 1 if so else 2");
            int choice = integerInputObj.integerCheck();
            if (choice == 1) {
                System.out.println("Select the food available from us");
                foodDataObj.showFoodData();
                String foodNo = sc.nextLine();
                if (!foodNo.equals("a")) {
                    double foodCalories = foodDataObj.foodSearch(foodNo);
                    int quantityNeeded = (int) Math.round(calorieNeedToGain / foodCalories);
                    System.out.println("You need to eat " + quantityNeeded + " " + foodDataObj.tempFoodName);
                    dashBoard.snacksAndOtherCalories += (quantityNeeded * foodCalories);
                    dashBoard.todayTotalCalories += (quantityNeeded * foodCalories);

                }
                //Adding new food to database
                else {
                    System.out.println("Enter the food name:");
                    String foodName = sc.nextLine();
                    System.out.println("Enter the quantity of " + foodName + " you ate today(If it's something like rice and measured in grams or cups feel free to enter it");
                    int quantity = integerInputObj.integerCheck();
                    System.out.println("Enter the calories of it");
                    double calorieValue = sc.nextDouble();
                    foodDataObj.addFood(foodName, quantity, calorieValue);
                    dashBoard.snacksAndOtherCalories += (calorieValue);
                    dashBoard.todayTotalCalories += (calorieValue);
                }
            }
            else {
                dashBoard.snacksAndOtherCalories += calorieRecommended;
                dashBoard.todayTotalCalories += calorieRecommended;
            }
        }
    }
}