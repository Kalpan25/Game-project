public class Key extends item {
    public Key(String name, String description){
        super("key", "A small, rusty key");
    }   
    @Override
    public void use(){
        Game.print("You use the key to open the janitor closet.\n");
    }


}
