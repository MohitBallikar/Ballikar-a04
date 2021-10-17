/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution45 {
    public static void main(String[] args) throws IOException {
        //Calls Word Finder function/method
        wordfinder();
    }

    static void wordfinder() throws IOException {
        //strings and reader are initialized
        String data;
        BufferedReader readinputfile = null;
        String outputFileName = "";

        try {
            //Read the input file in a buffer reader.
            readinputfile = new BufferedReader(new FileReader("data/exercise45_input.txt"));

            // output file is defined through user input
            Scanner outputfile = new Scanner(System.in);
            System.out.print("Please enter output File Name: ");
            outputFileName = outputfile.nextLine().trim();


            //ensures that the correct directory is called
            FileWriter fw = new FileWriter("data/" +outputFileName, true);

            //does the string replacement of 'utilize'
            while ((data = readinputfile.readLine()) != null) {
                System.out.println(data);
                data = data.replace("utilize", "use");
                fw.write(data+"\n");
            }
            fw.close();
            outputfile.close();
            //closes the files and the respective writer
        } catch (IOException e) {
            //Do nothing.
        }

    }
}