package Server;

import Client.Vote;

import java.util.*;

public class VotingManager implements Vote {
    // Manages the voting process
    // Generates and sends One Time Password to users

    private List<Integer> hasVoted = new ArrayList<>();
    private Map<Integer, Integer> otp;
    private Map<Integer, VotingMaterial> votingMaterials;

    public VotingManager(DataStorage dataStorage) {
        List<User> usersVoted = dataStorage.getAllUsers();
        System.out.println(usersVoted);
        for (User user: usersVoted){
            if (user.isHasVoted()) hasVoted.add(user.getStudentNumber());
        }

    }

    @Override
    public boolean canVote(int studentNumber){
        return (!hasVoted.contains(studentNumber));
    }
}
