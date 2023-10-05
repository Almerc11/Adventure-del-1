import java.util.*;

public class Map {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;

    public Map(){
        createMap();
    }

    public void createMap(){
        room1 = new Room("Room 1", "A room with no distinct features, except for two doors.");
        room2 = new Room("Room 2", "A room with a strange looking woman in the middle, black hair. Open, dead eyes looking at the ground. Best not to disturb her. There are two doors next to her");
        room3 = new Room("Room 3", "A room with a worried looking wolf, it cant find it's pack. It looks to you with worried eyes. There are two doors in this room");
        room4 = new Room("Room 4", "A room with a floating laughing head. Just the head. There are two doors in this room.");
        room5 = new Room("Room 5", "A forrest full of bird singing, and a path, taking you forward.");
        room6 = new Room("Room 6", "A dark room, with a single candle in the middle. The walls show shadows on them. You are not alone. There are two doors in this room.");
        room7 = new Room("Room 7", "A room full of water, and a little toy boat in the middle. A child must have lost it. There are two doors in this room.");
        room8 = new Room("Room 8", "A room with a woman, beautifull, black hair, brown eyes. She points you in a direction, there are three rooms in this room.");
        room9 = new Room("Room 9", "A room a strange looking man, horns, red skin, wide smile with open eyes. He urges you to come to him, there are two doors in this room.");

        room1.setEast(room2);
        room1.setSouth(room4);
        Item crystal = room1.createItem("Crystal", "A crystal that glows red");
        room1.addItem(crystal);
        room1.addItem(new Food("Elixsir", "Drink", 25));

        room2.setWest(room1);
        room2.setEast(room3);
        room2.addItem(room1.createItem("Sword", "A golden sword with diamonds on the shaft"));
        room2.addItem(room1.createItem("Bread", "A piece of luke warm bread"));
        room2.addItem(new Food("Poison", "Drink", -30));

        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(room3.createItem("Torch", "A torch giving light"));
        room3.addItem(room3.createItem("Key", "A glowing key"));
        room3.addItem(room3.createItem("A thing", "Just a thing"));

        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.addItem(new Food("CandyBar", "Food", 15));

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public Room getStartRoom(){
        Room startRoom = room1;
        return startRoom;
    }

    public Room getRoom5(){
        return room5;
    }
}
