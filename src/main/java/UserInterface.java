import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public String setUserInput(){
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

    public void printItemsInRoom(Room room){
        ArrayList<Item> itemList = room.getItemList();
        if(!itemList.isEmpty()){
            System.out.println("In this room you see:");
            for(Item item : itemList){
                System.out.println("A " + item.getName());
            }
        } else {
            System.out.println("There are no items in this room.");
        }
    }
    public void takeItem(ArrayList<Item> listOfItems, Item item){
        if(!listOfItems.isEmpty()){
            System.out.println("You took the " + item.getName());
        } else {
            System.out.println("There are no items left to take in this room.");
        }
    }
    public void showInventoryItems(ArrayList<Item> inventoryItems){
        System.out.println("Your inventory contains: ");
        int count = 0;
        for(Item item : inventoryItems){
            count++;
            System.out.println(count + ". " + item.getName() + ", " + item.getDescription());
        }
    }

    public void noItemsLeftError(){
        System.out.println("There are no more items to take in this room!");
    }

    public void lookForDoors(Room currentRoom){
        if(currentRoom.getNorth() != null){
            System.out.println("You see a door to the north..");
        } else if(currentRoom.getEast() != null){
            System.out.println("You see a door to the east..");
        } else if(currentRoom.getSouth() != null){
            System.out.println("You see a door to the south..");
        } else if(currentRoom.getWest() != null){
            System.out.println("You see a door to the west..");
        } else {
            System.out.println("You see no doors... You are trapped!");
        }
    }

    public int whatItemToRemove(ArrayList<Item> inventory){
        int count = 0;
        for(Item item : inventory){
            count++;
            System.out.println(count + ". " + item.getName() + ", " + item.getDescription());
        }
        Scanner input = new Scanner(System.in);
        int itemToRemove = input.nextInt();
        return itemToRemove;
    }

    public void removeItem(Item item){
        System.out.println("You removed the item: " + item.getName() + " from your inventory.");
    }

    public void removeItemError(ArrayList<Item> inventory){
        if(!inventory.isEmpty()){
            System.out.println("Your inventory does not contain the item you want to remove..");
        } else {
            System.out.println("Your inventory does not contain any items..");
        }
    }

    public void help(){
        System.out.println("You can write the following commands: ");
        System.out.println("Look: Looks for nearby doors.");
        System.out.println("Take: Takes an item from the inventory.");
        System.out.println("Drop: Drops one item from your inventory.");
        System.out.println("Show: Shows the items currently in your inventory.");
    }

    public void userChoices(){
        System.out.println("What do you do?");
    }
}
