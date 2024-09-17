package lab4;

import java.math.BigDecimal;
import java.time.LocalTime;

/*
 Класс «Кинотеатр(Cinema)» с полями:
    * название фильма,
     количество мест,
     количество зрителей,
     стоимость билета,
     начало сеанса.
Вывести процент заполнения зала для запрашиваемого фильма.
 */

public class Cinema {
    private final String name;
    private final int seatsCount;
    private final int visitorCount;
    private final float price;
    private final LocalTime sessionBeginning;

    public Cinema(String name, int seatsCount, int visitorCount, float price, LocalTime sessionBeginning) {
        this.name = name;
        this.seatsCount = seatsCount;
        this.visitorCount = visitorCount;
        this.price = price;
        this.sessionBeginning = sessionBeginning;
    }

    public String getName() {
        return name;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public float getPrice() {
        return price;
    }

    public LocalTime getSessionBeginning() {
        return sessionBeginning;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", seatsCount=" + seatsCount +
                ", visitorCount=" + visitorCount +
                ", price=" + price +
                ", sessionBeginning=" + sessionBeginning +
                '}';
    }
}
