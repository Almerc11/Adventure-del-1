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
            } else {
                UI.giveNormalStartMessage(player.getCurrentRoom());
                UI.printItemsInRoom(player.getCurrentRoom());
                UI.userChoices();

                UI.handleUserInput(player, player.getCurrentRoom());

                UI.displayInventory(player.getInventory());
            }

            String userDirection = UI.setUserDirection();
            player.changeDirection(userDirection);
        }
    }
}


