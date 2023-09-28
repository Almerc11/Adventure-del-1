public class Player {
    Room currentRoom;
    public Player(Map map){
        this.currentRoom = map.getStartRoom();
    }

    public void changeDirection(String userDirection){
        UserInterface UI = new UserInterface();

        if (userDirection.contains("Go north")) {
            if (currentRoom.getNorth() != null) {
                UI.giveNorthDirectionMessage();
                this.currentRoom = currentRoom.getNorth();
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

    public void whatever(){
        System.out.println(currentRoom.getName());
    }
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
}
