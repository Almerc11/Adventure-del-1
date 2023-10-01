import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    Adventure adventure;

    public Player(Adventure adventure) {
        this.adventure = adventure;
        this.inventory = new ArrayList<>();
    }

    public void createCurrentRoom(){
        this.currentRoom = adventure.getStartRoomFromMap();
    }

    public void playerChoices(String userChoice) {
        UserInterface UI = new UserInterface();

        playUserDirections(UI, userChoice);

        playUserInventoryManagement(UI, userChoice);

        givePlayerHelp(UI, userChoice);

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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void playUserDirections(UserInterface UI, String userChoice) {
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
        }
    }

    public void playUserInventoryManagement(UserInterface UI, String userChoice) {
        if (userChoice.contains("look")) {
            searchForItems();
        } else if (userChoice.contains("take")) {

            if (!currentRoom.getItemList().isEmpty()) {
                Item item = currentRoom.getItemList().get(0);
                addItemToInventory(item);
                UI.takeItem(currentRoom.getItemList(), item);
                currentRoom.getItemList().remove(0);
            } else {
                UI.noItemsLeftError();
            }
        } else if (userChoice.contains("show")) {
            if (!inventory.isEmpty()) {
                UI.showInventoryItems(inventory);
            } else {
                UI.removeItemError(inventory);
            }
        }
    }
    public void givePlayerHelp(UserInterface UI, String userChoice){
        if (userChoice.contains("help")) {
            UI.help();
        }
    }
    public String getStartRoomName(){
        return currentRoom.getName();
    }
    public String getStartRoomDescription(){
        return currentRoom.getDescription();
    }
    public void searchForItems(){
        if(!currentRoom.getItemList().isEmpty()){
            for(Item item : currentRoom.getItemList()){
                adventure.giveItemPrintFromUI(item.getName());
            }
        } else {
            adventure.giveNoItemMessageFromUI();
        }
    }

    public String searchForItemsInCurrentRoom(){
        if(!currentRoom.getItemList().isEmpty()){
            for(Item item : currentRoom.getItemList()){
                return item.getName();
            }
        } else {
             return "no items found";
        }
        return "";
    }
}
