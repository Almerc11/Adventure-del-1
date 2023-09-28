import java.util.ArrayList;
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
        System.out.println("Inside you see:");
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

    public void giveStartMessage(Room room){
        if(room.getItemList().size() > 1){
            System.out.println("You see some items on the ground!");
        } else{
            System.out.println("You see an item on the ground!");
        }
    }

    public void displayInventory(ArrayList<Item> inventory){
        if(!inventory.isEmpty()){
            System.out.println("Inventory:");
            for(Item item : inventory){
                System.out.println(item.getName() + ": " + item.getDescription());
            }
        } else {
            System.out.println("Your inventory is empty");
        }
    }

    public void printItemsInRoom(Room room){
        ArrayList<Item> itemList = room.getItemList();
        if(!itemList.isEmpty()){
            System.out.println("Items in this room");
            for(Item item : itemList){
                System.out.println(item.getName() + ": " + item.getDescription());
            }
        } else {
            System.out.println("There are no items in this room.");
        }
    }

    public String getUserInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine().toLowerCase();
    }

    public void handleUserInput(Player player, Room currentRoom){
        String userInput = getUserInput();
        if(userInput.contains("take")){
            takeItem(player, currentRoom);
        }
    }

    private void takeItem(Player player, Room currentRoom){
        ArrayList<Item> roomItem = currentRoom.getItemList();
        if(!roomItem.isEmpty()){
            Item itemToTake = roomItem.get(0);
            player.addItemToInventory(itemToTake);
            roomItem.remove(itemToTake);
            System.out.println("You took " + itemToTake.getName() + ".");
        } else {
            System.out.println("There are no items left to take in this room.");
        }
    }

    public void userChoices(){
        System.out.println("What do you do?");
    }

    public void giveDirections(Room room){
    }
}
