/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Rickson
 */
public class Reader {

 
public void readAll() 
    {
        Reader file = new Reader();
	BufferedReader br = null;
 	try 
            {
		String sCurrentLine;
		br = new BufferedReader(new FileReader("file.txt"));
		while ((sCurrentLine = br.readLine()) != null) 
                    {
                        System.out.println(sCurrentLine);
                    }
            } 
                catch (IOException e) 
                {
			e.printStackTrace();
		} 
            finally 
            {
		try 
                {
			if (br != null)br.close();
		} 
                catch (IOException ex) 
                {
			ex.printStackTrace();
		}
            }
    }
}