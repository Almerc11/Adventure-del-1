import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Adventure adventure;

    private boolean exitGame;

    public Player(Adventure adventure) {
        this.adventure = adventure;
        this.inventory = new ArrayList<>();
    }

    public void showInventory(){
            int count = 0;
            for(Item item : inventory){
            count++;
            adventure.giveShowInventoryFromUI(item.getName(), item.getDescription(), count);
        }
    }

    public void createCurrentRoom(){
        this.currentRoom = adventure.getStartRoomFromMap();
    }

    public void playerChoices(Adventure adventure ,String userChoice) {

        playUserDirections(adventure, userChoice);

        playUserInventoryManagement(adventure, userChoice);

        removeItemFromInventory(userChoice, adventure);

        givePlayerHelp(adventure, userChoice);

        setExitGame(userChoice);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setExitGame(String userChoice){
        this.exitGame = false;
        if(userChoice.contains("exit")){
            exitGame = true;
        }
    }

    public boolean getExitGame(){
        return exitGame;
    }


    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(String userChoice, Adventure adventure){
        if(userChoice.contains("drop")){
             if(!inventory.isEmpty()){
                 adventure.printRemovableItemListFromUI();
                 for(Item item : inventory){
                     adventure.giveShowItemsFromUI(item.getName(), item.getDescription());
                 }
                 String itemToBeRemoved = adventure.itemToBeRemovedMessageFromUI().toLowerCase();
                 boolean removed = false;
                 for(Item item : inventory){
                    if(item.getName().toLowerCase().equals(itemToBeRemoved)){
                    inventory.remove(item);
                    currentRoom.getItemList().add(item);
                    adventure.giveRemovedItemMessageFromUI(item.getName());
                    removed = true;
                    break;
                    }
                    if(!removed){
                        System.out.println("no");
                    }
                }
             } else {
                 System.out.println("No");
             }
        }
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
                adventure.giveFirstShowInventoryMessageFromUI();
                showInventory();
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

    public void searchForItemsInCurrentRoom(){
        if(!currentRoom.getItemList().isEmpty()){
            for(Item item : currentRoom.getItemList()){
                adventure.giveItemPrintFromUI(item.getName());
            }
        } else {
             adventure.noItemsInRoomErrorFromUI();
        }
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
