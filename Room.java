
import java.util.HashMap;
import java.io.Serializable;

public class Room implements Serializable{
    
    private String name;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private HashMap<String, item> items = new HashMap<String, item>();
    private HashMap<String,NPC> npc = new HashMap<String,NPC>();
    
    private boolean lock;

     
    public Room( String Name) {
        this.name = Name;
        Game.roomObjects.put(Name,this);
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
        String s = this.getDescription(name);
        return s;
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
     public void addNPC(String name,NPC x){
        npc.put(name,x);
     }
     public NPC getNPC(String name){
        return npc.get(name);
     }
     public void removeNPC(String name){
        npc.remove(name);
    }

    public String getRoomname(){
        return name;
    }
    public void setRoomname(String name){
        this.name = name;
    }
    public String getDescription(String n ){
        for(String s:Game.rooms.keySet()){
            if(s.equals(n)){
                return Game.rooms.get(s);
            }    
        }
        return null;
    } 
}    