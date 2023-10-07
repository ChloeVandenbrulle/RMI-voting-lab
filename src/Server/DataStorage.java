package Server;

import java.util.*;
import java.util.stream.Collectors;

public class DataStorage {
    // Responsible for storing and managing user information, candidate information and vote records

    private Map<Integer, Candidate> candidates;
    private Map<Integer, User> users;
    private Map<Integer, VoteRecord> voteRecords;
    private Map<Integer, Integer> resultCandidates = new HashMap<>();

    public DataStorage() {
        candidates = new HashMap<>();
        createCandidates();
        users = new HashMap<>();
        createUsers();
        voteRecords = new HashMap<>();
    }

    public void createUsers(){
        User user1 = new User(1,"Clervie Causer","causer");
        users.put(user1.getStudentNumber(), user1);
        User user2 = new User(2, "Chloé Vandenbrulle", "vandenbrulle");
        users.put(user2.getStudentNumber(), user2);
        User user3 = new User(3, "Benjamin Vella", "vella");
        users.put(user3.getStudentNumber(), user3);
        User user4 = new User(4, "Françoise Baude", "baude");
        users.put(user4.getStudentNumber(), user4);
    }

    public void createCandidates(){
        Candidate candidate1 = new Candidate(1,"Samy", "Votez pour moi, je sais hacker!");
        Candidate candidate2 = new Candidate(2, "Alice", "Je vous protégerai de Samy.");
        Candidate candidate3 = new Candidate(3, "Bobby", "Je peux faire vos travaux de maison, je suis bricoleur.");
        candidates.put(candidate1.getCandidateNumber(), candidate1);
        candidates.put(candidate2.getCandidateNumber(), candidate2);
        candidates.put(candidate3.getCandidateNumber(), candidate3);
    }

    public List<Candidate> getAllCandidates(){
        return new ArrayList<>(candidates.values());
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

    public VoteRecord getVoteRecordofUser(int studentNumber) {
        VoteRecord voteRecordUser = voteRecords.get(studentNumber);
        return voteRecordUser;
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
        this.resultCandidates = resultCandidates;
    }

    public void printResults(){
        System.out.println("Les résultats du vote sont :");
        Map<Integer, Integer> sortedMap = resultCandidates.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));;
        for (Integer candidateNumber : sortedMap.keySet()){
            String candidateName = candidates.get(candidateNumber).getName();
            Integer totalVotes = sortedMap.get(candidateNumber);
            System.out.println("Candidat " + candidateNumber + ": " + candidateName + " a eu un total de " + totalVotes + " voies.");
        }
    }

    public String printResultsUser() {
        String affichage = "Les résultats du vote sont :\n";
        Map<Integer, Integer> sortedMap = resultCandidates.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));;
        for (Integer candidateNumber : sortedMap.keySet()){
            String candidateName = candidates.get(candidateNumber).getName();
            Integer totalVotes = sortedMap.get(candidateNumber);
            affichage += "Candidat " + candidateNumber + ": " + candidateName + " a eu un total de " + totalVotes + " voies.\n";
        }
        return affichage;
    }
}
