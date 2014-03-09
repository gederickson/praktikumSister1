/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rickson
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            /*
             * variable initialization
             */
            ServerSocket serverSocket;            
            Socket clientSocket;
            DataInputStream inputStream;
            DataOutputStream outputStream;
            String message;
                        
            /*
             * create socket server, accept client, preparing input stream
             * receive message, and print to screen
             */
            serverSocket = new ServerSocket(5111);
            clientSocket = serverSocket.accept();
            inputStream = new DataInputStream(clientSocket.getInputStream());
            message = inputStream.readUTF();
            System.out.println("From client: " + message);

            /*
             * preparing output stream, send message back to client
             */
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF(message);

            /*
             * close input stream, output stream
             * close client socket and server socket
             */
            inputStream.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch(IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }        
        
        Reader file = new Reader();
        file.readDay("Kamis");
 
	}
    }
    

