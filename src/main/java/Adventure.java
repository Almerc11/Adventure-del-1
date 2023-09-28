public class Adventure {

    public Adventure() {
    }

    public void play(){
        UserInterface UI = new UserInterface();
        Map map = new Map();
        Player player = new Player(map);
        boolean gameIsRunning = true;

        while(gameIsRunning) {
            //player.setCurrentRoom(map.getRoom5());
            if (player.getCurrentRoom() == map.getRoom5()) {
                UI.giveEndMessage(player.getCurrentRoom());
                player.whatever();
                gameIsRunning = false;
            } else {
                UI.giveNormalStartMessage(player.getCurrentRoom());
                player.whatever();
            }

            String userDirection = UI.setUserDirection();
            player.changeDirection(userDirection);
        }
    }
}


