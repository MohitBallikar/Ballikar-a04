/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSearch {
    static void psearch() throws IOException
    {
        //initialize the strings for the different attributes/parameters of the json file
        //also ensure that the file is initialized as well as froundproduct is defined (I had issues with this if it wasnt defined)
        String productname = "";
        String datastring ="";
        String fileline = null;
        boolean bfoundproduct = false;

        try
        {
            //read file contents within the specific directory.
            String filecontent =  readUsingBufferedReader("data/exercise44_input.json");

            //established the beginning and end of the desired information within the json file
            int startindex = filecontent.indexOf("[");
            int endindex = filecontent.indexOf("]");

            //establishes a new string for the necessary file contents
            String newstr = filecontent.substring(startindex,endindex+1);

            //initializes the gson parser for json files
            Gson gson = new Gson();
            //an array is created for each product
            Products[] productArray = gson.fromJson(newstr, Products[].class);

            //reader is initialized to read
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                //user input is prompted and read
                System.out.printf("What is the product name? ");
                productname = input.readLine();


                //Search the product by looping through the array

                for(Products products : productArray)
                {

                    if ( products.getName().equals(productname))
                    {
                        //defines what would happen if the product is found successfully
                        System.out.println("Name: " + products.getName());
                        System.out.println("Price: " + products.getPrice());
                        System.out.println("Quantity: " + products.getQuantity());
                        bfoundproduct = true;
                        break;
                    }

                }
                //breaks out of while
                if (bfoundproduct)
                {
                    break;
                }
                else
                {   //ensures only available values are considered
                    System.out.println("Sorry, that product was not found in our inventory.");

                }
            }
        }
        catch (IOException e)
        {
            //Do nothing.
        }
    }

    //method defined to read and parse
    public static String readUsingBufferedReader(String fileName) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            //goes through the csv file and adds the data
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last ls
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            //syntax is used to ensure that the legitimate data read and all the data is read
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //provides the value
        return stringBuilder.toString();
    }
}
