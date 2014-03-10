/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package messageserialization;

import java.io.Serializable;

/**
 *
 * @author MD Dia Agustya
 */
public class Message implements Serializable {
    private final String message;
    
    public Message(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
