package Server;

import Client.Vote;

import java.util.*;

public class DataStorage {
    // Responsible for storing and managing user information, candidate information and vote records

    private Map<Integer, Candidate> candidates;
    private Map<Integer, User> users;
    private Map<Integer, VoteRecord> voteRecords;
    private Map<Integer, Integer> resultCandidates = new HashMap<>();

    public DataStorage() {
        candidates = new HashMap<>();
        users = new HashMap<>();
        voteRecords = new HashMap<>();
        User user = new User(1,"pass1");
        users.put(user.getStudentNumber(), user);
        User user2 = new User(2, "pass2");
        users.put(user2.getStudentNumber(), user2);
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

    public void calculateResults() {
        List<VoteRecord> voteRecords = getAllVoteRecords();
        Map<Integer, Integer> resultCandidates = new HashMap<>();

        for (VoteRecord voteRecord : voteRecords) {
            Map<Integer, Integer> votes = voteRecord.getVote();

            votes.forEach((candidateNumber, rank) -> {
                resultCandidates.merge(candidateNumber, rank, Integer::sum);
            });
        }

        System.out.println(resultCandidates.toString());
        this.resultCandidates = resultCandidates;
    }

    public void printResults(){
        resultCandidates.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}
