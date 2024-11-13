
import java.util.HashMap;


public class Room {
    private String description;
    private String name;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private HashMap<String, item> items = new HashMap<String, item>();
    
    private boolean lock;

     
    public Room(String  description, String Name) {
        this.description = description;
        this.name = Name;
    }
    public Room getExit(char x) {
        if (x == 'e') 
        return east;
        if (x == 'w')
        return west;
        if (x == 'n')
        return north;
        if (x == 's')
        return south;
        if (x == 'u')
        return up;
        if (x == 'd')
        return down;

        return null;
    }

    public void addExit(Room room, char direction) {
        if (direction == 'e')
        east = room;
        if (direction == 'w')
        west = room;
        if (direction == 'n')
        north = room;
        if (direction =='s')
        south = room;
        if (direction == 'u')
        up = room;
        if (direction == 'd')
        down = room;
     } 
    public String toString() {
        return description;
    }

    public void additem(String name , item i){
        items.put(name, i);
    }
    public item getitem(String name){
        return items.get(name);
    }
    
    public void removeItem(String name){
        items.remove(name);
        
    }
    public boolean getlock(){
        return lock;
    }

    public void setLock(boolean bool){
        lock= bool;
     }
    public String getRoomname(){
        return name;
    }
    public void setRoomname(String name){
        this.name = name;
    }
}    