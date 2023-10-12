import items.Item;
import items.RangedWeapon;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public String setUserInput(){
        String userDirection;
        Scanner input = new Scanner(System.in);
        userDirection = input.nextLine();
        return userDirection;
    }

    public void giveEndMessage(String roomDescription){
        System.out.println(roomDescription);
        System.out.println("Thank you for playing.");
    }
    public void showHealth(int health){
        if(health <= 100 && health >= 80){
            System.out.println("Your health is currently at: " + health + ", you are very healthy!");
        } else if(health <= 80 && health >= 40){
            System.out.println("Your health is currently at: " + health + ", it would be a good idea to eat something!");
        } else if(health >= 1 && health <= 40){
            System.out.println("Your health is currently at: " + health + ", your health is critical! You wont last long.");
        }
    }

    public void giveNormalStartMessage(String roomName, String roomDescription){
        System.out.println("You are currently standing in " + roomName + ", " + roomDescription);
        System.out.println("Inside you see:");
    }
    public void giveNorthDirectionMessage(){
        System.out.println("you choose to go north");
    }

    public void giveSouthDirectionMessage(){
        System.out.println("you choose to go south");

    }

    public void giveEastDirectionMessage(){
        System.out.println("you choose to go east");
    }

    public void giveWestDirectionMessage() {
        System.out.println("You choose to go west");
    }

    public void giveErrorDirectionsMessage(){
        System.out.println("You can't go that way");
    }

    public void printItemsInRoom(String itemNameFromRoom){
        System.out.println("A " + itemNameFromRoom);
    }

    public void noItems(){
        System.out.println("There are no items in this room..");
    }
    public void takeItem(ArrayList<Item> listOfItems, String itemName){
        if(!listOfItems.isEmpty()){
            System.out.println("You took the " + itemName);
            System.out.println();
        } else {
            System.out.println("There are no items left to take in this room.");
        }
    }

    public void firstShowInventoryMessage(){
        System.out.println("Your inventory contains: ");
    }

    public void showInventoryItems(String itemName, String itemDescribtion, int count){
        System.out.println(count + ". " + itemName + ", " + itemDescribtion);
    }

    public void noItemsError(){
        System.out.println("Your inventory does not contain any items!");
    }

    public void noItemsLeftError(){
        System.out.println("There are no more items to take in this room!");
    }
    public void lookForNorth(){
        System.out.println("You see a door to the north..");
    }
    public void lookForSouth(){
        System.out.println("You see a door to the south..");
    }
    public void lookForEast(){
        System.out.println("You see a door to the east..");
    }
    public void lookForWest(){
        System.out.println("You see a door to the west..");
    }

    public void removeItem(String itemName){
        System.out.println("You removed the item: " + itemName + " from your inventory.");
    }
    public void userRemoveItemChoice(){
        System.out.println("What item would you like to remove?");
    }

    public String userChoiceGeneral(){
        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine();
        return userChoice;
    }

    public void showItems(String itemName, String itemDescription){
        System.out.println(itemName + ", " + itemDescription);
    }

    public void removeItemError(ArrayList<Item> inventory){
        if(!inventory.isEmpty()){
            System.out.println("Your inventory does not contain the item you want to remove..");
        } else {
            System.out.println("Your inventory does not contain any items..");
        }
    }

    public void help(){
        System.out.println("You can write the following commands: ");
        System.out.println();
        System.out.println("Direction guide:");
        System.out.println();
        System.out.println("Go south: Leads you the direction of south");
        System.out.println("Go north: Leads you the direction of north");
        System.out.println("Go west: Leads you the direction of west");
        System.out.println("Go East: Leads you in the direction of East");
        System.out.println("Look: Looks for nearby doors.");
        System.out.println();
        System.out.println("Player options:");
        System.out.println();
        System.out.println("Take: Takes an item from the inventory.");
        System.out.println("Drop: Drops one item from your inventory.");
        System.out.println("Show: Shows the items currently in your inventory.");
        System.out.println("Eat: Choose to eat an item");
        System.out.println("Equip: Choose to equip an weapon/item");
        System.out.println("Exit: Closes the game.");
        System.out.println();
        System.out.println("Combat mode options");
        System.out.println();
        System.out.println("Attack: Choose to attack an enemy");
        System.out.println("Reload:Choose to reload your current weapon");
        System.out.println("Health: Gives player health status");
        System.out.println("Flee: Gives the player an option to flee");

    }


    public void userChoices( boolean enemiesInRoom){
        if(enemiesInRoom){
            System.out.println("Do you wish to initiate combat?");
        }
        System.out.println("What do you do?");

    }
    public void eatMessage(){
        System.out.println("What item would you like to eat?");
    }
    public void printFoodItems(String foodName, String foodDescribtion, int foodHealthAddition){
        System.out.println("A " + foodName + ", " + foodDescribtion + " (Gives " + foodHealthAddition + "hp)");
    }
    public void noFoodsInInventoryError(){
        System.out.println("You do not have anything to eat.");
    }

    public void attackMessage(double damage, double range){
        System.out.println("You attacked the air with " + damage + " damage" + " with a range of " + range + "m");
    }
    public void attackMessageError(){
        System.out.println("You do not have a weapon equipped!");
    }

    public void equipMessage(String weaponName){
        System.out.println("You have equiped: " + weaponName);
    }
    public void equipWeaponError(){
        System.out.println("You do not have any equippable items in your inventory");
    }
    public void printWeaponsInInventory(String weaponName, String weaponDescription, double weaponDamage){
        System.out.println(weaponName + " " + weaponDescription + " " + weaponDamage + " damage");
    }
    public void printEnemies(String enemyName, String enemyDescription){
        System.out.println("A " + enemyName + ", " +  enemyDescription);
    }

    public void playerCriticalAttackMessage(){
        System.out.println("You attack with a critical strike!");
    }

    public void playerMissedMessage(){
        System.out.println("You missed the enemy");
    }

    public void playerNormalAttackMessage(int damage, String weaponName){
        System.out.println("You swing your "  + weaponName + " with a damage value of: " + damage);
    }

    public void playerNormalAttackRangedMessage(int damage){
        System.out.println("You shoot with a damage value of: " + damage);
    }

    public void playerMissedRangedMessage(){
        System.out.println("Your shot missed the enemy");
    }

    public void reloadMessage(){
        System.out.println("You need to reload your weapon!");
    }
    public void enemyNormalAttackMessage(int damage){
        System.out.println("The enemy attacks with a damage value of: " + damage);
    }
    public void enemyMissedAttackMessage(){
        System.out.println();
        System.out.println("You dodged the enemy's attack");
    }
    public void attemptToFleeMessage(){
        System.out.println("You attempted to flee, but was unsuccesfull");
    }
    public void fleeSuccessfullMessage(){
        System.out.println("You flee the battle");
    }
    public void outOfFleeAttempts(){
        System.out.println("You cannot attempt to flee anymore");
    }
    public void enemyCriticalAttackMessage(){
        System.out.println("Enemy attacks with a critical strike!");
    }

    public void meleeWeaponCantReloadMessage(){
        System.out.println("Your weapon is a melee weapon, and can therefor not be reloaded!");
    }
    public void reloadedWeaponMessage(){
        System.out.println("You reloaded your weapon!");
    }
    public void maxAmmoLoaded(){
        System.out.println("Your weapon already has the max ammo loaded!");
    }
    public void weaponAmmoCountMessage(int ammo){
        System.out.println("Your weapon currently have: " + ammo + " ammo loaded");
    }
    public void playerDiedMessage(){
        System.out.println("You died, game over");
    }
    public void enemyDefeatedMessage(){
        System.out.println("You have defeated the enemy");
    }
    public void noWeaponEquippedMessage(){
        System.out.println("You do not have a weapon equipped");
    }

    public void displayEnemyHealthAndPlayerHealth(String enemyName, int enemyHealth, int playerHealth){
        System.out.println();
        System.out.println(enemyName + ": " + enemyHealth + " || Player: " + playerHealth);
    }

}
