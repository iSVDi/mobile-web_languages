package lab4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HostelContrainer implements IContainer {

    ArrayList<Hostel> hostels = new ArrayList<Hostel>();

    @Override
    public void displayContainer() {
        hostels.forEach(hostel -> {
            System.out.println(hostel.toString());
        });
    }

    @Override
    public void readData() throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/java/lab4/texts/Hostel.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw e;
        }

        for (String hostelLine : lines) {
            var hostelData = hostelLine.split(", ");
            var hostel = new Hostel(hostelData[0],
                    hostelData[1],
                    hostelData[2],
                    LocalDateTime.parse(hostelData[3])
            );
            hostels.add(hostel);
        }
    }

    @Override
    public void search(String query) {
        // TODO use try catch
        int year = Integer.parseInt(query);

        hostels.stream().filter(hostel -> {
            return hostel.getLivingEnd().getYear() == year;
        }).forEach(hostel -> {
            System.out.println(hostel.toString());
        });

    }
}
