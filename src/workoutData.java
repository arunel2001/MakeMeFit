package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class workoutData {
        String tempWorkoutName, strCaloriesBurned;
        String workoutName;
        double caloriesBurned, maxCalorieBurned = 0.0;
        File workoutList = new File("D:\\Fit\\WorkoutData\\workoutList.txt");

        public int workoutSearch(String workoutName) {
            try {
                Scanner sc = new Scanner(workoutList);
                sc.useDelimiter("[,\n]");
                while (sc.hasNext()) {
                    tempWorkoutName = sc.next();
                    strCaloriesBurned = sc.next();
                    if (tempWorkoutName.trim().equalsIgnoreCase(workoutName.trim())) {
                        caloriesBurned = Double.parseDouble(strCaloriesBurned);
                        sc.close();
                        return 1;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error in loading work data" + e);
            }
            return 0;
        }

        public double workoutRecommendation(Double caloriesNeedToBurn) {
            try {
                Scanner sc = new Scanner(workoutList);
                sc.useDelimiter("[,\n]");
                while (sc.hasNext()) {
                    String tempWorkoutName = sc.next();
                    String strCaloriesBurned = sc.next();
                    if (!strCaloriesBurned.equals("")) {
                        if (Double.parseDouble(strCaloriesBurned) > maxCalorieBurned) {
                            maxCalorieBurned = Double.parseDouble(strCaloriesBurned);
                            workoutName = tempWorkoutName;
                        }
                    }
                }
                sc.close();
                Double calorieForSingleRep = maxCalorieBurned;
                int reps = (int) (caloriesNeedToBurn / calorieForSingleRep);
                System.out.println("You can do " + workoutName + reps + " reps");
                return calorieForSingleRep * reps;
            } catch (Exception e) {
                System.out.println("Error in recommending workout" + e);
            }
            return 0.0;
        }

        public void addWorkoutData(String workoutName, int reps, Double calorieBurned) {
            Double calorieBurnedForSingleRep = calorieBurned / reps;
            try {
                FileWriter writing = new FileWriter(workoutList, true);
                writing.append(System.lineSeparator());
                writing.write(workoutName + "," + calorieBurnedForSingleRep);
                writing.close();
            } catch (Exception e) {
                System.out.println("Error in adding workout data");
            }
        }

}

