package com.dhgate.rmidemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by liyazhou on 2017/6/28.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String sayHello() throws RemoteException {
        return "hello world: liyazhou";
    }
}
