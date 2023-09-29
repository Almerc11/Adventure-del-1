public class Adventure {

    UserInterface UI = new UserInterface();
    Map map = new Map();
    public Adventure() {
    }

    public void play(){
        Player player = new Player();
        boolean gameIsRunning = true;
        while(gameIsRunning) {
            UI.giveNormalStartMessage(player.getStartRoomName(), player.getStartRoomDescription());
            UI.printItemsInRoom(player.getCurrentRoom());
            UI.userChoices();
            String userChoice = UI.setUserInput().toLowerCase();
            player.playerChoices(userChoice);
        }
    }
    public Room getStartRoomFromMap(){
        return map.getStartRoom();
    }

    public void giveNoItemMessageFromUI(){
        UI.noItems();
    }

    public void giveItemPrintFromUI(){
        UI.printItemsInRoom();
    }
}


