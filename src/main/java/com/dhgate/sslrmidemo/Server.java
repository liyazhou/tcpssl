package com.dhgate.sslrmidemo; /**
 * Created by liyazhou on 2017/6/28.
 */
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {


    public static void main(String[] args) throws RemoteException, IllegalArgumentException {

        try {

            setSettings();
            Hello hello = new HelloImpl(2020);
            LocateRegistry.createRegistry(2020, new SslRMIClientSocketFactory(), new SslRMIServerSocketFactory(null, null, true));
//            LocateRegistry.createRegistry(2020);
//            LocateRegistry.createRegistry(2020);
            System.out.println("RMI registry running on port " + 2020);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2020, new SslRMIClientSocketFactory());
//            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2020);

            registry.bind("com.dhgate.rmidemo.Hello",  hello);

        } catch (Exception e) {
            System.err.println("com.dhgate.rmidemo.Server exception: " + e.toString());
            e.printStackTrace();
        }

    }

    private static void setSettings() {

        String pass = "liyazhou";

        System.setProperty("javax.net.ssl.debug", "all");

//        System.setProperty("javax.net.ssl.keyStore", "/Users/liyazhou/workspace/tcpssl/certificate/server.jks");
//        System.setProperty("javax.net.ssl.keyStorePassword", pass);
        System.setProperty("javax.net.ssl.trustStore", "/Users/liyazhou/workspace/tcpssl/certificate/serverTrust.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", pass);

//
        System.setProperty("javax.net.ssl.keyStore", "/Users/liyazhou/workspace/tcpssl/certificate/client.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", pass);
//        System.setProperty("javax.net.ssl.trustStore", "/Users/liyazhou/workspace/tcpssl/certificate/clientTrust.jks");
//        System.setProperty("javax.net.ssl.trustStorePassword", pass);




    }

}
