package com.company;

public class settings {
    integerInputWithRange integerInputWithRangeObj = new integerInputWithRange();

    /**
     * Proving features to edit user's details and logging out
     * @param userName username of the current user
     */
    public void settingOptions(String userName){
        System.out.println("1.Edit user details");
        System.out.println("2.Logout");
        int choice = integerInputWithRangeObj.integerCheckWithRange(2);
        if(choice==1){
            getUserDetails getUserDetailsObj = new getUserDetails();
            getUserDetailsObj.gettingUserDetails(userName);
            stringInput stringInputObj = new stringInput();
            integerInput integerInputObj = new integerInput();
            String oldData,newData="";
            System.out.println("1.Change name\n2.Change age\n3.Change your goal weight\n4.Change you weight\n5.Change your height\6.Change activity type");
            int option = integerInputWithRangeObj.integerCheckWithRange(6);
            if (option==1){
                System.out.println("Enter the new name:");
                oldData=getUserDetailsObj.name;
                newData = stringInputObj.getStringInput();
            }
            else if(option==2){
                System.out.println("Enter your age");
                oldData=String.valueOf(getUserDetailsObj.userAge);
                newData = String.valueOf(integerInputObj.integerCheck());
            }
            else if(option==3){
                System.out.println("Enter your new goal weight:");
                oldData=String.valueOf(getUserDetailsObj.goalWeight);
                newData=String.valueOf(integerInputObj.integerCheck());
            }
            else if(option==4){
                System.out.println("Enter your current weight:");
                oldData=String.valueOf(getUserDetailsObj.currentWeight);
                newData=String.valueOf(integerInputObj.integerCheck());
            }
            else if(option==5){
                System.out.println("Enter your current height");
                oldData=String.valueOf(getUserDetailsObj.currentHeight);
                newData=String.valueOf(integerInputObj.integerCheck());
            }
            else{
                System.out.println("What's your daily activity level?");
                oldData=getUserDetailsObj.strActivityType;
                System.out.println("""
                1.Sedentary
                2.Low active
                3.Active
                4.Very active""");
                int activityType= integerInputWithRangeObj.integerCheckWithRange(4);
                switch (activityType) {
                    case 1 -> newData = "Sedentary";
                    case 2 -> newData = "LowActive";
                    case 3 -> newData = "Active";
                    case 4 -> newData = "VeryActive";
                }
            }
            editUserDetails editUserDetailsObj = new editUserDetails();
            editUserDetailsObj.edit(userName,oldData,newData);
            getUserDetailsObj.gettingUserDetails(userName);
            targetCalorieCalculator targetCalorieCalculatorObj = new targetCalorieCalculator();
            double targetCalories = targetCalorieCalculatorObj.calorieCalculator(getUserDetailsObj.currentWeight,getUserDetailsObj.currentHeight,getUserDetailsObj.userAge,getUserDetailsObj.gender,getUserDetailsObj.activityType, getUserDetailsObj.goal, getUserDetailsObj.goalWeight);
            editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetCalories),String.valueOf(targetCalories));
            editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetDays),String.valueOf(targetCalorieCalculatorObj.targetDays));
        }
        else {
            logStatus logStatusObj = new logStatus();
            logStatusObj.logOut();
        }
    }
}
