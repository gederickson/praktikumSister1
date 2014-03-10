/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author MD Dia Agustya
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket;
            DataInputStream inputStream;
            DataOutputStream outputStream;
            String message;
        
            /*
                Buat socket, output stream, kirim pesan
            */
            clientSocket = new Socket("localhost", 5111);
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            //outputStream.writeUTF("Message GUEST");
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            String name="";
            System.out.print("Input hari: ");
            name = dataIn.readLine();
            outputStream.writeUTF(name);
            
            /*
             * preparing data input stream, receive message from server, print
             */
            inputStream = new DataInputStream(clientSocket.getInputStream());
            message = inputStream.readUTF();
            System.out.println("From server: " + message);
            
        }
        catch(IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
        
        
        
    }
    
}
