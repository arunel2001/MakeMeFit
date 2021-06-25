package com.company;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class average {

    /**
     * Retrieve user's data and calculate average of each category using the data
     * @param userName username of the current user
     */
    public void fillAverage(String userName) {
        double totalDayCalorie, breakfastTotal = 0.0, lunchTotal = 0.0, dinnerTotal = 0.0, snacksAndOtherTotal = 0.0, breakfastAverage, lunchAverage, dinnerAverage, snacksAndOtherAverage;
        int totalDays = 0;
        File dayWiseFile = new File("D:\\Fit\\DaywiseData\\" + userName + ".txt");
        try {
            Scanner scDayWiseFile = new Scanner(dayWiseFile);
            scDayWiseFile.useDelimiter("[,|\n]");
            while (scDayWiseFile.hasNext()) {
                //Adding total days and calories
                totalDays += Integer.parseInt(scDayWiseFile.next());
                breakfastTotal += Double.parseDouble(scDayWiseFile.next());
                lunchTotal += Double.parseDouble(scDayWiseFile.next());
                dinnerTotal += Double.parseDouble(scDayWiseFile.next());
                snacksAndOtherTotal += Double.parseDouble(scDayWiseFile.next());
            }
            scDayWiseFile.close();
            //Finding the average
            breakfastAverage = breakfastTotal / totalDays;
            lunchAverage = lunchTotal / totalDays;
            dinnerAverage = dinnerTotal / totalDays;
            snacksAndOtherAverage = snacksAndOtherTotal / totalDays;
            totalDayCalorie = breakfastAverage + lunchAverage + dinnerAverage + snacksAndOtherAverage;
            // Modifying public static variables
            dashBoard.todayTotalCalories += totalDayCalorie;
            dashBoard.breakfastCalories += breakfastAverage;
            dashBoard.lunchCalories += lunchAverage;
            dashBoard.dinnerCalories += dinnerAverage;
            dashBoard.snacksAndOtherCalories += snacksAndOtherAverage;

        }catch (NoSuchElementException e) {
            System.out.println("No Previous records have been added");
        }
        catch (Exception e) {
            System.out.println("Error 005: error in average");
        }
    }
}
