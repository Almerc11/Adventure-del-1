public class Adventure {

    public Adventure() {
    }

    public void play(){
        UserInterface UI = new UserInterface();
        Map map = new Map();
        Player player = new Player(map);
        boolean gameIsRunning = true;

        while(gameIsRunning) {
            if (player.getCurrentRoom() == map.getRoom5()) {
                UI.giveEndMessage(player.getCurrentRoom());
                gameIsRunning = false;
                break;
            } else {
                UI.giveNormalStartMessage(player.getCurrentRoom());
                UI.printItemsInRoom(player.getCurrentRoom());
                UI.userChoices();
            }

            String userChoice = UI.setUserInput().toLowerCase();
            player.playerChoices(userChoice);
        }
    }
}


