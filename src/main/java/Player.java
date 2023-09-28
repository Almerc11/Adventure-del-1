import java.util.ArrayList;

public class Player {
    Room currentRoom;
    ArrayList<Item> inventory;
    public Player(Map map){
        this.currentRoom = map.getStartRoom();
        inventory = new ArrayList<>();
    }

    public void playerChoices(String userChoice){
        UserInterface UI = new UserInterface();

        if (userChoice.contains("go north")) {
            if (currentRoom.getNorth() != null) {
                UI.giveNorthDirectionMessage();
                this.currentRoom = currentRoom.getNorth();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userChoice.contains("go east")) {
            if (currentRoom.getEast() != null) {
                UI.giveEastDirectionMessage();
                this.currentRoom = currentRoom.getEast();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userChoice.contains("go west")) {
            if (currentRoom.getWest() != null) {
                UI.giveWestDirectionMessage();
                this.currentRoom = currentRoom.getWest();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userChoice.contains("go south")) {
            if (currentRoom.getSouth() != null) {
                UI.giveSouthDirectionMessage();
                this.currentRoom = currentRoom.getSouth();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if(userChoice.contains("look")){
            UI.lookForDoors(currentRoom);
        } else if(userChoice.contains("take")){

            if(!currentRoom.getItemList().isEmpty()){
                Item item = currentRoom.getItemList().get(0);
                addItemToInventory(item);
                UI.takeItem(currentRoom.getItemList(), item);
                currentRoom.getItemList().remove(0);
            } else {
                UI.noItemsLeftError();
            }
        } else if(userChoice.contains("show")){
            if(!inventory.isEmpty()){
                UI.showInventoryItems(inventory);
            } else {
                UI.removeItemError(inventory);
            }
        } else if(userChoice.contains("help")){
            UI.help();
        }
       /* else if(userChoice.contains("drop")){
            int count = 0;
            for(Item item : inventory) {
                count++;
                int playerChoice = UI.whatItemToRemove(inventory);
                if (inventory.get(count) == inventory.get(playerChoice)) {
                    Item itemAddedBackInRoom = inventory.get(playerChoice);
                    UI.removeItem(inventory.get(count));
                    inventory.remove(count);
                    currentRoom.getItemList().add(itemAddedBackInRoom);
                } else if (inventory.get(count) != inventory.get(playerChoice)) {
                    UI.removeItemError();
                } else if (inventory.isEmpty()) {
                    UI.noItemsLeftError();
                }
            }
        } */
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }
}
