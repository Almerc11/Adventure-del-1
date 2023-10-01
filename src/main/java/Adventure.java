import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adventure {

    UserInterface UI = new UserInterface();
    Map map;
    public Adventure() {
        map = new Map();
    }

    public void play(){
        map = new Map();
        Player player = new Player(this);
        player.createCurrentRoom();
        boolean gameIsRunning = true;
        while(gameIsRunning) {
            if(player.getCurrentRoom() == map.getRoom5()){
                UI.giveEndMessage(player.getCurrentRoom().getDescription());
                gameIsRunning = false;
                break;
            } else {
                UI.giveNormalStartMessage(player.getStartRoomName(), player.getStartRoomDescription());
                UI.printItemsInRoom(player.searchForItemsInCurrentRoom());
                UI.userChoices();
                String userChoice = UI.setUserInput().toLowerCase();
                player.playerChoices(this, userChoice);
            }
        }
    }
    public Room getStartRoomFromMap(){
        return map.getStartRoom();
    }

    public void giveNoItemMessageFromUI(){
        UI.noItems();
    }

    public void giveItemPrintFromUI(String itemName){
        UI.printItemsInRoom(itemName);
    }

    public void giveNorthMessageFromUI(){
        UI.giveNorthDirectionMessage();
    }
    public void giveEastMessageFromUI(){
        UI.giveEastDirectionMessage();
    }
    public void giveWestMessageFromUI(){
        UI.giveWestDirectionMessage();
    }
    public void giveSouthMessageFromUI(){
        UI.giveSouthDirectionMessage();
    }

    public void giveErrorMessageFromUI(){
        UI.giveErrorDirectionsMessage();
    }
    public void helpFromUI(){
        UI.help();
    }

    public void giveTakeItemMessageFromUI(ArrayList<Item> inventory, String itemName){
        UI.takeItem(inventory, itemName);
    }
    public void showInventoryMessageFromUI(ArrayList<Item> inventory){
        UI.showInventoryItems(inventory);
    }
    public void ItemErrorFromUI(ArrayList<Item> inventory){
        UI.removeItemError(inventory);
    }

    public void getLookForNorthFromUI(){
        UI.lookForNorth();
    }
    public void getLookForSouthFromUI(){
        UI.lookForSouth();
    }
    public void getLookForEastFromUI(){
        UI.lookForEast();
    }
    public void getLookForWestFromUI(){
        UI.lookForWest();
    }
    public void noItemsInRoomErrorFromUI(){
        UI.noItemsLeftError();
    }


}


