package lab4;

import java.time.LocalDateTime;

/*
Класс “Общежитие (Hostel)” с полями:
    * ФИО студента,
    номер группы,
    номер комнаты,
    срок окончания проживания.
Вывести информацию о студентах задаваемой группы, срок проживания которых заканчивается в задаваемом году.
 */
public class Hostel {
    private String firstName;
    private String LastName;
    private String Group;
    private LocalDateTime livingEnd;

    public Hostel(String firstName, String lastName, String group, LocalDateTime livingEnd) {
        this.firstName = firstName;
        LastName = lastName;
        Group = group;
        this.livingEnd = livingEnd;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getGroup() {
        return Group;
    }

    public LocalDateTime getLivingEnd() {
        return livingEnd;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Group='" + Group + '\'' +
                ", livingEnd=" + livingEnd +
                '}';
    }
}
