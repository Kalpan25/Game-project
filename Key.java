public class Key extends item{
    public Key(String name, String description){
        super("key", "BruceHall202");
    }

    @Override
    public void use(){
        if(currentRoom.getExit('w') == null){
            Game.print("Try using it to open the BruceHall202 ");
        }
        else if (currentRoom.getExit('w').getRoomname().equals("BruceHall202")){
            Game.print("You used the key to open the BruceHall202");
            currentRoom.getExit('d').setLock(false);
            
        }
        else
            Game.print("Try using it to open the BruceHall202 ");
    }
}
