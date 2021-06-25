package com.company;

import java.util.Scanner;

public class doubleInput {
    Scanner sc = new Scanner(System.in);
    double value;
    public double doubleCheck(){   // checking if a value entered by user is a double datatype
        while (true){
            try{
                value = sc.nextDouble();
                break;
            }
            catch (Exception e){
                System.out.println("Enter a valid option");
                sc.next();
            }
        }
        return value;
    }
}
