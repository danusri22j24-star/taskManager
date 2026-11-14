import java.util.Scanner;

public class UserManager implements UserManagerInterface {

    User[] existingUser = new User[5];


    int userPosition = 0;

    public UserInterface userLogin(Scanner scanner) {
        System.out.println("Welcome to Task Manager");
        System.out.println("Enter your Name");
        String userName = (scanner.nextLine());

        boolean isExistingUser = false;
        for (int i = 0; i < existingUser.length; i++) {
            if (existingUser[i] == null) {
                continue;
            }
            if (existingUser[i].getUserName() != null) {
                if (existingUser[i].getUserName().equals(userName)) {
                    System.out.print("Welcome back ");
                    System.out.println(userName);
                    isExistingUser = true;
                    userPosition = i;
                    break;
                }
            }
        }

        User user;
        if (isExistingUser == false) {
            user = new User(userName);
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] != null) {
                    continue;
                }
                existingUser[i] = user;
                break;
            }
        } else {
            user = existingUser[userPosition];
        }
        return user;
    }
}