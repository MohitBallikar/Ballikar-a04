/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.*;
import java.net.http.HttpResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;



public class Solution44 {

    public static void main(String[] args) throws IOException {
        //Product Search
        productsearch();
    }

    static void productsearch() throws IOException {
        //searches through the file and returns values/ could be separated into two functions

    }
}

/*
Create a program that takes a product name as input and
retrieves the current price and quantity for that product.
The product data is in a data file in the JSON format  and looks like this
(you will create this file as `exercise44_input.json`)

The file is in the JSON format.
Use a JSON parser to pull the values out of the file (e.g. https://github.com/google/gson )
If no record is found, prompt again.
 */
