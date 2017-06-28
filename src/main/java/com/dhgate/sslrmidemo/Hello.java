package com.dhgate.sslrmidemo; /**
 * Created by liyazhou on 2017/6/28.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    String sayHello() throws RemoteException;

}
