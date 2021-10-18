/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Formatter;

public class ParseData
{
    static Formatter processDataFile() throws IOException
    {
        String data = "";
        Formatter fmt = new Formatter();

        try
        {
            //Define Write Output File.
            FileWriter f = new FileWriter("data/exercise42_output.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);
            //ensure proper formatting
            pw.println("Last				First				Salary");
            pw.println("----------------------------------------------");

            BufferedReader inputreader;
            inputreader = new BufferedReader(new FileReader("data/exercise42_input.txt"));
            data = inputreader.readLine();

            while (data != null)
            {
                String[] tempArray = data.split(",");
                fmt.format("%-20s%-20s%s\n", tempArray[0] , tempArray[1], tempArray[2]);
                //Read the next line
                data = inputreader.readLine();
            }

            //Write to the output file.
            pw.println(fmt);

            //Close the file.
            inputreader.close();
            pw.flush();

        }
        catch (IOException e)
        {
            System.out.println("File Error.\n");
        }
        return fmt;
    }
}
