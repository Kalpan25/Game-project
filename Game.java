
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Game {
        public static void main(String[] args) {
        textFile();
        gui = new GUI();
        Game.print(currentRoom);

        
        }
        private static GUI gui = new GUI();
       static ArrayList<item> inventory = new ArrayList<item>();
       static HashMap<String, String> rooms = new HashMap<String, String>();
       static HashMap<String,Room> roomObjects = new HashMap<String , Room>();
       public static Scanner scanner = new Scanner(System.in);
        public static void print(Object obj) {
            gui.textArea.append((obj.toString())+"\n");
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
                //Thread.sleep(1000); // sleep for 1 second
                String name = input.nextLine();
                String desc = input.nextLine();

                if(!name.equals("#") && !desc.equals("#")){
                    rooms.put(name, desc);
                    
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        } //catch (InterruptedException ex) {
            //System.out.println("Bummer.");
        //}
    }
            public static void saveList(String fileName) {
            File f = new File(fileName);
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream stream = new ObjectOutputStream(fos);
                stream.writeObject(currentRoom);
                stream.writeObject(inventory);
                stream.writeObject(roomObjects);
                stream.close();
            } catch (FileNotFoundException e) {
                System.out.println("File "+fileName+" not found.");
            } catch (IOException ex) {
                System.out.println("Bummers, man");
            }
        }
        public static void loadList(String fileName) {
            File f = new File(fileName);
            try {
            FileInputStream fos = new FileInputStream(f);
            ObjectInputStream stream = new ObjectInputStream(fos);
            currentRoom = (Room) stream.readObject();
            inventory = (ArrayList) stream.readObject();
            roomObjects = (HashMap) stream.readObject();
            stream.close();
            } catch (FileNotFoundException e) {
            System.out.println("File "+fileName+" not found.");
            System.exit(0);
            } catch (IOException ex) {
            System.out.println("Bummers, man");
            } catch (ClassNotFoundException ex) {
            System.out.println("Not an object.");
            }
            }
        

        public static void processCommand(String command) {

        
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
                    Game.print("You can't go that way.");
                }
                else if(nextRoom.getlock() == true) {
                    Game.print("The door is locked.");
                }
                else
                    currentRoom = nextRoom;
                    Game.print(currentRoom);
                break;
            
            case"x":
                Game.print("Thanks for playing ,Goodbye  ");
                break;


                case "take":
                if (words.length < 2) {
                    Game.print("Please specify the item you want to take.");
                } else {
                    String itemName = words[1].toLowerCase();
                    if (currentRoom.getitem(itemName) == null) {
                        Game.print("There is no item here.");
                    } else {
                        item itemToTake = currentRoom.getitem(itemName);
                        inventory.add(itemToTake);
                        currentRoom.removeItem(itemName);
                        Game.print("You picked up the " + itemName + ".");
                    }
                }
                break;
            


            case "i":
                if (inventory.size()==0){
                    Game.print("Inventory is empty.");
                }
                else{
                    for(item i: inventory){
                        Game.print(i);
                    }
                }
                break;
            case "look":
            if(currentRoom.getitem(words[1]) != null){
                Game.print(currentRoom.getitem(words[1]).getDescription() + "\n");
            }


            else{
                boolean found = false;

                for(item c : inventory){
                    if(c.getName().equals(words[1])){
                        Game.print(c.getDescription() + "\n");
                        found = true;      
                    }
                }

                if(found == false)
                    Game.print("There is no such item.\n");
            }
                
            break;

            case "use":

                Game.print("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getitem(words[1]) != null){
                    currentRoom.getitem(words[1]).use();
                }

                else{

                    if (getiteminventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getiteminventory(words[1]).use();
                        Game.print("\n");
                    }
                }
               
                break;

                case "open":

                Game.print("You are trying to open the " + words[1] + ".");
                
                if(currentRoom.getitem(words[1]) != null){
                    currentRoom.getitem(words[1]).open();
                }

                else{

                    if (getiteminventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getiteminventory(words[1]).open();
                        Game.print("\n");
                    }
                }
                break;

                case "talk":
                    Game.print("You are trying to talk to the " + words[1] + ".");

                        if(currentRoom.getNPC(words[1]) != null){
                            currentRoom.getNPC(words[1]).talk();
                            Game.print("\n");
                        }
                        else{
                            Game.print("There is no such thing\n");
                        }

            break;
            case "save":
            saveList(words[1]);

            break;
            case "load":
            loadList(words[1]);
            
            break;

            default:
                Game.print("Invalid direction. Please try again.");
            
            }
        

        } 
     
     
    }
    
    



    
