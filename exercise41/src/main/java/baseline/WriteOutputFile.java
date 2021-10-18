/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.FileWriter;
import java.io.IOException;

public class WriteOutputFile
{
    //function writes the data to the output file
    //provides feedback if errors
    static void writedata() throws IOException
    {
        try {
            FileWriter fileoutput = new FileWriter("data/exercise41_output.txt");
            fileoutput.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred opening file to Write.");
            e.printStackTrace();
        }


    }
}