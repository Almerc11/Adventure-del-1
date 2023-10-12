import items.*;

import java.util.*;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Adventure adventure;
    private final int fullHealth = 100;
    private int health = fullHealth;
    private boolean exitGame;
    private Weapon equippedWeapon = null;
    private boolean inCombat = false;
    private boolean enemiesInRoom;
    private int fleeAttempts = 3;

    public Player(Adventure adventure) {
        this.adventure = adventure;
        this.inventory = new ArrayList<>();
    }

    public void showInventory() {
        int count = 0;
        for (Item item : inventory) {
            count++;
            adventure.giveShowInventoryFromUI(item.getName(), item.getDescription(), count);
        }
    }

    public void createCurrentRoom() {
        this.currentRoom = adventure.getStartRoomFromMap();
    }

    public void playerChoices(Adventure adventure, String userChoice) {

        playUserDirections(adventure, userChoice);

        playUserInventoryManagement(adventure, userChoice);

        removeItemFromInventory(userChoice, adventure);

        givePlayerHelp(adventure, userChoice);

        setExitGame(userChoice);

        showHealth(userChoice);

        eat(userChoice);

        equipWeapon(userChoice);

        if (!currentRoom.getEnemyList().isEmpty()) {
            combat(userChoice);
        } else {
            combat(userChoice);
        }

    }

    public boolean setEnemiesInRoom() {
        if (!currentRoom.getEnemyList().isEmpty()) {
            enemiesInRoom = true;
        }
        return enemiesInRoom;
    }

    public void printEnemies() {
        for (Enemy enemy : currentRoom.getEnemyList()) {
            adventure.giveEnemiesMessageFromUI(enemy.getName(), enemy.getDescription());
        }
    }

    public void showHealth(String userChoice) {
        if (userChoice.equals("health")) {
            adventure.giveHealthStatusMessageFromUI(health);
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setExitGame(String userChoice) {
        this.exitGame = false;
        if (userChoice.contains("exit")) {
            exitGame = true;
        }
    }


    public boolean getExitGame() {
        return exitGame;
    }

    public boolean getInCombatIndication() {
        return inCombat;
    }

    public void setCombat() {
        if (inCombat) {
            inCombat = false;
        } else {
            inCombat = true;
        }
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void playerHealthDecrese(int damage) {
        this.health = health - damage;
    }

    public void removeItemFromInventory(String userChoice, Adventure adventure) {
        if (userChoice.contains("drop")) {
            if (!inventory.isEmpty()) {
                adventure.printRemovableItemListFromUI();
                for (Item item : inventory) {
                    adventure.giveShowItemsFromUI(item.getName(), item.getDescription());
                }
                String itemToBeRemoved = adventure.giveUserChoiceGeneralFromUI().toLowerCase();
                for (Item item : inventory) {
                    if (item.getName().toLowerCase().equals(itemToBeRemoved)) {
                        inventory.remove(item);
                        currentRoom.getItemList().add(item);
                        adventure.giveRemovedItemMessageFromUI(item.getName());
                        break;
                    }
                }
            } else {
                adventure.giveNoItemsErrorFromUI();
            }
        }
    }

    public void eat(String userChoice) {
        Item foodToBeRemoved = null;
        int restoredHealth = 0;
        if (userChoice.equals("eat")) {
            adventure.giveEatMessageFromUI();
            for (Item item : inventory) {
                if (item instanceof Food) {
                    adventure.giveSecondEatMessageFromUI(item.getName(), item.getDescription(), ((Food) item).getHealthAddition());
                }
            }

            String foodToBeEaten = adventure.giveUserChoiceGeneralFromUI();
            if (health < fullHealth) {
                for (Item item : inventory) {
                    if (item instanceof Food) {
                        if (item.getName().toLowerCase().equals(foodToBeEaten)) {

                            if(health < fullHealth){
                                restoredHealth = ((Food) item).getHealthAddition() + health;
                                health = restoredHealth;
                            }
                            if(restoredHealth > fullHealth){
                                health = fullHealth;
                            }
                            foodToBeRemoved = item;
                            break;
                        }
                    }
                }
                if (foodToBeRemoved != null) {
                    inventory.remove(foodToBeRemoved);
                }
            } else {
                System.out.println("You are already at full health!");
            }
        }
    }

    public void playUserDirections(Adventure adventure, String userChoice) {
        if (userChoice.contains("go north")) {
            if (currentRoom.getNorth() != null) {
                adventure.giveNorthMessageFromUI();
                this.currentRoom = currentRoom.getNorth();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go east")) {
            if (currentRoom.getEast() != null) {
                adventure.giveEastMessageFromUI();
                this.currentRoom = currentRoom.getEast();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go west")) {
            if (currentRoom.getWest() != null) {
                adventure.giveWestMessageFromUI();
                this.currentRoom = currentRoom.getWest();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        } else if (userChoice.contains("go south")) {
            if (currentRoom.getSouth() != null) {
                adventure.giveSouthMessageFromUI();
                this.currentRoom = currentRoom.getSouth();
            } else {
                adventure.giveErrorMessageFromUI();
            }
        }
    }

    public void equipWeapon(String userChoice) {
        if (userChoice.equals("equip")) {
            if (!inventory.isEmpty()) {
                for (Item item : inventory) {
                    if (item instanceof Weapon) {
                        adventure.printWeaponsInInventoryMessageFromUI(item.getName(), item.getDescription(), ((Weapon) item).getDamage());
                    }
                }
                String weaponToBeEquipped = adventure.giveUserChoiceGeneralFromUI();
                for (Item item : inventory) {
                    if (item instanceof Weapon) {
                        if (item.getName().toLowerCase().equals(weaponToBeEquipped)) {
                            equippedWeapon = (Weapon) item;
                            adventure.giveEquipMessageFromUI(equippedWeapon.getName());
                            break;
                        }
                    }
                }
            } else {
                adventure.giveEquipMessageErrorFromUI();
            }
        }
    }

    public void attack() {
        if (equippedWeapon != null) {
            if (equippedWeapon instanceof MeleeWeapon) {
                adventure.giveAttackMessageFromUI(equippedWeapon.getDamage(), ((MeleeWeapon) equippedWeapon).getDamageRange());
            } else if (equippedWeapon instanceof RangedWeapon) {
                adventure.giveAttackMessageFromUI(equippedWeapon.getDamage(), ((RangedWeapon) equippedWeapon).getDamageRange());
            }
        } else {
            adventure.giveAttackErrorFromUI();
        }
    }

    public void playUserInventoryManagement(Adventure adventure, String userChoice) {
        if (userChoice.contains("look")) {
            searchForItems();
            lookForDoors();
        } else if (userChoice.contains("take")) {
            if (!currentRoom.getItemList().isEmpty()) {
                String itemName = currentRoom.getItemList().get(0).getName();
                addItemToInventory(currentRoom.getItemList().get(0));
                adventure.giveTakeItemMessageFromUI(currentRoom.getItemList(), itemName);
                currentRoom.getItemList().remove(0);
            } else {
                adventure.noItemsInRoomErrorFromUI();
            }
        } else if (userChoice.contains("show")) {
            if (!inventory.isEmpty()) {
                adventure.giveFirstShowInventoryMessageFromUI();
                showInventory();
            } else {
                adventure.ItemErrorFromUI(inventory);
            }
        }
    }

    public void givePlayerHelp(Adventure adventure, String userChoice) {
        if (userChoice.contains("help")) {
            adventure.helpFromUI();
        }
    }

    public String getStartRoomName() {
        return currentRoom.getName();
    }

    public String getStartRoomDescription() {
        return currentRoom.getDescription();
    }

    public void searchForItems() {
        if (!currentRoom.getItemList().isEmpty()) {
            for (Item item : currentRoom.getItemList()) {
                adventure.giveItemPrintFromUI(item.getName());
            }
        } else {
            adventure.giveNoItemMessageFromUI();
        }
    }

    public void searchForItemsInCurrentRoom() {
        if (!currentRoom.getItemList().isEmpty()) {
            for (Item item : currentRoom.getItemList()) {
                adventure.giveItemPrintFromUI(item.getName());
            }
        } else {
            adventure.noItemsInRoomErrorFromUI();
        }
    }

    public void lookForDoors() {
        if (currentRoom.getNorth() != null) {
            adventure.getLookForNorthFromUI();
        }
        if (currentRoom.getSouth() != null) {
            adventure.getLookForSouthFromUI();
        }
        if (currentRoom.getEast() != null) {
            adventure.getLookForEastFromUI();
        }
        if (currentRoom.getWest() != null) {
            adventure.getLookForWestFromUI();
        }



            }
    public void combat(String userChoice) {
        if (userChoice.equals("combat")) {
            if (equippedWeapon != null) {
                if (!currentRoom.getEnemyList().isEmpty()) {
                    setCombat();
                } else {
                    attack();
                }
            } else {
                adventure.giveNoWeaponEquippedMessageFromUI();
            }
        }
    }

    public void combatSequence() {
        if (currentRoom.getEnemyInList().getHealth() <= 0) {
            adventure.giveEnemyDefeatedMessageFromUI();
            setCombat();
            currentRoom.addItem(currentRoom.getEnemyInList().getEnemyEquippedWeapon());
            currentRoom.getEnemyList().remove(currentRoom.getEnemyInList());
        } else if (health <= 0) {
            adventure.givePlayerDiedMessageFromUI();
            exitGame = true;
        } else {
            displayEnemyAndPlayerHealth();
            if (equippedWeapon instanceof RangedWeapon) {
                adventure.giveWeaponAmmoCountMessageFromUI(((RangedWeapon) equippedWeapon).getCurrentAmmo());
            }
            String userCombatChoices = adventure.giveUserChoiceGeneralFromUI().toLowerCase();

            if (userCombatChoices.equals("eat")) {
                eat(userCombatChoices);
                enemyAttacks(currentRoom.getEnemyInList());
            } else if (userCombatChoices.equals("attack")) {
                if (equippedWeapon instanceof MeleeWeapon) {
                    playerAttacksWithMelee(currentRoom.getEnemyInList());
                } else if (equippedWeapon instanceof RangedWeapon) {
                    playerAttacksWithRangeWeapon(currentRoom.getEnemyInList());
                }
                enemyAttacks(currentRoom.getEnemyInList());
            } else if (userCombatChoices.equals("reload")) {
                if (equippedWeapon instanceof RangedWeapon) {
                    if (((RangedWeapon) equippedWeapon).getCurrentAmmo() == ((RangedWeapon) equippedWeapon).getmaxAmmo()) {
                        adventure.giveMaxAmmoLoadedMessageFromUI();
                    } else {
                        playerReload();
                        adventure.giveReloadedWeaponMessageFromUI();
                    }
                } else {
                    adventure.givemeleeWeaponCantReloadMessageFromUI();
                }
                enemyAttacks(currentRoom.getEnemyInList());
            } else if (userCombatChoices.equals("flee")) {
                playerFleeAttempt();
            }
        }
    }

    public void displayEnemyAndPlayerHealth() {
        adventure.giveDisplayHealthFromUI(currentRoom.getEnemyInList().getName(), currentRoom.getEnemyInList().getHealth(), health);
    }

    public void playerFleeAttempt() {
        if (fleeAttempts > 0) {
            Random random = new Random();
            int fleeAttempt = random.nextInt(0, 7);
            if (fleeAttempt != 3) {
                adventure.giveAttemptToFleeMessageFromUI();
                this.fleeAttempts--;
                enemyAttacks(currentRoom.getEnemyInList());
            } else {
                adventure.giveFleeSuccessfullMessageFromUI();
                setCombat();
            }
        } else {
            adventure.giveOutOfFleeAttemptsFromUI();
            enemyAttacks(currentRoom.getEnemyInList());
        }
    }

    public void playerAttacksWithMelee(Enemy enemy) {
        Random random = new Random();
        int criticalStrikeChance = random.nextInt(1, 10);
        int weaponDamage = random.nextInt(0, equippedWeapon.getDamage());
        if (criticalStrikeChance > 8) {
            adventure.givePlayerCriticalAttackMessageFromUI();
            weaponDamage = weaponDamage + (equippedWeapon.getDamage() / 2);
        }
        if (weaponDamage == 0) {
            adventure.givePlayerMissedMessageFromUI();
        } else {
            adventure.givePlayerNormalAttackMessageFromUI(weaponDamage, equippedWeapon.getName());
            enemy.enemyHealthDecrease(weaponDamage);
        }
    }

    public void playerReload() {
        ((RangedWeapon) equippedWeapon).reloadAmmo();
    }

    public void playerAttacksWithRangeWeapon(Enemy enemy) {
        if (((RangedWeapon) equippedWeapon).getCurrentAmmo() != 0) {
            Random random = new Random();
            int criticalStrikeChance = random.nextInt(1, 10);
            int weaponDamage = random.nextInt(0, equippedWeapon.getDamage());
            if (criticalStrikeChance > 8) {
                adventure.givePlayerCriticalAttackMessageFromUI();
                weaponDamage = weaponDamage + (equippedWeapon.getDamage() / 2);
            }
            if (weaponDamage == 0) {
                adventure.givePlayerMissedRangedMessageFromUI();
                ((RangedWeapon) equippedWeapon).useAmmo();
            } else {
                adventure.givePlayerNormalRangedAttackMessageFromUI(weaponDamage);
                ((RangedWeapon) equippedWeapon).useAmmo();
                enemy.enemyHealthDecrease(weaponDamage);
            }
        } else {
            adventure.giveReloadMessageFromUI();
        }
    }

    public void enemyAttacks(Enemy enemy) {
        if (enemy.getHealth() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Random random = new Random();
            int criticalStrikeChance = random.nextInt(1, 10);
            int enemyWeaponDamage = random.nextInt(0, enemy.getEnemyEquippedWeapon().getDamage());
            if (criticalStrikeChance > 8) {
                adventure.giveEnemyCriticalAttackMessageFromUI();
                enemyWeaponDamage = enemyWeaponDamage + (enemy.getEnemyEquippedWeapon().getDamage() / 2);
            }
            if (enemyWeaponDamage == 0) {
                adventure.giveEnemyMissedAttackMessageFromUI();
            } else {
                adventure.giveEnemyNormalAttackMessageFromUI(enemyWeaponDamage);
                playerHealthDecrese(enemyWeaponDamage);
            }
        }
    }
}