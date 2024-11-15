public class SoftwareApp extends item {
    public SoftwareApp(String name, String description){
        super("software", "a system that can unlock the Elevetor");

    }

    @Override
    public void use(){
        if(Game.currentRoom.getExit('s') == null){
            Game.print("Try using it to unlock some place\n");
        }
        else if(Game.currentRoom.getExit('s').getRoomname().equals("Elevetor")){
            Game.print("You used the system. You can now access the Elevetor\n");
            Game.currentRoom.getExit('s').setLock(false);
            
        }

        else 
            Game.print("Try using it to unlock some place\n");
    }
}