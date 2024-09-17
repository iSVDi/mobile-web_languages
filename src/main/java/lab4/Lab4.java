package lab4;

import java.io.IOException;
import java.time.LocalDateTime;

public class Lab4 {
    public static void main(String[] args) {
        var hostel = new HostelContrainer();
        var cinema = new CinemaContainer();


        try {
            cinema.readData();
            hostel.readData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        hostel.search("2023");
        cinema.search("asdasdad");
    }

}
