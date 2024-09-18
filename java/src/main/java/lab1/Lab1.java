package lab1;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        var students = readStudents();
        Institute institute = new Institute(students);
        institute.doSession();
        try {
            institute.createOrderScholarshipStudents();
            institute.createOrderExpelledStudents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static ArrayList<Student> readStudents() {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get("src/main/java/lab1/texts/students.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Student> students = new ArrayList<>();

        var iterator = lines.iterator();
        while (iterator.hasNext()) {
            var line = iterator.next();
            var studentData = line.split(", ");
            Student student = new Student(studentData[0],
                    studentData[1],
                    studentData[2],
                    Boolean.parseBoolean(studentData[3]));
            students.add(student);
        }
    return students;
    }
}

