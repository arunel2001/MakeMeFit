package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class workoutSession {
    /**
     * Read a workout file and generate 3 random values and print the 3 random workouts from the file
     * @param userName username of the current user
     * @return 1 if user needs to workout on the current day else 0
     */
    public int workoutDetails(String userName){
        String path="";
        int day;
        getUserDetails getUserDetailsObj = new getUserDetails();
        File dayFile = new File("D:\\Fit\\Data\\"+userName+".txt");
        getUserDetailsObj.gettingUserDetails(userName);
        int goal = getUserDetailsObj.goal;
        if(goal==1){
            path ="workoutforweightgain";
        }
        else if(goal==3){
            path = "workoutforweightloss";
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader(dayFile));
            String last = "", line;
            while ((line = input.readLine()) != null) {
                last = line;
            }
            day = Integer.parseInt(last);
            if(day%2!=0){
                File workoutFile = new File("D:\\Fit\\WorkoutData\\"+path+".txt");
                ArrayList<String> workoutArray = new ArrayList<>();
                Scanner sc = new Scanner(workoutFile);
                while (sc.hasNext()){
                    workoutArray.add(sc.nextLine());
                }
                sc.close();
                Random r = new Random();
                int[] threeRandomNumbers = r.ints(3, 0, 9).toArray();
                for (int i=0;i<3;i++){
                    System.out.println(workoutArray.get(threeRandomNumbers[i]));
                }
                return 1;
            }
        }
        catch (Exception e){
            System.out.println("Error 006:error in workout"+e);
        }
        return 0;
    }
}
