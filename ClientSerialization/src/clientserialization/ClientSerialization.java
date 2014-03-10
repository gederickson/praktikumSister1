/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientserialization;

import messageserialization.Message;
import java.net.*;
import java.io.*;

/**
 *
 * @author MD Dia Agustya
 */
public class ClientSerialization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        try {
            /*
             * variable initialization
             */
            Socket clientSocket;
            ObjectInputStream inputStream;
            ObjectOutputStream outputStream;            
            Message message;
            
            /*
             * create socket, preparing object output stream, send object to server
             */
            clientSocket = new Socket("localhost", 5111);
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
            String name;
            System.out.print("Input hari: ");
            name = dataIn.readLine();
            outputStream.writeObject(new Message(name));
            outputStream.flush();
            
            /*
             * preparing object input stream, receive message from server, print
             */
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            try {
                message = (Message) inputStream.readObject();
                System.out.println("From server: " + message.getString());
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFound: " + ex.getMessage());
            }                                    
            
            /*
             * close data output stream, data input stream, and client socket
             */
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        }
        catch(IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
        
    }
    
}
