/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;
//import necessary libraries
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution41 {
        //define the main function with exception handling
        public static void main(String[] args) throws IOException
        {

            // Call the Name Sorter function/method.

            namesorter();
        }

        static void namesorter() throws IOException
        {
            //initialize a counter for the names
            int numofnames =0;
            try
            {
                //Open an output file for writing.
                FileWriter f = new FileWriter("exercise41_output1.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter pw = new PrintWriter(b);



                //Read the input file.
                File inputFile = new File("exercise41_input.txt");
                Scanner inputReader = new Scanner(inputFile);

                // 2 Maps for Firstname and lastname

                Map<Integer, String> firstnamemap = new HashMap<>();
                Map<Integer, String> lastnamemap = new HashMap<>();
                int i = 0;
                //loop appends the data to the maps
                while (inputReader.hasNextLine())
                {
                    String data = inputReader.nextLine();
                    numofnames++;
                    i++;


                    //Split the names into 2 Maps.
                    String[] namedata = data.split(",", 2);
                    firstnamemap.put(i,namedata[1]);
                    lastnamemap.put(i,namedata[0]);

                }

                //a key is defined for separation between the first and last name
                String tempkey = "";
                int key;

                //Now Sort the lastname Map and retrieve the values for the corresponding firstnames.
                Map<Integer, String> sortedlastname = lastnamemap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

                //define a string for the names and split it to follow formatting
                String[] sortedstring = sortedlastname.toString().split(",");

                pw.println("Total of "+ numofnames+" names");
                pw.println("-----------------");
                //print out the required header formatted
                System.out.println("Total of "+ numofnames+" names");
                System.out.println("-----------------");
                //loop through the maps to provide the values for the printing
                for (String s : sortedstring) {
                    String[] tempsortedstring = s.split("=");
                    for (int j = 0; j < tempsortedstring.length; j++) {
                        tempkey = tempsortedstring[j];

                        if (j == 0) {
                            tempkey = tempkey.substring(1, tempkey.length());
                            try {
                                key = Integer.parseInt(tempkey);
                                if (key > 0) {
                                    String lastnamevalue = lastnamemap.get(Integer.parseInt(tempkey));
                                    String firstnamevalue = firstnamemap.get(Integer.parseInt(tempkey));
                                    String fullname = lastnamevalue + "," + firstnamevalue;
                                    System.out.printf("%-20s%n", fullname);
                                    String stringformat = "%1$s\n";
                                    pw.format(stringformat, fullname);
                                }
                            } catch (NumberFormatException e) {
                                //Do Nothing
                            }
                        } else {
                            //defined twice to ensure data is properly represented, if not correct the first time
                            try {
                                key = Integer.parseInt(tempkey);
                                if (key > 0) {
                                    String lastnamevalue = lastnamemap.get(Integer.parseInt(tempkey));
                                    String firstnamevalue = firstnamemap.get(Integer.parseInt(tempkey));
                                    String fullname = lastnamevalue + "," + firstnamevalue;
                                    System.out.printf("%-20s%n", fullname);
                                    String stringformat = "%1$s\n";
                                    pw.format(stringformat, fullname);
                                }
                            } catch (NumberFormatException e) {
                                //Do Nothing
                            }
                        }
                    }
                }

                inputReader.close();
                pw.flush();
            }
            //error handling for  I/O issues
            catch (FileNotFoundException e)
            {
                System.out.println("Error Opening File.");
                e.printStackTrace();
            }

        }


}
