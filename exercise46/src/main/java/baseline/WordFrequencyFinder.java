/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyFinder {
    static void find() throws IOException
    {
        // create an HashMap
        HashMap<String, Integer> allwordcounts = new HashMap<>();
        String data;
        BufferedReader readinputfile = null;
        int count = 0;
        try
        {
            //Read the input file in a buffer.
            readinputfile = new BufferedReader(new FileReader("exercise46_input.txt"));

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

            //Sort the Map values descending

            Map<String,Integer> sortedValueMap = sortByValues(allwordcounts);

            //LinkedHashMap preserve the ordering of elements in which they are inserted
            LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
            //Use Comparator.reverseOrder() for reverse ordering
            sortedValueMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

            //	System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
            String saveoutputstring = reverseSortedMap.toString();

            ///		System.out.println("*****saveoutputstring   : " + saveoutputstring);
            int startindex  = saveoutputstring.indexOf("{");
            int endindex  = saveoutputstring.indexOf("}");

            String newstring = saveoutputstring.substring(startindex+1, endindex);
            String[] arrayofwords = newstring.split(",");

            for (int m = 0; m< arrayofwords.length ; m++)
            {
                //	System.out.printf("%-10s%n" , arrayofwords[m]);
                String[] arrayofnames = arrayofwords[m].split("=");
                System.out.printf("%-15s%-15s%n", arrayofnames[0].trim()+":" , addStars(Integer.parseInt(arrayofnames[1])));

            }

        }
        catch (IOException e)
        {
            //Do nothing.
        }

    }

    //Add this standard function to Sort the values.


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
    //compares the map to dynamically sort
    //returns value to be called by other function/methods
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k1).compareTo(map.get(k2));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<K, V> sortedByValues =       new TreeMap<K, V>(valueComparator);

        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
