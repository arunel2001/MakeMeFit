package com.company;

import java.io.File;
import java.util.Scanner;

public class logInCheck {
    /**
     * loggedFlag-This this data that would be read from the log Status file
     * currentUserName-The username of the currently logged in user
     */
    String loggedFlag="0",currentUserName="";

    /**
     * Read the log status file and check if any user is logged in or not
     * @return The loggedFlag("0" if no user is logged in else "1")
     */
    public String logCheck() {
        File logStatus = new File("D:\\Fit\\logStatus.txt");
        try{
            Scanner file = new Scanner(logStatus);
            if (logStatus.length() != 0) {
                file.useDelimiter("[,\n]");
                loggedFlag = file.next();
                //logged == 1 if user logged in,else 0
                if (loggedFlag.equals("1")) {
                    currentUserName = file.next();
                }
            }
            file.close();
        }
        catch (Exception E){
            System.out.println("Logged out accidentally due to some unseen errors please login again");
        }
        return loggedFlag;
    }
}
