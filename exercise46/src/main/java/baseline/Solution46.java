/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution46 {
    public static void main(String[] args)  throws IOException
    {
        //Word Frequency Finder
        wordfrequencyfinder();
    }

    static void wordfrequencyfinder() throws IOException
    {
        // create an HashMap
        HashMap<String, Integer> allwordcounts = new HashMap<>();
        String data;
        BufferedReader readinputfile = null;
        int count = 0;
        try
        {
            //Read the input file in a buffer.
            readinputfile = new BufferedReader(new FileReader("data/exercise46_input.txt"));

            //Gets each line till end of file is reached
            while((data = readinputfile.readLine()) != null)
            {
                //Splits each line into words
                String allwords[] = data.split(" ");
                for (int i = 0; i < allwords.length ; i ++)
                {
                    count = 1;
                    if (allwordcounts.get(allwords[i]) != null)
                    {
                        //Get the current value for the key and then update the indicator.
                        int wordcount =allwordcounts.get(allwords[i]);
                        allwordcounts.replace(allwords[i], wordcount+1);
                    }
                    else
                    {
                        allwordcounts.put(allwords[i],count);
                    }
                }
            }

            // Iterating HashMap through for loop for testing
/*        for (Map.Entry<String, Integer> set : allwordcounts.entrySet())
				{
          // Printing all elements of a Map
          System.out.println(set.getKey() + " = " + set.getValue());
        }
*/
            //Sort the Map values descending
            sortbykey(allwordcounts);

        }
        catch (IOException e)
        {
            //Do nothing.
        }

    }

    //Add this standard function to Sort the values.

    public static void sortbykey(HashMap<String, Integer> allwordcounts )
    {
        // TreeMap to store values of HashMap
        TreeMap<String, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(allwordcounts);

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<String, Integer> entry : sorted.entrySet())
        {
            //  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            //Get all Keys and lined them as Stars for the output.

            //	System.out.println(entry.getKey()+":		"+ addStars(entry.getValue()));
            System.out.printf("%-10s%-10s%n" , entry.getKey()+":" , addStars(entry.getValue()));
        }
    }

    //Add stars as per the number and return back the String.
    public static String addStars(int numberofstars)
    {
        String stringValue = "";
        for (int i = 0 ; i < numberofstars ; i++)
        {
            stringValue = stringValue+"*";
        }
        return stringValue;
    }
}

