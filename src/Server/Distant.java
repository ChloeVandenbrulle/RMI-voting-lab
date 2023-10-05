package Server;

import Client.Authentication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Distant extends Remote {
    boolean authenticationManager(int studentNumber, String password) throws RemoteException;
}
