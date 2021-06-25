package com.company;

import java.util.Scanner;

public class integerInputWithRange {
    Scanner sc = new Scanner(System.in);
    /**
     * User's input data
     */
    int value;

    /**
     * Get user's input and check if the input is integer and within the range
     * @param range The limit of integer upto which an user can enter
     * @return User's integer input data
     */
    public int integerCheckWithRange(int range){
        while (true){
            try{
                value = sc.nextInt();
                if(value>0 && value<=range) {
                    break;
                }
                System.out.println("Enter numbers from the option given above");
            }
            // If user's enter some string or other characters
            catch (Exception e){
                System.out.println("Enter a valid option");
                sc.next();
            }
        }
        return value;
    }
}
