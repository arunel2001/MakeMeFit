package com.company;

import java.io.File;
import java.io.FileWriter;

public class logStatus {
    File logStatus = new File("D:\\Fit\\logStatus.txt");
    public void logIn(String userName){
        try {
            FileWriter writing = new FileWriter(logStatus);
            writing.write('1'+","+userName);
            writing.close();
        }
        catch (Exception e) {
            System.out.println("Error code 009:Accidentally logged out");
        }
    }
    public void logOut(){
        try {
            FileWriter writing = new FileWriter(logStatus);
            writing.write('0');
            writing.close();
        }
        catch (Exception e){
            System.out.println("Error code 010: Can't log out");
        }
    }
}
