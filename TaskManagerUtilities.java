import java.util.Scanner;

public class TaskManagerUtilities {

    public static boolean print(UserInterface user) {

        boolean listChecker = false;
        for (int i = 0; i < user.getTaskArray().length; i++) {
            if (user.getTaskArray()[i] == null) {
                continue;
            }
            System.out.println("====================================");
            System.out.print(i + 1);
            System.out.print(". ");
            System.out.print("Title: ");
            System.out.println(user.getTaskArray()[i].getTittle());
            System.out.print("Status: ");
            System.out.println(user.getTaskArray()[i].getStatus());
            System.out.print("Description: ");
            if (user.getTaskArray()[i].getDescription() == null) {
                System.out.println("Description is empty");
                continue;
            }else {
                System.out.println(user.getTaskArray()[i].getDescription());
            }
            System.out.println("====================================");
            listChecker = true;


        }
        return listChecker;
    }

    public static boolean printWithStatus (UserInterface user,String status){
        boolean listChecker = false;
        for (int a = 0; a < user.getTaskArray().length; a++) {
            if (user.getTaskArray()[a] == null) {
                continue;
            }
            if (user.getTaskArray()[a].getStatus().equals(status)) {
                System.out.println("====================================");
                System.out.print("* ");
                System.out.print("Title: ");
                System.out.println(user.getTaskArray()[a].getTittle());
                System.out.print("Status: ");
                System.out.println(user.getTaskArray()[a].getStatus());
                System.out.print("Description: ");
                if (user.getTaskArray()[a].getDescription() == null) {
                    System.out.println("Description is empty");
                    System.out.println("====================================");
                    continue;
                }else {
                    System.out.println(user.getTaskArray()[a].getDescription());
                    System.out.println("====================================");
                }

                listChecker = true;
            }

        }
        return listChecker;
    }

    public static int choice (UserInterface user, Scanner scanner) {


        String value = scanner.nextLine();


        if (value.equals("exit")) {
            return -2;
        }

        int choice;
        try {
            choice = new Integer(value);
        } catch (Exception e) {
            System.out.println("Invalid input , Enter a number");
            return -1;
        }


        if (choice < 1 || choice > user.getTaskArray().length) {
            System.out.println("Choice out of array range");
            return -1;
        }

        if (user.getTaskArray()[choice - 1] == null) {
            System.out.println("No task exists at this position.");
            return -1;
        }


        return choice - 1;
    }



    public static String tittle (Scanner scanner){
        System.out.println("Enter your Task Tittle or enter exit to leave the option");
        String tittle = scanner.nextLine();
        return tittle;
    }

    public static String description (Scanner scanner){
        System.out.println("Enter your Task Description or enter exit to leave the option");
        String description = scanner.nextLine();
        return description;
    }


}
