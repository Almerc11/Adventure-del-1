import items.Item;

import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Adventure {
    private UserInterface UI = new UserInterface();
    private Map map;
    private Clip backgroundMusicClip;
    public Adventure() {
        map = new Map();
    }

    public void play(){
        map = new Map();
        Player player = new Player(this);
        player.createCurrentRoom();
        boolean gameIsRunning = true;
        //backGroundMusic("C:\\Users\\emila\\Intellij projects\\Adventure-del-1\\src\\main\\java\\music\\backGroundMusic.wav");
        backGroundMusic("C:\\Users\\emila\\IntelliJ projects\\KEA\\Første Semester\\Adventure-del-1\\src\\main\\java\\music\\backGroundMusic.wav");
        while(gameIsRunning) {
            if(player.getCurrentRoom() == map.getRoom5()){
                UI.giveEndMessage(player.getCurrentRoom().getDescription());
                gameIsRunning = false;
            } else if(player.getExitGame() == true){
                gameIsRunning = false;
            } else if(player.getInCombatIndication()){
                player.combatSequence();
            } else {
                UI.giveNormalStartMessage(player.getStartRoomName(), player.getStartRoomDescription());
                player.printEnemies();
                player.searchForItemsInCurrentRoom();
                UI.userChoices(player.setEnemiesInRoom());
                String userChoice = UI.setUserInput().toLowerCase();
                player.playerChoices(this, userChoice);
            }
        }
    }

    public void backGroundMusic(String musicFilePath){
        try{
            File audioFile = new File(musicFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioInputStream);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundMusicClip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
        }
    }

    public Room getStartRoomFromMap(){
        return map.getStartRoom();
    }

    // Print statements from UI
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
    public void showInventoryMessageFromUI(String itemName, String itemDescribtion, int count){
        UI.showInventoryItems(itemName, itemDescribtion, count);
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
    public void giveShowItemsFromUI(String itemName, String itemDescription){
        UI.showItems(itemName, itemDescription);
    }
    public String giveUserChoiceGeneralFromUI(){
        return UI.userChoiceGeneral().toLowerCase();
    }

    public void printRemovableItemListFromUI(){
        UI.userRemoveItemChoice();
    }

    public void giveRemovedItemMessageFromUI(String itemName){
        UI.removeItem(itemName);
    }
    public void giveFirstShowInventoryMessageFromUI(){
        UI.firstShowInventoryMessage();
    }
    public void giveShowInventoryFromUI(String itemName, String itemDescribtion, int count){
        UI.showInventoryItems(itemName, itemDescribtion, count);
    }
    public void giveNoItemsErrorFromUI(){
        UI.noItemsError();
    }
    public void giveHealthStatusMessageFromUI(int health){
        UI.showHealth(health);
    }
    public void giveEatMessageFromUI(){
        UI.eatMessage();
    }
    public void giveSecondEatMessageFromUI(String foodName, String foodDescribtion, int foodHealthAddition){
        UI.printFoodItems(foodName, foodDescribtion, foodHealthAddition);
    }
    public void giveNoFoodErrorFromUI(){
        UI.noFoodsInInventoryError();
    }
    public void giveAttackMessageFromUI(double damage, double range){
        UI.attackMessage(damage, range);
    }
    public void giveAttackErrorFromUI(){
        UI.attackMessageError();
    }
    public void giveEquipMessageFromUI(String weaponName){
        UI.equipMessage(weaponName);
    }
    public void giveEquipMessageErrorFromUI(){
        UI.equipWeaponError();
    }
    public void printWeaponsInInventoryMessageFromUI(String weaponName, String weaponDescription, double weaponDamage){
        UI.printWeaponsInInventory(weaponName, weaponDescription, weaponDamage);
    }

    public void giveEnemiesMessageFromUI(String enemyName, String enemyDescription){
        UI.printEnemies(enemyName, enemyDescription);
    }

    public void givePlayerCriticalAttackMessageFromUI(){
        UI.playerCriticalAttackMessage();
    }

    public void givePlayerMissedMessageFromUI(){
        UI.playerMissedMessage();
    }

    public void givePlayerNormalAttackMessageFromUI(int damage, String weaponName){
        UI.playerNormalAttackMessage(damage, weaponName);
    }

    public void givePlayerNormalRangedAttackMessageFromUI(int damage){
        UI.playerNormalAttackRangedMessage(damage);
    }

    public void givePlayerMissedRangedMessageFromUI(){
        UI.playerMissedRangedMessage();
    }

    public void giveReloadMessageFromUI(){
        UI.reloadMessage();
    }
    public void giveEnemyNormalAttackMessageFromUI(int damage){
        UI.enemyNormalAttackMessage(damage);
    }
    public void giveEnemyMissedAttackMessageFromUI(){
        UI.enemyMissedAttackMessage();
    }
    public void giveEnemyCriticalAttackMessageFromUI(){
        UI.enemyCriticalAttackMessage();
    }
    public void giveFleeSuccessfullMessageFromUI(){
        UI.fleeSuccessfullMessage();
    }
    public void giveAttemptToFleeMessageFromUI(){
        UI.attemptToFleeMessage();
    }
    public void giveOutOfFleeAttemptsFromUI(){
        UI.outOfFleeAttempts();
    }
    public void givemeleeWeaponCantReloadMessageFromUI(){
        UI.meleeWeaponCantReloadMessage();
    }
    public void giveReloadedWeaponMessageFromUI(){
        UI.reloadedWeaponMessage();
    }
    public void giveMaxAmmoLoadedMessageFromUI(){
        UI.maxAmmoLoaded();
    }
    public void giveWeaponAmmoCountMessageFromUI(int ammo){
        UI.weaponAmmoCountMessage(ammo);
    }
    public void givePlayerDiedMessageFromUI(){
        UI.playerDiedMessage();
    }
    public void giveEnemyDefeatedMessageFromUI(){
        UI.enemyDefeatedMessage();
    }
    public void giveNoWeaponEquippedMessageFromUI(){
        UI.noWeaponEquippedMessage();
    }
    public void giveDisplayHealthFromUI(String enemyName, int enemyHealth, int playerHealth){
        UI.displayEnemyHealthAndPlayerHealth(enemyName, enemyHealth, playerHealth);
    }


}


