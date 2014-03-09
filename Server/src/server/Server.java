/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author Rickson
 */

import java.io.*; 

public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        byte[] day = null;
        // TODO code application logic here
        
        // Method to read all weather for the week
        Reader file = new Reader;
        file.readAll();
        
        // Method to read weather by Day
        file.readbyDay();
        
        
    }
    
}
