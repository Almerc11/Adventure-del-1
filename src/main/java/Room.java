import items.*;

import java.util.ArrayList;

public class Room {
    private final String description;
    private final String name;
    private Room east;
    private Room west;
    private Room south;
    private Room north;
    private ArrayList<Item> itemList;
    private ArrayList<Enemy> enemies;




    public Room(String name, String description) {
        this.description = description;
        this.name = name;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;
        this.itemList = new ArrayList<>();
        this.enemies = new ArrayList<>();

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public void setWest(Room west){
        this.west = west;
    }

    public void setSouth(Room south){
        this.south = south;
    }

    public void setNorth(Room north){
        this.north = north;
    }
    public Room getNorth(){
        return north;
    }
    public Room getSouth(){
        return south;
    }
    public Room getEast(){
        return east;
    }
    public Room getWest(){
        return west;
    }
    public Item createItem(String name, String description){
        Item item = new Item(name, description);
        return item;
    }

    public Weapon createMeleeWeapon(String name, String description, int damage, double damageRange){
        Weapon meleeWeapon = new MeleeWeapon(name, description, damage, damageRange);
        return meleeWeapon;
    }

    public Weapon createRangedWeapon(String name, String description, int damage, double damageRange, int ammo){
        Weapon rangedWeapon = new RangedWeapon(name, description, damage, damageRange, ammo);
        return rangedWeapon;
    }

    public Item createFood(String name, String description, int healAddition){
        Food food = new Food(name, description, healAddition);
        return food;
    }

    public void addItem(Item item){
        itemList.add(item);
    }
    public ArrayList<Item> getItemList(){
        return itemList;
    }

    public Enemy createEnemy(String name, String description, int health, Weapon enemyEquippedWeapon){
        Enemy enemy = new Enemy(name, description, health, enemyEquippedWeapon);
        return enemy;
    }
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
    public ArrayList<Enemy> getEnemyList(){
        return enemies;
    }

    public Enemy getEnemyInList(){
        Enemy enemyToBeReturned = null;
        for(Enemy enemy : enemies){
            enemyToBeReturned = enemy;
        }
        return enemyToBeReturned;
    }
}