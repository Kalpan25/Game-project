

public class World {
    // Builds the game world.   
    // Returns the room the player starts in.
    public static Room buildWorld() {
    Room BruceHALL201 = new Room("You are in the 201.");
    Room BruceHALL202 = new Room("You are in the 202.");
    Room BruceHALL203 = new Room("You are in the 203.");
    Room janitorCloset = new Room("You are in the janitor closet.");
    Room Elevetor = new Room("You are in the elevator.");
    Room FirstFloor = new Room("You are on the first floor.");
    Room RestRoom = new Room("You are in the restroom.");

    item keycard = new item("keycard","You found a keycard!");
    item smallkey = new item("key","You found a small key!");
    item knife = new item("knife","You found a knife!");
    item kit = new item("first aid kit","You found a first aid kit!");
    item bat = new item("baseball bat","You found a baseball bat!");
    item bag = new item("bag","You found a bag!");
    Combination combination = new Combination("combination","You found a combination lock!");
    Safe safe = new Safe("safe","You found a safe!");
    
    BruceHALL201.addExit(BruceHALL202, 'w');
    BruceHALL201.addExit(BruceHALL203, 'e');
    BruceHALL201.additem("keycard", keycard);
    BruceHALL201.addExit(janitorCloset, 'n');

    BruceHALL202.addExit(RestRoom, 's');
    RestRoom.additem("first aid kit",kit);
    RestRoom.additem("Baseball bat", bat);
    RestRoom.additem("bag",bag);
    BruceHALL202.addExit(BruceHALL201, 'e'); 

    BruceHALL203.addExit(Elevetor, 's');
    BruceHALL203.addExit(BruceHALL201, 'w');

    Elevetor.addExit(FirstFloor, 'd');
    RestRoom.addExit(BruceHALL202, 'n');
    RestRoom.additem("safe", safe);
    RestRoom.additem("knife", knife);
    
    
    janitorCloset.addExit(BruceHALL201, 's');
    janitorCloset.additem("smallkey", smallkey);
    janitorCloset.additem("combination", combination);

    return BruceHALL201;
    }
}