import rooms.Room;


public class Adventure {

    public Adventure() {
    }

    public void play(){
        UserInterface UI = new UserInterface();
        Player player = new Player();
        Map map = new Map();
        boolean gameIsRunning = true;

        do {
            if (player.getCurrentRoom() == map.getRoom5()) {
                UI.giveEndMessage(player.getCurrentRoom());
                gameIsRunning = false;
                break;
            } else {
                UI.giveNormalStartMessage(player.getCurrentRoom());
            }

            String userDirection = UI.setUserDirection();
            player.changeDirection(userDirection);

        } while(gameIsRunning);
    }
}


