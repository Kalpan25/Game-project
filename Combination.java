public class Combination extends item{
    public Combination(String name, String description){
        super("combination", "Combination to the black safe");
    }

    @Override
    public void use(){
        Game.print("If you find a safe, try opening it!\n");
    }
}