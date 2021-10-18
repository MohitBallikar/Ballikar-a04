/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameSorter
{
    static String process() throws IOException
    {
        int numofnames =0;
        String returnval = "";
        try
        {
            //Open the output file for writing.
            FileWriter f = new FileWriter("data/exercise41_output.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);


            int m=0;
            //a map is used for data storage and sorting
            //Read the input file.
            File inputFile = new File("data/exercise41_input.txt");
            Scanner inputReader = new Scanner(inputFile);
            Map<String, Integer> namemap = new HashMap<>();
            //called later on for formatting
            while (inputReader.hasNextLine())
            {
                String data = inputReader.nextLine();
                numofnames++;
                m++;

                //System.out.println(" 1 " + namedata[1]);
                namemap.put(data,m);
            }

            // TreeMap to store values of HashMap
            TreeMap<String, Integer> sorted = new TreeMap<>();
            // Copy all data from hashMap into TreeMap
            sorted.putAll(namemap);
            String stringformat = "%1$s\n";
            pw.println("Total of "+ m+" names");
            pw.println("------------------------------");

            // Display the TreeMap which is naturally sorted
            for (Map.Entry<String, Integer> entry : sorted.entrySet())
            {
                //System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
                pw.format(stringformat, entry.getKey());
            }




            inputReader.close();
            pw.flush();
            //returnval = sorted.toString();


        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error Opening File.");
            e.printStackTrace();
        }
        return returnval;
    }

}