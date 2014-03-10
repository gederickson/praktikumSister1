/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.*;
import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
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
            //String message, message2;
                        
            /*
             * create socket server, accept client, preparing input stream
             * receive message, and print to screen
             */
            serverSocket = new ServerSocket(5111);
            while(true) {
                clientSocket = serverSocket.accept();            
                Connection c = new Connection(clientSocket); 
                
            }
            

            /*
             * preparing output stream, send message back to client
             */
            

            /*
             * close input stream, output stream
             * close client socket and server socket
             */
            /*inputStream.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();*/
        }
        catch(IOException e) {
            System.out.println("Listen: " + e.getMessage());
        }        
    }
}

class Connection extends Thread {
    DataInputStream inputStream;
    DataOutputStream outputStream;
    Socket clientSocket;
    
    public Connection(Socket client) {
        try {
            clientSocket = client;
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());            
            this.start();
        }
        catch(IOException ex) {
            System.out.println("IO: " + ex.getMessage());
        }        
    }
    
    @Override
    public void run() {
        try {
            String message2, message;
            inputStream = new DataInputStream(clientSocket.getInputStream());
            message = inputStream.readUTF();
            
                     
            System.out.println("From client: " + message);
            Reader file = new Reader();
            if("all".equals(message) || "All".equals(message)){
                message2 = file.readAll();
            }else{
                message2 = file.readDay(message);
            }
            
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF(message2);                           
            
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
    

