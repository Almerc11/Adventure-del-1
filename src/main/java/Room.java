import java.util.ArrayList;

public class Room {
    private final String description;
    private final String name;
    private Room east;
    private Room west;
    private Room south;
    private Room north;
    private Item item;


    public Room(String name, String description) {
        this.description = description;
        this.name = name;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public void addItems() {
        ArrayList<Item> itemList =  new ArrayList<>();
        Item item1 = new Item("Food");
        itemList.add(item1);

        Item item2 = new Item("Lantern");
        itemList.add(item2);

        Item item3 = new Item("Book");
        itemList.add(item3);

        Item item4 = new Item("Map");
        itemList.add(item4);

        Item item5 = new Item("Sword");
        itemList.add(item5);

        Item item6 = new Item("Coin");
        itemList.add(item5);

        Item item7 = new Item("Necklace");
        itemList.add(item5);

        Item item8 = new Item("Crystal Ball");
        itemList.add(item5);




    }
    public void addItem(Item item) {
        // Implementer logikken for at tilføje genstanden til rummet her
    }

}

