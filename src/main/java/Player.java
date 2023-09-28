import java.util.ArrayList;
import java.util.List;

public class Player {
    Room currentRoom;
    private List<Item> inventory;
    public Player(){
        Map map = new Map();
        this.currentRoom = map.getStartRoom();
        this.inventory = new ArrayList<>();
    }

    public void changeDirection(String userDirection){
        UserInterface UI = new UserInterface();

        if (userDirection.contains("Go north")) {
            if (currentRoom.getNorth() != null) {
                UI.giveNorthDirectionMessage();
                this.currentRoom = currentRoom.getNorth();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userDirection.contains("Go east")) {
            if (currentRoom.getEast() != null) {
                UI.giveEastDirectionMessage();
                this.currentRoom = currentRoom.getEast();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userDirection.contains("Go west")) {
            if (currentRoom.getWest() != null) {
                UI.giveWestDirectionMessage();
                this.currentRoom = currentRoom.getWest();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        } else if (userDirection.contains("Go south")) {
            if (currentRoom.getSouth() != null) {
                UI.giveSouthDirectionMessage();
                this.currentRoom = currentRoom.getSouth();
            } else {
                UI.giveErrorDirectionsMessage();
            }
        }
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
    // Tilføj en genstand til spillerens inventar
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    // Fjern en genstand fra spillerens inventar
    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    // Hent spillerens inventar
    public List<Item> getInventory() {
        return inventory;
    }
}

