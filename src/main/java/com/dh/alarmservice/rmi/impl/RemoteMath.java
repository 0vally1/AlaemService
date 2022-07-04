package com.dh.alarmservice.rmi.impl;

import com.dh.alarmservice.rmi.IRemoteMath;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 服务器端实现远程接口。
 * 必须继承UnicastRemoteObject，以允许JVM创建远程的存根/代理。
 */
public class RemoteMath extends UnicastRemoteObject implements IRemoteMath {

    private int numberOfComputations;

    // protected
    public RemoteMath() throws RemoteException {
        numberOfComputations = 0;
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        numberOfComputations++;
        System.out.println("Number of computations performed so far = " + numberOfComputations);
        return (a+b);
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        numberOfComputations++;
        System.out.println("Number of computations performed so far = " + numberOfComputations);
        return (a-b);
    }
}
