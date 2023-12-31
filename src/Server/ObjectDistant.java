package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjectDistant extends UnicastRemoteObject implements Distant {
    private DataStorage dataStorage;
    private boolean isServerReadOnly = false;
    protected ObjectDistant(int port) throws RemoteException {
        super(port);
        dataStorage = new DataStorage();
    }

    public void setServerReadOnly(boolean serverReadOnly) {
        isServerReadOnly = serverReadOnly;
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
        for (User user: votingMaterial.getUsers()){
            if (studentNumber==user.getStudentNumber()){
                votingMaterial.generateOTP(user);
                userCurrent = user;
                break;
            }
        }
        return userCurrent.getOTP();
    }

    @Override
    public String sendCandidates(int studentNumber) throws RemoteException {
        VotingMaterial votingMaterial = new VotingMaterial(dataStorage, studentNumber);
        return votingMaterial.displayCandidates();
    }

    @Override
    public void retrieveVote(VoteRecord voteRecord, int studentNumber) throws RemoteException {
        dataStorage.addVoteRecord(studentNumber,voteRecord);
        System.out.println(dataStorage.getVoteRecordofUser(studentNumber));

        for (User user: dataStorage.getAllUsers()){
            if (user.getStudentNumber()==studentNumber){
                user.setHasVoted(true);
            }
        }

    }

    @Override
    public void getResult() throws RemoteException{
        dataStorage.calculateResults();
        dataStorage.printResults();
    }

    @Override
    public String getResultUser() throws RemoteException {
        return dataStorage.printResultsUser();
    }

    @Override
    public void setUserForRevote(int studentNumber) throws RemoteException {
        VotingManager votingManager = new VotingManager(dataStorage);
        User user = votingManager.setVoteForRevote(studentNumber);
        dataStorage.getUsers().put(studentNumber, user);
    }

    @Override
    public int getOTPUser(int studentNumber) throws RemoteException {
        User user = dataStorage.getUser(studentNumber);
        return user.getOTP();
    }

    @Override
    public void getNameUser(int studentNumber) throws RemoteException {
        User user = dataStorage.getUser(studentNumber);
        System.out.println("Nom du votant : "+user.getName());
    }

    @Override
    public boolean isServerInReadOnlyMode() throws RemoteException {
        return isServerReadOnly;
    }
}
