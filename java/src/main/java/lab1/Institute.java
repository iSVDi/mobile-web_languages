package lab1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Institute {
    private ArrayList<Student> students;

    Institute(ArrayList<Student> students) {
        this.students = students;
    }

    void doSession() {
        students.forEach(Student::setExamScore);
        students.forEach(student -> {
            var isEnableScholarship = student.getExamScore() > 3;
            var studentState = student.getExamScore() > 2 ? StudentState.STUDY : StudentState.EXPELLED;
            student.setEnableScholarship(isEnableScholarship);
            student.setState(studentState);
        });
    }

    void createOrderScholarshipStudents() throws IOException {
        var studentForWrite = students.stream().filter(student -> {
            return student.getExamScore() > 3;
        }).toList();
        writeStudents(studentForWrite, "scholarshipStudents.txt");
    }


    void createOrderExpelledStudents() throws IOException {
        var studentForWrite = students.stream().filter(student -> {
            return student.getExamScore() == 2;
        }).toList();
        writeStudents(studentForWrite, "expelledStudents.txt");
    }

    private void writeStudents(List<Student> studentsToWrite, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter((new FileWriter("src/main/java/lab1/texts/" + fileName)));
        studentsToWrite
                .forEach(student -> {
                    try {
                        writer.write(student.getFirstName() + " " + student.getLastName() + " " + student.getExamScore());
                        writer.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        writer.close();
    }
}
