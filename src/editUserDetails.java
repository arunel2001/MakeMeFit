package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class editUserDetails {
    /**
     * Editing the user's details using String buffer and replaceall
     * @param userName username of the current user
     * @param oldLine The old data that has to replaced
     * @param newLine The new data that has to be added
     */
    public void edit(String userName,String oldLine,String newLine){
        //Instantiating the Scanner class to read the file
        String filePath = "D://Fit//userData//"+userName+".txt";
        System.out.println(filePath);
        try {
            Scanner sc = new Scanner(new File(filePath));
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            //closing the Scanner object
            sc.close();
            //Replacing the old line with new line
            fileContents = fileContents.replaceAll(oldLine, newLine);
            //instantiating the FileWriter class

            FileWriter writer = new FileWriter(filePath);
            writer.append(fileContents);
            writer.flush();
        }
        catch (Exception e){
            System.out.println("error in rewriting"+e);
        }
    }
}

