/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nekojarashi;

import static java.lang.System.exit;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.rpc.Client;
import org.msgpack.type.Value;

/**
 *
 * @author y-okubo
 */
public class MessagePackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = null;

        try {
            client = new Client("127.0.0.1", 19850);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessagePackClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        Value result = client.callApply("hello", new Object[]{});

        System.out.println(result.toString());

        result = client.callApply("hello2", new Object[]{});

        System.out.println(result.asArrayValue().toString());

        result = client.callApply("hello2", new Object[]{});
        List<Value> list = result.asArrayValue();
        ArrayList<String> art = new ArrayList(list);
        System.out.println(list.get(0).toString());

        exit(0);        
    }

}
