package Server;

import Client.Vote;

import java.util.*;

public class VotingManager implements Vote {
    // Manages the voting process
    // Generates and sends One Time Password to users
    private List<User> users = new ArrayList<>();

    public VotingManager(DataStorage dataStorage) {
        users = dataStorage.getAllUsers();

    }

    @Override
    public boolean canVote(int studentNumber){
        for (User user : users){
            if (user.getStudentNumber()==studentNumber && user.isHasVoted()==false) return true;
        }
        return false;
    }

    public User setVoteForRevote(int studentNumber){
        for (User user : users){
            if (user.getStudentNumber()==studentNumber) user.setHasVoted(false);
            return user;
        }
        return null;
    }
}
