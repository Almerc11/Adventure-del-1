import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Adventure adventure;

    public Player(Adventure adventure) {
        this.adventure = adventure;
        this.inventory = new ArrayList<>();
    }

    public void createCurrentRoom(){
        this.currentRoom = adventure.getStartRoomFromMap();
    }

    public void playerChoices(Adventure adventure ,String userChoice) {

        playUserDirections(adventure, userChoice);

        playUserInventoryManagement(adventure, userChoice);

        givePlayerHelp(adventure, userChoice);

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

    public void playUserDirections(Adventure adventure, String userChoice) {
        if (userChoice.contains("go north")) {
            if (currentRoom.getNorth() != null) {
                adventure.giveNorthMessageFromUI();
                this.currentRoom = currentRoom.getNorth();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go east")) {
            if (currentRoom.getEast() != null) {
                adventure.giveEastMessageFromUI();
                this.currentRoom = currentRoom.getEast();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go west")) {
            if (currentRoom.getWest() != null) {
                adventure.giveWestMessageFromUI();
                this.currentRoom = currentRoom.getWest();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go south")) {
            if (currentRoom.getSouth() != null) {
                adventure.giveSouthMessageFromUI();
                this.currentRoom = currentRoom.getSouth();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        }
    }

    public void playUserInventoryManagement(Adventure adventure, String userChoice) {
        if (userChoice.contains("look")) {
            searchForItems();
            lookForDoors();
        } else if (userChoice.contains("take")) {
            if (!currentRoom.getItemList().isEmpty()) {
                String itemName = currentRoom.getItemList().get(0).getName();
                addItemToInventory(currentRoom.getItemList().get(0));
                adventure.giveTakeItemMessageFromUI(currentRoom.getItemList(), itemName);
                currentRoom.getItemList().remove(0);
            } else {
                adventure.noItemsInRoomErrorFromUI();
            }
        } else if (userChoice.contains("show")) {
            if (!inventory.isEmpty()) {
                adventure.showInventoryMessageFromUI(inventory);
            } else {
                adventure.ItemErrorFromUI(inventory);
            }
        }
    }
    public void givePlayerHelp(Adventure adventure, String userChoice){
        if (userChoice.contains("help")) {
            adventure.helpFromUI();
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
    public void lookForDoors(){
        if(currentRoom.getNorth() != null){
            adventure.getLookForNorthFromUI();
        }
        if(currentRoom.getSouth() != null){
            adventure.getLookForSouthFromUI();
        }
        if(currentRoom.getEast() != null){
            adventure.getLookForEastFromUI();
        }
        if(currentRoom.getWest() != null){
            adventure.getLookForWestFromUI();
        }
    }
}
