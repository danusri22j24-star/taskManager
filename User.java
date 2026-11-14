public class User implements UserInterface {


    private String userName;


    private TaskInterface [] taskArray = new Task [5];

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public TaskInterface [] getTaskArray(){
        return this.taskArray;
    }

}
