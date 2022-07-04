package com.dh.alarmservice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteMath extends Remote {

    // 所有方法必须抛出RemoteException
    public double add(double a, double b) throws RemoteException;

    public double subtract(double a, double b) throws RemoteException;

}
