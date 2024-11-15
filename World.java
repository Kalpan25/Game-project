

public class World {
    // Builds the game world.   
    // Returns the room the player starts in.
    public static Room buildWorld() {
    Room BruceHALL201 = new Room("You are in the 201.", "BruceHall201");
    Room BruceHALL202 = new Room("You are in the 202.", "BruceHall202");
    Room BruceHALL203 = new Room("You are in the 203.", "BruceHall203");
    Room janitorCloset = new Room("You are in the janitor closet.", "JanitorCloset");
    Room Elevetor = new Room("You are in the elevator.","Elevetor");
    Room FirstFloor = new Room("You are on the first floor.","First Floor");
    Room RestRoom = new Room("You are in the restroom.","Rest Room");

    item keycard = new item("keycard","You found a keycard!");
    Key key = new Key("key","You found a small key!");
    item knife = new item("knife","You found a knife!");
    item kit = new item("firstaid kit","You found a first aid kit!");
    item bat = new item("baseball bat","You found a baseball bat!");
    item bag = new item("bag","You found a bag!");
    Combination combination = new Combination("combination","You found a combination lock!");
    Safe safe = new Safe("safe","You found a safe!");
    Computer computer = new Computer("computer","ITS Computer");
    Passbook passbook = new Passbook("passbook","Password note book");
    
    
    BruceHALL201.addExit(BruceHALL202, 'w');
    BruceHALL201.addExit(BruceHALL203, 'e');
    BruceHALL201.additem("keycard", keycard);
    BruceHALL201.addExit(janitorCloset, 'n');

    BruceHALL202.addExit(RestRoom, 's');
    RestRoom.additem("first aid kit",kit);
    RestRoom.additem("Baseball bat", bat);
    RestRoom.additem("bag",bag);
    BruceHALL202.additem("key", key);
    BruceHALL202.addExit(BruceHALL201, 'e'); 
    BruceHALL202.setLock(false);
    BruceHALL202.additem("key", key);

    BruceHALL203.addExit(Elevetor, 's');
    BruceHALL203.setLock(false);
    BruceHALL203.addExit(BruceHALL201, 'w');
    BruceHALL203.additem("passbook", passbook);

    Elevetor.addExit(FirstFloor, 'd');
    Elevetor.setLock(true);
    RestRoom.addExit(BruceHALL202, 'n');
    RestRoom.setLock(false);
    RestRoom.additem("safe", safe);
    RestRoom.additem("knife", knife);
    RestRoom.additem("computer", computer);
    
    
    janitorCloset.addExit(BruceHALL201, 's');
    janitorCloset.setLock(true);
    janitorCloset.additem("combination", combination);

    return BruceHALL201;
    }
}