import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
    private final String description;
    private final String name;
    private Room east;
    private Room west;
    private Room south;
    private Room north;
    private ArrayList<Item> itemList;



    public Room(String name, String description) {
        this.description = description;
        this.name = name;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;
        this.itemList = new ArrayList<>();
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
    public void addItem(Item item){
        itemList.add(item);
    }
    public ArrayList<Item> getItemList(){
        return itemList;
    }

}
