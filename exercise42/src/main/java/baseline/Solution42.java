/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.*;
import java.util.Formatter;

public class Solution42 {
    public static void main(String[] args) throws IOException {

        //Calls the Parse Data File function/method.
        parseDataFile();
    }

    static void parseDataFile() throws IOException {
        //ensures that the file is not overwritten
        File newfile = new File("data/exercise42_output.txt");
        newfile.delete();

        //initializes a string as well as a formatter
        String data = "";
        Formatter fmt = new Formatter();

        try {
            //Define Write Output File.
            FileWriter f = new FileWriter("data/exercise42_output.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);
            //define the header for the file/output
            pw.println("Last				First				Salary");
            pw.println("----------------------------------------------");

            BufferedReader inputreader;
            inputreader = new BufferedReader(new FileReader("data/exercise42_input.txt"));
            data = inputreader.readLine();

            while (data != null) {
                String[] tempArray = data.split(",");
                fmt.format("%-20s%-20s%s\n", tempArray[0], tempArray[1], tempArray[2]);
                //Read the next line
                data = inputreader.readLine();
            }

            //Write to the output file.
            pw.println(fmt);

            //Close the file.
            inputreader.close();
            pw.flush();
            //reads out the contents of the output file (may be compartmentalized into its own method)
            BufferedReader in = new BufferedReader(new FileReader("data/exercise42_output.txt"));
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
            }
            //closes the file to ensure that any excess writing is not done and to prepare the "newfile"
            in.close();

        } catch (IOException e) {
            System.out.println("File Error.\n");
        }
    }
}