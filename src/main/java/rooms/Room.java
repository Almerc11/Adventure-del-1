package rooms;

public class Room {
    private String direction;
    private String name;
    private Room east;
    private Room west;
    private Room south;
    private Room north;



    public Room(String name, String direction) {
        this.direction = direction;
        this.name = name;
        this.east = null;
        this.west = null;
        this.north = null;
        this.south = null;



    }

    public String getDirection() {
        return direction;
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
}
