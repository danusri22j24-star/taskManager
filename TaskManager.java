import java.util.Scanner;

public class TaskManager implements TaskManagerInterface{




    public void add(Scanner scanner, UserInterface user) {

        boolean executer = true;
        boolean addMultipleTasks = true;

        while(executer || addMultipleTasks) {

            boolean print = TaskManagerUtilities.print(user);
            TaskInterface task = new Task();

            if (print == false) {
                System.out.println("===== There is no tasks to list =====");
            }
            try {
                String tittle = TaskManagerUtilities.tittle(scanner);

                if (tittle.equals("exit")) {
                    throw new Exception();
                }


                System.out.println("Do you want to add description yes/exit");
                String addDescription = (scanner.nextLine());



                if (addDescription.equals("exit")) {

                    for (int i = 0; i < user.getTaskArray().length; i++) {
                        if (user.getTaskArray()[i] == null) {
                            user.getTaskArray()[i] = task;
                            user.getTaskArray()[i].setTittle(tittle);
                            user.getTaskArray()[i].setStatus("To-Do");
                            System.out.println("Task title added sucessfully");
                            break;
                        }
                    }
                    throw new Exception ();
                }



                else if (addDescription.equals("yes")) {
                    String description = TaskManagerUtilities.description(scanner);
                    if (description.equals("exit")) {
                        throw new Exception ();
                    }
                    for (int i = 0; i < user.getTaskArray().length; i++) {
                        if (user.getTaskArray()[i] == null) {
                            user.getTaskArray()[i] = task;
                            user.getTaskArray()[i].setTittle(tittle);
                            user.getTaskArray()[i].setDescription(description);
                            System.out.println("Task added sucessfully with description and ttitle");
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your entered option is invalid");
                    continue;
                }

                System.out.println("Do you want to add another task yes/exit");
                String addAnotherTask = (scanner.nextLine());

                if (addAnotherTask.equals("exit")){
                    throw new Exception();
                }
                else if (addAnotherTask.equals("yes")){
                    addMultipleTasks = true;
                }

                else {
                    System.out.println("Your entered option is invalid");
                }


            }
            catch (Exception e){
                System.out.println("Exiting from this option");
                executer = false;
                addMultipleTasks = false;
            }
        }
    }

    public void list(Scanner scanner, UserInterface user){
        boolean executer = true;
        while(executer) {

            try {
                boolean hasTask = false;

                for (int i = 0; i < user.getTaskArray().length; i++) {
                    if (user.getTaskArray()[i] != null) {
                        hasTask = true;
                        break;
                    }
                }

                if (!hasTask) {
                    System.out.println("========== There is no task to list ==========");
                    break;
                }

                System.out.println("1.To-Do");
                System.out.println("2.In-Progress");
                System.out.println("3.Done");
                System.out.println("4.All Tasks");
                System.out.println("5.Only title");





                System.out.println("Select an option to list or enter exit to leave");
                String listChoice = (scanner.nextLine());

                if (listChoice.equals("exit")) {
                    throw new Exception();
                }


                if (listChoice.equals("1")) {

                    boolean listChecker1 = TaskManagerUtilities.printWithStatus ( user, "To-Do");

                    if (listChecker1 == false) {
                        System.out.println("There is no task To-Do");

                    }
                }

                else if (listChoice.equals("2")) {

                    boolean listChecker2 = TaskManagerUtilities.printWithStatus ( user, "In-Progress");
                    if (listChecker2 == false) {
                        System.out.println("There is no task In-Progress");

                    }
                }

                else if (listChoice.equals("3")) {
                    boolean listChecker3 = TaskManagerUtilities.printWithStatus ( user, "Done");

                    if (listChecker3 == false) {
                        System.out.println("There is no task Done");
                    }
                }

                else if (listChoice.equals("4")) {
                    boolean listChecker1 = TaskManagerUtilities.printWithStatus ( user, "To-Do");

                    if (listChecker1 == false) {
                        System.out.println("There is no task To-Do");
                    }

                    boolean listChecker2 = TaskManagerUtilities.printWithStatus ( user, "In-Progress");

                    if (listChecker2 == false) {
                        System.out.println("There is no task In-Progress");

                    }

                    boolean listChecker3 = TaskManagerUtilities.printWithStatus ( user, "Done");

                    if (listChecker3 == false) {
                        System.out.println("There is no task Done");

                    }
                }

                else if (listChoice.equals("5")){

                    for (int g = 0; g < user.getTaskArray().length; g++) {
                        if (user.getTaskArray()[g] == null) {
                            continue;
                        }
                        {
                            System.out.print(g + 1);
                            System.out.print(". ");
                            System.out.println(user.getTaskArray()[g].getTittle());
                        }
                    }
                }

                else {
                    System.out.println("Enter a valid choice to list");
                }

            }
            catch (Exception e) {
                System.out.println("Exiting from this option");
                executer = false;
            }
        }
    }

    public void update(Scanner scanner, UserInterface user){
        boolean executer = true;
        while(executer) {

            boolean print = TaskManagerUtilities.print(user);

            if (print == false) {
                System.out.println("===== There is no tasks to update =====");
                break;
            }

            try {

                System.out.println("Select a Task to update it or exit to leave");
                Integer uChoice = TaskManagerUtilities.choice(user, scanner);


                if (uChoice == -2) {
                    throw new Exception();
                }

                if (uChoice == -1) {
                    continue;
                }

                boolean exitFromTask = false;
                while (!exitFromTask) {

                    System.out.println("1.Tittle");
                    System.out.println("2.Description");
                    System.out.println("3.Status");
                    System.out.println("4.Exit from this task");


                    System.out.println("Select your option to update");

                    String updateChoice = (scanner.nextLine());


                    if (updateChoice.equals("1")) {

                        String newTittle = TaskManagerUtilities.tittle(scanner);
                        user.getTaskArray()[uChoice].setTittle(newTittle);
                        System.out.println("New Task Tittle updated sucessfully");

                    } else if (updateChoice.equals("2")) {

                        String newDescription = TaskManagerUtilities.description(scanner);

                        user.getTaskArray()[uChoice].setDescription(newDescription);
                        System.out.println("New Task Description updated sucessfully");

                    } else if (updateChoice.equals("3")) {
                        System.out.println("1.To-Do");
                        System.out.println("2.In-Progress");
                        System.out.println("3.Done");

                        String statusChoice ;


                        System.out.println("Enter your status choice ");
                        statusChoice = (scanner.nextLine());


                        if (statusChoice.equals("1")) {
                            user.getTaskArray()[uChoice].setStatus("To-Do");
                            System.out.println("Task Status updated sucessfully");
                        }
                        else if (statusChoice.equals("2")) {
                            user.getTaskArray()[uChoice].setStatus("In-Progress");
                            System.out.println("Task Status updated sucessfully");
                        }
                        else if (statusChoice.equals("3")) {
                            user.getTaskArray()[uChoice].setStatus("Done");
                            System.out.println("Task Status updated sucessfully");
                        }
                        else {
                            System.out.println("Enter a valid choice to update");
                        }
                    }
                    else if (updateChoice.equals("4")) {
                        exitFromTask = true;
                    }
                    else {
                        System.out.println("Enter a valid input");
                    }
                }

            }
            catch (Exception e){
                System.out.println("Exiting from this option");
                executer = false;
            }
        }
    }

    public void delete (Scanner scanner, UserInterface user){
        boolean executer = true;
        while (executer) {
            boolean print = TaskManagerUtilities.print(user);


            if (print == false) {
                System.out.println("===== There is no tasks to delete =====");
                break;
            }
            try {

                System.out.println("Enter your choice to delete Task Description or enter exit to leave");
                int uChoice = TaskManagerUtilities.choice(user, scanner);

                if (uChoice == -2) {
                    throw new Exception();
                }

                if (uChoice == -1) {
                    continue;
                }


                user.getTaskArray()[uChoice] = null;
                System.out.println("Selected Task Description deleted sucessfully");

                for (int i = 0; i < user.getTaskArray().length; i++) {
                    if (user.getTaskArray()[i] != null) {
                        continue;
                    }
                    for (int j = i; j < user.getTaskArray().length; j++) {
                        if (user.getTaskArray()[j] != null) {
                            user.getTaskArray()[i] = user.getTaskArray()[j];
                            user.getTaskArray()[j] = null;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Exiting from this option");
                executer = false;
            }
        }
    }

}
