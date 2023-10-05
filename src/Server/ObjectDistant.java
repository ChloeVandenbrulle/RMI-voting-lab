package Server;

import Client.Authentication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjectDistant extends UnicastRemoteObject implements Distant {
    private DataStorage dataStorage;
    protected ObjectDistant(int port) throws RemoteException {
        super(port);
        dataStorage = new DataStorage();
    }

    @Override
    public boolean authenticationManager(int studentNumber, String password) throws RemoteException {
        AuthenticationManager authenticationManager = new AuthenticationManager(dataStorage);
        return authenticationManager.authenticate(studentNumber, password);
    }

    @Override
    public boolean canVote(int studentNumber) throws RemoteException {
        VotingManager votingManager = new VotingManager(dataStorage);
        return votingManager.canVote(studentNumber);
    }

    @Override
    public int sendOTP(int studentNumber) throws RemoteException{
        User userCurrent = null;
        VotingMaterial votingMaterial = new VotingMaterial(dataStorage, studentNumber);
        for (User user: votingMaterial.getUsersWithoutOTP()){
            if (studentNumber==user.getStudentNumber() && user.getOTP()==-1){
                votingMaterial.generateOTP(user);
                userCurrent = user;
            }
            break;
        }
        return userCurrent.getOTP();
    }

    @Override
    public String sendCandidates(int studentNumber) throws RemoteException {
        VotingMaterial votingMaterial = new VotingMaterial(dataStorage, studentNumber);
        return votingMaterial.displayCandidates();
    }

}
