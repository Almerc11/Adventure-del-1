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
                UI.giveEndMessage(player.getCurrentRoom());
                gameIsRunning = false;
                break;
            } else {
                UI.giveNormalStartMessage(player.getStartRoomName(), player.getStartRoomDescription());
                UI.printItemsInRoom(player.searchForItemsInCurrentRoom());
                UI.userChoices();
                String userChoice = UI.setUserInput().toLowerCase();
                player.playerChoices(userChoice);
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
}


