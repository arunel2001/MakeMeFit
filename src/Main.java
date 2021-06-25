package com.company;


public class Main {
    /**
     * This is the main method
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // write your code here
        logInCheck logInCheckObj = new logInCheck();
        getUserDetails getUserDetailsObj = new getUserDetails();
        dashBoard dashBoardObj = new dashBoard();
        while (true) {
            String userName = "";
            int newUserFlag = 0;
            //Creating objects
            String loggedFlag = logInCheckObj.logCheck();
            //Checking if a user is already logged in
            if (loggedFlag.equals("1")) {
                userName = logInCheckObj.currentUserName;
            }
            //If no user is logged in
            else {
                mainPage mainPageObj = new mainPage();
                login loginObj = new login();
                int choice = mainPageObj.welcomeMessage();
                //If user is a new user
                if(choice==0){
                    return;
                }
                else if (choice == 1) {
                    userName = loginObj.addingLoginDetails();
                    newUser newUserObj = new newUser();
                    newUserObj.addingNewUserDetails(userName);
                    newUserFlag = 1;
                }
                //if user already have an existing account
                //Verifying the user's login credentials
                else {
                    boolean authentication = false;
                    while (!authentication) {
                        authentication = loginObj.loginVerify(); //verifying credentials
                        if (!authentication) {
                            System.out.println("Wrong username and  password, try again");
                        } else {
                            userName = loginObj.userName;
                        }
                    }
                }
            }
            //Executing dashboard
            compute computeObj = new compute();
            int exitFlag = computeObj.runApp(userName, newUserFlag);
            if(exitFlag==1){
                break;
            }
        }
    }
}
