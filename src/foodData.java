package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class foodData {
    String tempFoodName,strCalories,tempFoodNo;
    Double foodCalories;
    File foodList = new File("D:\\Fit\\FoodData\\foodList.txt");

    /**
     * Searching for the food that user had chosen
     * @param foodNo The number used to display the foods
     * @return The calories of the food that the user selected
     */
    public double foodSearch(String foodNo){
        try {
            Scanner sc = new Scanner(foodList);
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                tempFoodNo= sc.next();
                tempFoodName = sc.next();
                strCalories = sc.next();
                if (tempFoodNo.trim().equalsIgnoreCase(foodNo.trim())) {
                    foodCalories = Double.parseDouble(strCalories);
                    sc.close();
                    return foodCalories;
                }
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println("Error in loading food data"+e);
        }
        return 0.0;
    }

    /**
     * Adding the new food data in our database
     * @param foodName The name of the new food
     * @param quantity The quantity of the food that user ate
     * @param calories The calories of the food that the user ate
     */
    public void addFood(String foodName, int quantity, double calories){
        int index=0;
        double caloriesForSingleItem = calories/quantity;
        try {
            Scanner sc = new Scanner(foodList);
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                index = Integer.parseInt(sc.next());
                sc.next();
                sc.next();
            }
            sc.close();
            index += 1;
            FileWriter writing = new FileWriter(foodList, true);
            writing.append(System.lineSeparator());
            writing.write(index + "," + foodName + "," + caloriesForSingleItem);
            writing.close();
        }
        catch (Exception e){
            System.out.println("error in adding food");
        }
    }

    /**
     * Displaying food data from our database in a matrix format with indexed numbers
     */
    public void showFoodData(){
        try{
            Scanner sc = new Scanner(foodList);
            sc.useDelimiter("[,\n]");
            int i=0;
            while (sc.hasNext()) {
                if (i % 4 == 0) {
                    System.out.println();
                }
                String no = sc.next();
                String foodName = sc.next();
                System.out.print(no+"."+foodName);
                System.out.print(" ");
                sc.next();
                i++;
            }
            System.out.println();
            System.out.println("a.Others");
            sc.close();
        }
        catch (Exception e){
            System.out.println("error in displaying food data");
        }
    }

    /**
     * Recommending a food to user to eat according to the amount calorie he needs to eat
     * @param calorieNeedToGain the amount of calories he needs to eat
     * @return Recommended food calorie for single quantity
     */
    public Double foodRecommendation(Double calorieNeedToGain){
        List<Double>foodCalorieArray = new ArrayList<>();
        List<String>foodNameArray = new ArrayList<>();
        try {
            Scanner sc = new Scanner(foodList);
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                sc.next();
                tempFoodName = sc.next();
                strCalories = sc.next();
                foodCalorieArray.add(Double.parseDouble(strCalories));
                foodNameArray.add(tempFoodName);
            }
            sc.close();
            // Getting a value closet to calories need to gain in the foodcalorie array
            int distance = (int) Math.abs(foodCalorieArray.get(0) - calorieNeedToGain);
            int idx = 0;
            for(int c = 1; c < foodCalorieArray.size(); c++){
                int cdistance = (int) Math.abs(foodCalorieArray.get(c) - calorieNeedToGain);
                if(cdistance < distance){
                    idx = c;
                    distance = cdistance;
                }
            }
            Double calorieForSingleQuantity = foodCalorieArray.get(idx);
            String foodName = foodNameArray.get(idx);
            int quantityNeeded = (int) Math.round(calorieNeedToGain/calorieForSingleQuantity);
            System.out.println("You can eat "+quantityNeeded+" "+foodName);
            return quantityNeeded*calorieForSingleQuantity;
        }
        catch (Exception e){
            System.out.println("Error in loading food data"+e);
        }
        return 0.0;
    }
}
