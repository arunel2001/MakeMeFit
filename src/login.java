package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * All functions related to login
 * Opening login details file to manipulate it
 */
public class login {
    Scanner sc = new Scanner(System.in);
    File loginDetails = new File("D:\\Fit\\LoginDetails\\usersLoginDetails.txt");
    String userName;

    /**
     * Creating a new account for the user
     * @return The user name that the user chosen
     */
    public String addingLoginDetails(){
        String userName,password;
        System.out.println("Create a user name:");
        userName = sc.nextLine();
        System.out.println("Create a password");
        password = sc.nextLine();
        try {
            FileWriter writing = new FileWriter(loginDetails, true);
            writing.write(userName + "," + password);
            writing.append(System.lineSeparator());
            writing.close();
            System.out.println("Account Created successfully");
        }
        catch (Exception e){
            System.out.println("Error code: 002 ,Cannot create account,try again");
        }
        return userName;
    }

    /**
     * Checking credentials and allowing a person to log in
     * @return flag(true if user successfully logged in,else false)
     */
    public boolean loginVerify(){
        logStatus logStatusObj = new logStatus();
        String tempUsername,tempPassword;
        boolean flag=false;
        System.out.println("Enter the user name:");
        userName = sc.nextLine();
        System.out.println("Enter the password");
        String password = sc.nextLine();
        try {
            Scanner sc = new Scanner(loginDetails);
            sc.useDelimiter("[,\n]");
            while (sc.hasNext() && !flag) {
                tempUsername = sc.next();
                tempPassword = sc.next();
                if (tempUsername.trim().equals(userName.trim()) && tempPassword.trim().equals(password.trim())) {
                    flag = true;
                    userName = tempUsername;
                    logStatusObj.logIn(userName);
                }
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println("Error code:003 Can't log in...");
        }
        return flag;
    }
}
