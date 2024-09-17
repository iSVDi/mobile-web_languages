package lab4;


import java.io.IOException;

// ввод данных, поиск
public interface IContainer {
    void displayContainer();
    void readData() throws IOException;
    void search(String query);
}
