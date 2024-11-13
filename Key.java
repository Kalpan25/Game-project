public class Key extends item{
    public Key(String name, String description){
        super("key", "key");
    }

    @Override
    public void use(){
        if(currentRoom.getExit('n') == null){
            Game.print("Try using it to open the  ");
        }
        else if(currentRoom.getExit('n').getRoomname().equals("janitorCloset")){
            Game.print("You used the key to open the janitorCloset");
            currentRoom.getExit('n').setLock(false);
            
        }
        else
            Game.print("Try using it to open the janitorCloset ");
    }
}