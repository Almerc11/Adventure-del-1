import java.util.Scanner;

public class UserInterface {
    public String setUserDirection(){
        String userDirection;
        Scanner input = new Scanner(System.in);
        userDirection = input.nextLine();
        return userDirection;
    }
}
