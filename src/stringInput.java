package com.company;

import java.util.Scanner;

public class stringInput {
    Scanner sc = new Scanner(System.in);
    /**
     * This is the string input user going to enter
     */
    String value;

    /**
     * Get's user's input and check if user input is a valid string or no
     * @return User's string input
     */
    public String getStringInput(){
        while (true){
            try{
                value = sc.nextLine();
                // Checking if the user input have any integers or extra characters
                boolean flag = value.chars().allMatch(Character::isLetter);
                if(flag){
                    break;
                }
                System.out.println("Enter alphabets only");
            }
            catch (Exception e){
                System.out.println("Enter a valid option");
                sc.next();
            }
        }
        return value;
    }
}
