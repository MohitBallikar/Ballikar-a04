/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;
//import necessary libraries

import java.io.IOException;
//defined a temp test function that I ran parallel with my unit tests
public class Solution41 {
    public static String testreturn = "";
    static String testfunction()
    {

        return testreturn;
    }
//calls necessary functions from classes
    public static void main(String[] args) throws IOException
    {
        String sortedreturnString = "";
        //Name Sorter.


        NameSorter namesorter = new NameSorter();
        sortedreturnString  = namesorter.process();

       /* testreturn = sortedreturnString;
        System.out.println("SORTED = "+sortedreturnString);
        */

    }
}
