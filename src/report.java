package com.company;

import java.io.File;
import java.util.Scanner;

/**
 * Used to show reports of user's data
 */
public class report {
    /**
     * To show a specific day report by reading the data from file
     * @param userName Username of the current user
     * @param day The specific day user wanna see report
     */
    public void showDaySpecificData(String userName,int day){
        double breakfastCalories=0.0,lunchCalories=0.0,dinnerCalories=0.0,snackAndOthersCalories=0.0;
        boolean flag=false;
        try {
            File dayWiseFile = new File("D:\\Fit\\DaywiseData\\" + userName + ".txt");
            Scanner sc = new Scanner(dayWiseFile);
            sc.useDelimiter("[,|,|\n]");
            while (sc.hasNext()&&!flag){
                int tempDay = Integer.parseInt(sc.next());
                breakfastCalories=Double.parseDouble(sc.next());
                lunchCalories=Double.parseDouble(sc.next());
                dinnerCalories=Double.parseDouble(sc.next());
                snackAndOthersCalories=Double.parseDouble(sc.next());
                if(tempDay==day){
                    flag=true;
                }
            }
            System.out.println("Day:"+day);
            System.out.println("Breakfast:"+breakfastCalories+"\n"+"Lunch:"+lunchCalories+"\n"+"Dinner:"+dinnerCalories+"\n"+"Snacks And Others:"+snackAndOthersCalories);
            System.out.println("Total Calories of the day:"+(breakfastCalories+lunchCalories+dinnerCalories+snackAndOthersCalories));
        }
        catch (Exception e){
            System.out.println("Error: 007,error in report");
        }
    }

    /**
     * To show all data upto current day of the user
     * @param userName The username of the current user
     */
    public void fullDayReport(String userName){
        File userFile = new File("D:\\Fit\\Data\\" + userName + ".txt");
        try {
            Scanner sc = new Scanner(userFile);
            sc.useDelimiter("[,\n]");
            while (sc.hasNext()) {
                String day = sc.next();
                try {
                    String calorie = sc.nextLine().substring(1);
                    System.out.println("Day" + day + ":" + calorie + "calories");
                } catch (Exception e) {
                    break;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error 008:,error in showing report");
        }
    }
    public void weeklyReport(String username,double targetCalories,int day){
        double goalCalories,userCalories=0.0;
        File userFile = new File("D:\\Fit\\Data\\"+username+".txt");
        if(day%7==0) {
            try {
                goalCalories = targetCalories * day;
                Scanner sc = new Scanner(userFile);
                sc.useDelimiter("[,\n]");
                while (sc.hasNext()) {
                    String strDay = sc.next();
                    try {
                        String strCalorie = sc.nextLine().substring(1);
                        userCalories += Double.parseDouble(strCalorie);
                    } catch (Exception e) {
                        break;
                    }
                }
                sc.close();
                if (day <= 5) {
                    if (userCalories < (goalCalories - 500)) {
                        System.out.println("Looks like your progress is not going well,your lack of calorie and need to eat more");
                    } else if (userCalories > (goalCalories + 500)) {
                        System.out.println("Looks like your progress is not going well,your consuming more calories than limit try to workout");
                    } else {
                        System.out.println("Your doing great,soon you will achieve your goal");
                    }
                } else {
                    if (userCalories < (goalCalories - 1000)) {
                        System.out.println("Looks like your progress is not going well,your lack of calorie and need to eat more");
                    } else if (userCalories > (goalCalories + 1000)) {
                        System.out.println("Looks like your progress is not going well,your consuming more calories than limit try to workout");
                    } else {
                        System.out.println("Your doing great,soon you will achieve your goal");
                    }
                }
                //report implementation
            } catch (Exception e) {
                System.out.println("error in weekly report");
            }
        }
    }
}
