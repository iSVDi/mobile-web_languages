package lab4;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaContainer implements IContainer {
    Map<String, Cinema> cinemas = new HashMap<String, Cinema>();
    @Override
    public void displayContainer() {
        cinemas.entrySet().forEach(cinema -> {
            System.out.println(cinema.toString() );
        });
    }

    @Override
    public void readData() throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/java/lab4/texts/Cinema.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw e;
        }

        for (String cinemaLine : lines) {
            var cinemaData = cinemaLine.split(", ");
            var cinema = new Cinema(cinemaData[0],
                    Integer.parseInt(cinemaData[1]),
                    Integer.parseInt(cinemaData[2]),
                    Float.parseFloat(cinemaData[3]),
                    LocalTime.parse(cinemaData[4]));
            cinemas.put(cinema.getName(), cinema);
        }

    }

    @Override
    public void search(String query) {
        var keysByRequest = cinemas.keySet().stream().filter(key -> key.toLowerCase().contains(query.toLowerCase())).toList();

        if (keysByRequest.isEmpty()) {
            System.out.println("No one cinema's name contain such query");
        }

        keysByRequest.forEach(key -> {
            var cinema = cinemas.get(key);
            var percent = ((float)cinema.getVisitorCount() / (float)cinema.getSeatsCount()) * 100;
            System.out.println(cinema.getName() + " - " + percent + "%");
        });


    }


}
