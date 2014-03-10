/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rickson
 */
public class Reader 
{
    public static String initialRead()
    {
        //Z means: "The end of the input but for the final terminator, if any"
        String temp = null;    
        try 
        {
            String output = new Scanner(new File("file.txt")).useDelimiter("\\Z").next();
            temp="" + output;
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return temp;
        
    }
	    
	    
    public String readAll()
    {
        String temp = null;
        temp = initialRead();
        return temp;
    }

    public String readDay( String day) 
    {
        String temp,message = null;
        int i;
        temp = initialRead();
        String perLine [] = temp.split("\n");
        for(i=0;i<perLine.length;i++)
        {
            if(perLine[i].indexOf(day) != -1)
            {
                message = perLine[i];
            }
        }
        return message;
    }


}

  
