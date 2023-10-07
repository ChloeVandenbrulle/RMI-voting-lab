package Server;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; //Nécessaire pour la sérialisation
    private int studentNumber;
    private String name;
    private String password;
    private boolean hasVoted;
    private int OTP;

    public User(int studentNumber, String name, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        hasVoted = false;
        OTP = -1;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public int getOTP() {
        return OTP;
    }

    public void setOTP(int OTP) {
        this.OTP = OTP;
    }

    @Override
    public String toString() {
        return "User{" +
                "studentNumber=" + studentNumber +
                ", password='" + password + '\'' +
                ", otp= " + OTP +
                '}';
    }
}
