public class Computer extends item {
    public Computer(String name, String description){
        super("computer", "principal's computer");

    }

    public void open(){

        if(Game.getiteminventory("Passbook") == null){
            Game.print("You don't have the passcode to unlock this device");
        }

        else{
            Game.print("Using the code you received from the Passbook, you unlock the computer.\n");
            Game.print("As you browse thorugh the laptop, you find the secruity system that can unlock the Elevetor in the hall");
            Game.print("You can now use the software");

            if(Game.getiteminventory("software") == null){
                SoftwareApp software = new SoftwareApp("software", "a system that can unlock the Elevetor");
                Game.inventory.add(software);
            }
        }
    }
}