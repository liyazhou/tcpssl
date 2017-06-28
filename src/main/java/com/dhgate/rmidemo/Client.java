package com.dhgate.rmidemo; /**
 * Created by liyazhou on 2017/6/28.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        try {

//            setSettings();

//            Registry registry = LocateRegistry.getRegistry("DAVE-PC", 2020, new SslRMIClientSocketFactory());
            Registry registry = LocateRegistry.getRegistry(2020);

            Hello hello = (Hello) registry.lookup("com.dhgate.rmidemo.Hello");

            String message = hello.sayHello();

            System.out.println(message);

        } catch (Exception e) {
            System.err.println("com.dhgate.rmidemo.Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void setSettings() {

        String pass = "password";
        System.setProperty("javax.net.ssl.debug", "all");
        System.setProperty("javax.net.ssl.keyStore", "C:\\ssl\\clientkeystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "C:\\ssl\\clienttruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);

    }

}