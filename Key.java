public class Key extends item{
    public Key(String name, String description){
        super("key", "key");
    }

    @Override
    public void use(){
        if(Game.currentRoom.getExit('n') == null){
            Game.print("Try using it to open the  ");
        }
        else if(Game.currentRoom.getExit('n').getRoomname().equals("JanitorCloset")){
            Game.print("You used the key to open the JanitorCloset");
            Game.currentRoom.getExit('n').setLock(false);
            
        }
        else
            Game.print("Try using it to open the JanitorCloset ");
    }
}