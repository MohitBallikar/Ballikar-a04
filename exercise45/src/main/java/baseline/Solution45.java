/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution45 {
    public static void main(String[] args) throws IOException {
        //Word Finder function called
        wordfinder();
    }
    //reads and writes the file values, will separate into two parts
    static void wordfinder() throws IOException {
        //data, readers, and filewriters are intialized and defined
        String data;
        BufferedReader readinputfile = null;
        FileWriter fw = new FileWriter("data/exercise45_output.txt", true);
        try {
            //Read the input file in a buffer.
            readinputfile = new BufferedReader(new FileReader("data/exercise45_input.txt"));

            while ((data = readinputfile.readLine()) != null) {
                System.out.println(data);
                data = data.replace("utilize", "use");
                fw.write(data);
            }
            fw.close();
        } catch (IOException e) {
            //Do nothing.
        }
    }
}//exceptions are used to ensure that any errors can be avoided or worked around