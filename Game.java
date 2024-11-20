
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class Game {
        public static void main(String[] args) {
        textFile();
        runGame();  
        }
        public static void print(Object obj) {
            System.out.println(obj.toString());
        }
        
        static Room currentRoom = World.buildWorld();
        public static Room getCurrentRoom() {
            return currentRoom;
        }
        public static item getiteminventory(String name){
            for(item i : inventory){
                if(i.getName().equals(name)){
                    return i;
                }
            }
            
            return null;
        }
        public static void textFile(){
        try {
            Scanner input = new Scanner(new File("Description.txt"));
            while(input.hasNextLine()) {
                Thread.sleep(1000); // sleep for 1 second
                String name = input.nextLine();
                String desc = input.nextLine();

                if(!name.equals("#") && !desc.equals("#")){
                    rooms.put(name, desc);
                    System.out.println(name);
                    System.out.println(desc);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        } catch (InterruptedException ex) {
            System.out.println("Bummer.");
        }
    }

       static ArrayList<item> inventory = new ArrayList<item>();
       static HashMap<String, String> rooms = new HashMap<String, String>();

        public static void runGame() {
          
          Scanner scanner = new Scanner(System.in);
        
          String command;

          do{
            
            System.out.println(currentRoom);
            System.out.print("Where do you want to go ?: ");
            command = scanner.nextLine();
            String[] words = command.split(" ");

            switch(words[0]) {
            case "e":
            case"w":
            case "n":
            case "s":
            case "u":
            case "d":
                Room nextRoom = currentRoom.getExit(command.charAt(0));
                if(nextRoom == null) {
                    System.out.println("You can't go that way.");
                }
                else if(nextRoom.getlock() == true) {
                    System.out.println("The door is locked.");
                }
                else
                    currentRoom = nextRoom;
                break;
            
            case"x":
                System.out.println("Thanks for playing ,Goodbye  ");
                break;
            case "take":
                if(currentRoom.getitem(words[1]) == null){
                    System.out.println("There is no item here.");
                }
                else{
                    inventory.add(currentRoom.getitem(words[1]));
                    currentRoom.additem(words[1],null);
                }
                break;
            case "i":
                if (inventory.size()==0){
                    System.out.println("Inventory is empty.");
                }
                else{
                    for(item i: inventory){
                        System.out.println(i);
                    }
                }
                break;
            case "look":
            if(currentRoom.getitem(words[1]) != null){
                System.out.println(currentRoom.getitem(words[1]).getDescription() + "\n");
            }


            else{
                boolean found = false;

                for(item c : inventory){
                    if(c.getName().equals(words[1])){
                        System.out.println(c.getDescription() + "\n");
                        found = true;      
                    }
                }

                if(found == false)
                    System.out.println("There is no such item.\n");
            }
                
            break;

            case "use":

                System.out.println("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getitem(words[1]) != null){
                    currentRoom.getitem(words[1]).use();
                }

                else{

                    if (getiteminventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getiteminventory(words[1]).use();
                        System.out.println();
                    }
                }

                break;

                case "open":

                System.out.println("You are trying to open the " + words[1] + ".");
                
                if(currentRoom.getitem(words[1]) != null){
                    currentRoom.getitem(words[1]).open();
                }

                else{

                    if (getiteminventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getiteminventory(words[1]).open();
                        System.out.println();
                    }
                }

            break;

            default:
                System.out.println("Invalid direction. Please try again.");
            
            }
        

        } while(!command.equals("x"));
     
        scanner.close();
    }
}          


    
