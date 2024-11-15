public class Passbook extends item{
    public Passbook(String name, String description){
        super("Passbook", "a small note with numbers");
    }

    
    @Override
    public void use(){
        if(Game.getiteminventory("Computer") == null){
            Game.print("You can't use the passnote because you don't have the item to open it.\n");
        }

        else{
            Game.print("Use the passnote to open the Computer ");
        }
    }
}