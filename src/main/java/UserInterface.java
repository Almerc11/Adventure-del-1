import rooms.Room;

import java.util.Scanner;

public class UserInterface {
    public String setUserDirection(){
        String userDirection;
        Scanner input = new Scanner(System.in);
        userDirection = input.nextLine();
        return userDirection;
    }

    public void giveEndMessage(Room room){
        System.out.println(room.getDescription());
        System.out.println("Thank you for playing.");
    }

    public void giveNormalStartMessage(Room room){
        System.out.println("You are currently standing in " + room.getName() + ", " + room.getDescription());
    }
    public void giveNorthDirectionMessage(){
        System.out.println("you choose to go north");
    }

    public void giveSouthDirectionMessage(){
        System.out.println("you choose to go south");

    }

    public void giveEastDirectionMessage(){
        System.out.println("you choose to go east");
    }

    public void giveWestDirectionMessage() {
        System.out.println("You choose to go west");
    }

    public void giveErrorDirectionsMessage(){
        System.out.println("You can't go that way");
    }
}
