
public class Safe extends Item {
    public Safe(String name, String description) {
        super(name, description);
    }

    @Override
    public void open() {
        if(Game.getItem("combination") != null){
            Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
            Item diamond = new Item("diamond", "A shiny, round diamond.");
            Game.getCurrentRoom().addItem(diamond);
            Game.inventory.remove(Game.getItem("combination"));
        } else {
            Game.print("The safe is locked and you don't have the combination.");
        }
    }
}