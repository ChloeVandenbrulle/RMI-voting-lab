package Server;

import Client.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {
    // Responsible for storing and managing user information, candidate information and vote records

    private Map<Integer, Candidate> candidates;
    private Map<Integer, User> users;
    private Map<Integer, VoteRecord> voteRecords;

    public DataStorage() {
        candidates = new HashMap<>();
        users = new HashMap<>();
        voteRecords = new HashMap<>();
        User user = new User(1,"password1");
        users.put(user.getStudentNumber(), user);
        Candidate candidate1 = new Candidate(1,"Samy", "");
        Candidate candidate2 = new Candidate(2, "Alice", "");
        candidates.put(candidate1.getCandidateNumber(), candidate1);
        candidates.put(candidate2.getCandidateNumber(), candidate2);
    }

    // Candidates
    public void addCandidate(Candidate candidate){
        candidates.put(candidate.getCandidateNumber(), candidate);
    }

    public Candidate getCandidate(int candidateNumber) {
        return candidates.get(candidateNumber);
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

    public Map<Integer, User> getUsers() {
        return users;
    }

    // Vote Records
    public void addVoteRecord(int studentNumber, VoteRecord voteRecord){
        voteRecords.put(studentNumber, voteRecord);
    }

    public List<VoteRecord> getAllVoteRecords(){
        return new ArrayList<>(voteRecords.values()) ;
    }

    public Map<Integer, VoteRecord> getVoteRecords() {
        return  voteRecords;
    }


}
