
import java.io.Serializable;
public class item implements Serializable {
    private String name;
    private String description;


    public item(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return name;
    }

    public void open(){
        Game.print("you can't open that.");
    
    }
    public void use(){
        Game.print("you can't use that.");
    }
    

}
