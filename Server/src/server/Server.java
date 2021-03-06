/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.net.*;
import java.io.*;
import java.io.IOException;


/**
 *
 * @author Rickson
 * @editor desta
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
            /*
             * create socket server, accept client, preparing input stream
             * receive message, and print to screen
             */
            serverSocket = new ServerSocket(5111);
            while(true) {
                clientSocket = serverSocket.accept();            
                Connection c = new Connection(clientSocket);      
            }  
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
             /*
             * preparing output stream, send message back to client
             */
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
    

