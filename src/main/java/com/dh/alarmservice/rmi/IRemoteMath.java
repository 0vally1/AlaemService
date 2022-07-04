package com.dh.alarmservice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 必须继承Remote接口。
 * 所有参数和返回类型必须序列化(因为要网络传输)。
 * 任意远程对象都必须实现此接口。
 * 只有远程接口中指定的方法可以被调用。
 */
public interface IRemoteMath extends Remote {

    // 所有方法必须抛出RemoteException
    public double add(double a, double b) throws RemoteException;

    public double subtract(double a, double b) throws RemoteException;

}
