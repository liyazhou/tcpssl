package com.dhgate.sslrmidemo; /**
 * Created by liyazhou on 2017/6/28.
 */
import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        try {

            setSettings();

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2020, new SslRMIClientSocketFactory());
//            Registry registry = LocateRegistry.getRegistry("127.0.0.1",2020);

            Hello hello = (Hello) registry.lookup("com.dhgate.rmidemo.Hello");

            String message = hello.sayHello();

            System.out.println(message);

        } catch (Exception e) {
            System.err.println("com.dhgate.rmidemo.Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void setSettings() {

        String pass = "liyazhou";
        System.setProperty("javax.net.ssl.debug", "all");

        System.setProperty("javax.net.ssl.keyStore", "/Users/liyazhou/workspace/tcpssl/certificate/client.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
//        System.setProperty("javax.net.ssl.trustStore", "/Users/liyazhou/workspace/tcpssl/certificate/clientTrust.jks");
//        System.setProperty("javax.net.ssl.trustStorePassword", pass);

//        System.setProperty("javax.net.ssl.keyStore", "/Users/liyazhou/workspace/tcpssl/certificate/server.jks");
//        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "/Users/liyazhou/workspace/tcpssl/certificate/serverTrust.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);
    }

}