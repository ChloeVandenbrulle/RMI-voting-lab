package Server;

import Client.Vote;

import java.util.*;

public class VotingManager implements Vote {
    // Manages if the user can process to voting
    private List<User> users;

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
