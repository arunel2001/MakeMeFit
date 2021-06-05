package com.company;

public class mainPage {
    /**
     * Welcome message of the app
     * @return 1 if user doesn't have an account else 2
     */
    public int welcomeMessage(){
        integerInputWithRange integerInputWithRangeObj = new integerInputWithRange();
        int choice;
        System.out.println("*******Welcome to Make Me FIT********");
        System.out.println("1.New User?");
        System.out.println("2.Already have an account?");
        choice= integerInputWithRangeObj.integerCheckWithRange(2);
        if(choice==1)
            return 1;
        return 0;
    }
}
