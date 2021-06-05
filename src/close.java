package com.company;

public class close {
    integerInputWithRange integerInputWithRangeObj = new integerInputWithRange();

    /**
     * Asking if a user want to close the app for today
     * @return 0 if  user doesn't want to close the app adn continue else 1
     */
    public int gettingCloseFlag(){
        int closeFlag;
        System.out.println("""
                        Close the app?
                        1.EXIT
                        2.Continue""");
        closeFlag = integerInputWithRangeObj.integerCheckWithRange(2);
        if(closeFlag==1){
            return closeFlag;
        }
        return 0;
    }
}
