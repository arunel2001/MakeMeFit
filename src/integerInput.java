package com.company;

import java.util.Scanner;

public class integerInput {
    Scanner sc = new Scanner(System.in);
    /**
     * The data user going to enter
     */
    int value;
    /**
     * Get user's input and check if it's integer
     * @return User's integer input
     */
    public int integerCheck(){
        while (true){
            try{
                value = sc.nextInt();
                break;
            }
            // If user input contains string or other characters
            catch (Exception e){
                System.out.println("Enter a valid option");
                sc.next();
            }
        }
        return value;
    }
}
