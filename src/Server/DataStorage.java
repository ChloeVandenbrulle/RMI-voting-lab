package Server;

import Client.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {
    // Responsible for storing and managing user information, candidate information and vote records

    private Map<String, Candidate> candidates;
    private Map<Integer, User> users;
    private List<VoteRecord> voteRecords;

    public DataStorage() {
        candidates = new HashMap<>();
        users = new HashMap<>();
        voteRecords = new ArrayList<>();
    }

    // Candidates
    public void addCandidate(Candidate candidate){
        candidates.put(candidate.getName(), candidate);
    }

    public Candidate getCandidate(String name) {
        return candidates.get(name);
    }

    public List<Candidate> getAllCandidates(){
        return new ArrayList<>(candidates.values());
    }

    // Users
    public void addUser(User user){
        users.put(user.getStudentNumber(), user);
    }
    public User getUser(int studentNumber) {
        return users.get(studentNumber);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }

    // Vote Records
    public void addVoteRecord(VoteRecord voteRecord){
        voteRecords.add(voteRecord);
    }

    public List<VoteRecord> getAllVoteRecords(){
        return new ArrayList<>(voteRecords);
    }


}
