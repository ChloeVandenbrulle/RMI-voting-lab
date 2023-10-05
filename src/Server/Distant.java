package Server;

import Client.Authentication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Distant extends Remote {
    boolean authenticationManager(int studentNumber, String password) throws RemoteException;
    boolean canVote(int studentNumber) throws RemoteException;
    int sendOTP(int studentNumber) throws RemoteException;
    String sendCandidates(int studentNumber) throws RemoteException;
}
