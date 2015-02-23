/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nekojarashi;

import static java.lang.System.exit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.rpc.Client;
import org.msgpack.rpc.Future;
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

//        Value result = client.callApply("hello", new Object[]{});
//
//        System.out.println(result.toString());
//
//        for (int i = 0; i < 1000; i++) {
//            result = client.callApply("hello", new Object[]{});
//            System.out.println(result.toString());
//        }
//
//        result = client.callApply("hello2", new Object[]{});
//
//        System.out.println(result.asArrayValue().toString());
//
//        result = client.callApply("hello2", new Object[]{});
//        List<Value> list = result.asArrayValue();
//        ArrayList<String> art = new ArrayList(list);
//        System.out.println(list.get(0).toString());
//        Future<Value> result;
//        result = client.callAsyncApply("async_hello", new Object[]{});
//        
//        try {
//            System.out.println(result.get().toString());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MessagePackClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        System.out.println("AAAAA");
        Value result;
        String method = "";

        result = client.callApply("method_with_argument", new Object[]{new String("ABC")});
        result = client.callApply("method_with_argument", new Object[]{new Integer(Integer.MAX_VALUE)});
        result = client.callApply("method_with_argument", new Object[]{new Long(Long.MAX_VALUE)});
        result = client.callApply("method_with_argument", new Object[]{new Float(Float.MAX_VALUE)});
        result = client.callApply("method_with_argument", new Object[]{new Double(Double.MAX_VALUE)});
        result = client.callApply("method_with_argument", new Object[]{new BigDecimal(Integer.MAX_VALUE)});
        result = client.callApply("method_with_argument", new Object[]{new Boolean(true)});

        ArrayList array = new ArrayList();
        array.add("A");
        array.add("B");
        array.add(100);
        result = client.callApply("method_with_argument", new Object[]{array});

        HashMap hash = new HashMap();
        hash.put("A", "AAA");
        hash.put("B", "BBB");
        hash.put("C", 10000);
        hash.put(200, 20000);
        result = client.callApply("method_with_argument", new Object[]{hash});

        method = "method_return_fixnum";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        method = "method_return_bignum";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        method = "method_return_string";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        method = "method_return_boolean";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        method = "method_return_array";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        method = "method_return_hash";
        result = client.callApply(method, new Object[]{});
        System.out.println(method + "(" + result.getType().toString() + "): " + result.toString());

        exit(0);
    }

}
