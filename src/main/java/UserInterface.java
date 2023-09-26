import java.util.Scanner;

public class UserInterface {
    String userDirection;
    public String setUserDirection(){
        Scanner input = new Scanner(System.in);
        userDirection = input.nextLine();
        return userDirection;
    }
}
