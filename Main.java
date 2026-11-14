import java.util.Scanner;

public class Main {
  public static void main(String args[]) {


    UserManagerInterface userManager = new UserManager();
    TaskManagerInterface taskManager = new TaskManager();

    Scanner scanner = new Scanner(System.in);


    while(true) {

      UserInterface user = userManager.userLogin(scanner);

      Integer menuChoice = 0;

      while (menuChoice != 5) {

        System.out.println("The options you can use from us");
        System.out.println("1.Add Task");
        System.out.println("2.List Tasks");
        System.out.println("3.Update Task");
        System.out.println("4.Delete Task");
        System.out.println("5.Exit TaskManager");


        try {
          System.out.println("Enter your option to use");
          menuChoice = new Integer(scanner.nextLine());

        } catch (Exception e) {
          System.out.println("Enter a valid input as number");
          continue;
        }


        if (menuChoice == 1) {

          taskManager.add(scanner , user);

        }
        else if (menuChoice == 2) {

          taskManager.list(scanner , user);

        }
        else if (menuChoice == 3) {

          taskManager.update(scanner , user);

        }
        else if (menuChoice == 4) {

          taskManager.delete(scanner , user);

        }
        else if (menuChoice == 5) {

          System.out.println("Thanks for using our taskManager");

        }
        else {

          System.out.println("Enter a valid choice");

        }

      }
    }
    }
  }




