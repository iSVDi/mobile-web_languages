package lab1;
import java.util.SplittableRandom;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String address;
    private StudentState state = StudentState.STUDY;
    private boolean isEnableScholarship;
    private int examScore;

    public Student(String firstName, String lastName, String address, boolean isEnableScholarship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.isEnableScholarship = isEnableScholarship;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExamScore() {
        return examScore;
    }

    void setEnableScholarship(boolean enableScholarship) {
        isEnableScholarship = enableScholarship;
    }

    void setState(StudentState state) {
        this.state = state;
    }

    void setExamScore() {
        SplittableRandom random = new SplittableRandom();
        examScore = random.nextInt(2, 5+1);
    }

}
