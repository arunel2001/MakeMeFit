package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class day {
    public int getCurrentDay(String username){
        File dayFile = new File("D:\\Fit\\Data\\"+username+".txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(dayFile));
            String last = "", line;
            while ((line = input.readLine()) != null) {
                last = line;
            }
            return Integer.parseInt(last);
        }
        catch (Exception e){
            System.out.println("");
        }
        return 0;
    }
}
