/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.*;
import java.util.Formatter;

public class Solution42 {
    public static void main(String[] args)  throws IOException
    {
        Formatter returnformat = new Formatter();
        //Parse Data File.
        ParseData pd = new ParseData();
        returnformat = pd.processDataFile();

    }



}