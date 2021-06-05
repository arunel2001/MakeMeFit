package com.company;



public class targetCalorieCalculator {
    /**
     * basalMetabolicRate - The value calculated using formula
     * targetCalories - The amount of calorie user need to eat daily
     * targetDays - In how many days user can complete his/her goal
     */
    double basalMetabolicRate,targetCalories;
    int targetDays;

    /**
     *Calculating the user's daily energy expenditure and estimating how much calories he need to eat daily in order reach his goal
     * @param weight User's Weight(Must be positive)
     * @param height User's Height(Must be positive)
     * @param age User's age(Must be positive)
     * @param gender User's gender(1-Male,2-Female)
     * @param activityType User's daily activity type(1-Sedentary,2-LowActive,3-Active,4-VeryActive)
     * @param goal User's Goal(1-Gain weight,2-maintain weight,3-Loss weight)
     * @param goalWeight User's Goal weight(Must be positive)
     * @return targetCalories( double value ,Amount of calories user need to eat)
     */
    public double calorieCalculator(int weight,int height,int age,int gender,int activityType,int goal,int goalWeight){
        // Using Mifflin-St Jeor Equation for calculating BMR
        basalMetabolicRate= (gender==1)?((10*weight)+(6.25*height)-(5*age)+5):((10*weight)+(6.25*height)-(5*age)-161);
        switch (activityType) {
            case 1 -> targetCalories = (basalMetabolicRate * 1.2);
            case 2 -> targetCalories = (basalMetabolicRate * 1.375);
            case 3 -> targetCalories = (basalMetabolicRate * 1.725);
            case 4 -> targetCalories = (basalMetabolicRate * 1.9);
        }
        if (goal==1){
            targetCalories = targetCalories+500.0;
            targetDays = (7)*((int) (goalWeight/0.5));
        }
        else if(goal==3){
            targetCalories = targetCalories-500.0;
            targetDays = (7)*((int) (goalWeight/0.5));
        }
        return targetCalories;
    }
}
