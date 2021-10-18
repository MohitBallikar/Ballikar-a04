/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;

import java.io.*;

public class WebSiteGenerator {
    static void process() {
        //initialize strings and responses for comparison
        String sitename = "";
        String author = "";
        String yesfolder ="";
        String yescss ="";

        try
        {
            //initialize readers for the user input
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.printf("Site name: ");
            sitename = input.readLine();

            System.out.printf("Author: ");
            author = input.readLine();

            System.out.printf("Do you want a folder for JavaScript? ");
            yesfolder = input.readLine();

            System.out.printf("Do you want a folder for CSS? ");
            yescss = input.readLine();

            //Create Files/Folders.

            //Dummy html page.
            String htmlpage = "<html><head><meta name='author' content='"+author+"'><title>"+sitename+"</title></head><body><h1>This is a test site</h1></body></html>";
            //path names were defined to include the data directory through intellij
            File file = new File("data/website");
            boolean dirCreated = file.mkdir();
            if (dirCreated)
            {
                //System.out.println("Created "+"./website");
                File subfolder = new File("data/website/"+sitename);
                boolean subfolderCreated = subfolder.mkdir();
                if (subfolderCreated)
                {
                    //Add a file
                    System.out.println("Created "+"./website/"+sitename);
                    String filename = "data/website/"+sitename+"/index.html";
                    File filecreated = new File(filename);
                    if (filecreated.exists())
                    {
                        System.out.println("File already exists\n");
                    }
                    else
                    {
                        boolean newfilecreated = filecreated.createNewFile();
                        if (newfilecreated)
                        {
                            //Write the details to the file.
                            FileOutputStream fos=new FileOutputStream(filename, true);
                            byte[] b= htmlpage.getBytes();
                            fos.write(b);
                            fos.close();
                            System.out.println("Created ./"+filename);
                        }
                        else
                        {
                            System.out.printf("Failed to create new file: %s%n", filecreated);
                        }
                    }


                    //Add a Js folder.
                    if ( yesfolder.length() > 0)
                    {
                        File jsfolder = new File("data/website/"+sitename+"/js/");
                        boolean jsfolderCreated = jsfolder.mkdir();
                        if (jsfolderCreated)
                        {
                            System.out.println("Created "+"./website/"+sitename+"/js/");
                        }
                    }

                    //Add a css folder.
                    if ( yescss.length() > 0)
                    {
                        File cssfolder = new File("data/website/"+sitename+"/css/");
                        boolean cssfolderCreated = cssfolder.mkdir();
                        if (cssfolderCreated)
                        {
                            System.out.println("Created "+"./website/"+sitename+"/css/");
                        }

                    }

                }
            }
        }
        catch (IOException e)
        {
            //Do nothing.
        }

    }
}
