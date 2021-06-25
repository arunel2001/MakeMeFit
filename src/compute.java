package com.company;

public class compute {
    public int runApp(String userName,int newUserFlag){
        getUserDetails getUserDetailsObj = new getUserDetails();
        dashBoard dashBoardObj = new dashBoard();
        //To retrieve the current user all details
        getUserDetailsObj.gettingUserDetails(userName);
        close closeObj = new close();
        calorieCheck calorieCheckObj = new calorieCheck();
        int closeFlag = 0;
        while (closeFlag == 0) {
            //Displaying dashboard
            int logOutFlag = dashBoardObj.calorieTracker(userName);
            if(logOutFlag==1){
                return 0;
            }
            if (dashBoard.todayTotalCalories > getUserDetailsObj.targetCalories) {
                calorieCheckObj.loseWeight(dashBoard.todayTotalCalories, getUserDetailsObj.targetCalories);
            }
            closeFlag = closeObj.gettingCloseFlag();
        }
        //Checking if user had lacking calories and recommending him certain foods
        calorieCheckObj.gainWeight(dashBoard.todayTotalCalories, getUserDetailsObj.targetCalories);
        //Storing user's today calorie in take in our database
        int day = dashBoardObj.writingCalorieData(userName,newUserFlag);
        dashBoardObj.writingDayWise(userName, day);
        report reportObj = new report();
        //Initiating weekly check report of the user
        if(day%7==0) {
            reportObj.weeklyReport(userName, getUserDetailsObj.targetCalories, day);
        }
        //Checking if user achieved his goal
        goalTracker goalTrackerObj = new goalTracker();
        int flag = goalTrackerObj.checkTargetDays(userName, day, getUserDetailsObj.targetDays, getUserDetailsObj.targetCalories);
        targetCalorieCalculator targetCalorieCalculatorObj = new targetCalorieCalculator();
        editUserDetails editUserDetailsObj = new editUserDetails();
        if (flag == 1) {
            // If user had achieved his goal recreating new plan to maintain his current weight
            System.out.println("Yaaay you have achieved your goal");
            double targetCalorie = targetCalorieCalculatorObj.calorieCalculator(getUserDetailsObj.currentWeight,getUserDetailsObj.currentHeight,getUserDetailsObj.userAge,getUserDetailsObj.gender,getUserDetailsObj.activityType,2,0);
            editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.goal),"2");
            editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetCalories),String.valueOf(targetCalorie));
            editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetDays),String.valueOf(targetCalorieCalculatorObj.targetDays));
        } else if (flag == 2) {
            // If user couldn't achieve his goal recreating him a new plan with his recent weight
            System.out.println("Looks like you missed some diets plans");
            System.out.println("We will recreate the plan for you, enter your current weight");
            integerInput integerInputObj = new integerInput();
            int currentWeightForOldGoal = integerInputObj.integerCheck();
            //If user goal is to gain weight
            if(getUserDetailsObj.goal==1) {
                int goalWeight = getUserDetailsObj.goalWeight - (currentWeightForOldGoal - getUserDetailsObj.currentWeight);
                //Calculating new target calories
                double targetCalorie = targetCalorieCalculatorObj.calorieCalculator(currentWeightForOldGoal, getUserDetailsObj.currentHeight, getUserDetailsObj.userAge, getUserDetailsObj.gender, getUserDetailsObj.activityType, getUserDetailsObj.goal,goalWeight);
                //Updating user's details
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetCalories),String.valueOf(targetCalorie));
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetDays),String.valueOf(targetCalorieCalculatorObj.targetDays));
            }
            //If user goal is to maintain weight
            else if (getUserDetailsObj.goal==2) {
                //Calculating new target calories
                double targetCalorie = targetCalorieCalculatorObj.calorieCalculator(currentWeightForOldGoal, getUserDetailsObj.currentHeight, getUserDetailsObj.userAge, getUserDetailsObj.gender, getUserDetailsObj.activityType, getUserDetailsObj.goal, 0);
                //Updating user's details
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetCalories),String.valueOf(targetCalorie));
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetDays),String.valueOf(targetCalorieCalculatorObj.targetDays));
            }
            //if user goal is loss weight
            else {
                int goalWeight=getUserDetailsObj.goalWeight-(getUserDetailsObj.currentWeight-currentWeightForOldGoal);
                double targetCalorie = targetCalorieCalculatorObj.calorieCalculator(currentWeightForOldGoal, getUserDetailsObj.currentHeight, getUserDetailsObj.userAge, getUserDetailsObj.gender, getUserDetailsObj.activityType, getUserDetailsObj.goal, goalWeight);
                //Updating user's details
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetCalories),String.valueOf(targetCalorie));
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.goalWeight),String.valueOf(goalWeight));
                editUserDetailsObj.edit(userName,String.valueOf(getUserDetailsObj.targetDays),String.valueOf(targetCalorieCalculatorObj.targetDays));
            }
        }
        return 1;
    }
}

