import java.util.Scanner;

public interface TaskManagerInterface {
    public void add(Scanner scanner, UserInterface user);
    public void list(Scanner scanner, UserInterface user);
    public void update(Scanner scanner, UserInterface user);
    public void delete (Scanner scanner, UserInterface user);
}
