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
            //Read the input file in a buffer.
            readinputfile = new BufferedReader(new FileReader("data/exercise45_input.txt"));

            // output file is defined through user input
            Scanner outputfile = new Scanner(System.in);
            System.out.print("Please enter output File Name: ");
            outputFileName = outputfile.nextLine().trim();

            //stringbuilder is used to ensue that the output is in the 'data' directory as per the instructions
            StringBuilder str = new StringBuilder("data/");
            str.append(outputFileName);


            FileWriter fw = new FileWriter(String.valueOf(str), true);

            //does the string replacement of 'utilize'
            while ((data = readinputfile.readLine()) != null) {
                System.out.println(data);
                data = data.replace("utilize", "use");
                fw.write(data);
            }
            fw.close();
            outputfile.close();
            //closes the files and the respective writer
        } catch (IOException e) {
            //Do nothing.
        }

    }
}