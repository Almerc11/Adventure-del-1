import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public String setUserInput(){
        String userDirection;
        Scanner input = new Scanner(System.in);
        userDirection = input.nextLine();
        return userDirection;
    }

    public void giveEndMessage(String roomDescription){
        System.out.println(roomDescription);
        System.out.println("Thank you for playing.");
    }

    public void giveNormalStartMessage(String roomName, String roomDescription){
        System.out.println("You are currently standing in " + roomName + ", " + roomDescription);
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

    public void printItemsInRoom(String itemNameFromRoom){
        System.out.println("A " + itemNameFromRoom);
    }

    public void noItems(){
        System.out.println("There are no items in this room..");
    }
    public void takeItem(ArrayList<Item> listOfItems, String itemName){
        if(!listOfItems.isEmpty()){
            System.out.println("You took the " + itemName);
        } else {
            System.out.println("There are no items left to take in this room.");
        }
    }

    public void firstShowInventoryMessage(){
        System.out.println("Your inventory contains: ");
    }

    public void showInventoryItems(String itemName, String itemDescribtion, int count){
        System.out.println(count + ". " + itemName + ", " + itemDescribtion);
    }

    public void noItemsError(){
        System.out.println("Your inventory does not contain any items!");
    }

    public void noItemsLeftError(){
        System.out.println("There are no more items to take in this room!");
    }
    public void lookForNorth(){
        System.out.println("You see a door to the north..");
    }
    public void lookForSouth(){
        System.out.println("You see a door to the south..");
    }
    public void lookForEast(){
        System.out.println("You see a door to the east..");
    }
    public void lookForWest(){
        System.out.println("You see a door to the west..");
    }

    public void removeItem(String itemName){
        System.out.println("You removed the item: " + itemName + " from your inventory.");
    }
    public void userRemoveItemChoice(){
        System.out.println("What item would you like to remove?");
    }

    public String userChoiceToRemoveItem(){
        Scanner input = new Scanner(System.in);
        String itemToBeRemoved = input.nextLine();
        return itemToBeRemoved;
    }

    public void showItems(String itemName, String itemDescription){
        System.out.println(itemName + ", " + itemDescription);
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
        System.out.println("Exit: Closes the game.");
    }

    public void userChoices(){
        System.out.println("What do you do?");
    }



    public void takeFood(ArrayList<Food> foodList, String foodName) {
        if (!foodList.isEmpty()) {
            System.out.println("You picked up " + foodName);
        } else {
            System.out.println("There is no food left in this room.");
        }
    }

    public void playerChoices(Adventure adventure ,String userChoice) {
        // ...

        if (userChoice.contains("health")) {
            showHealthStatus();
        }
    }

}

