public class Puppy extends NPC {
     int talkCount = 0;  

    public Puppy(String name, String description) {
        super("puppy", "A hideous puppy wags his tail.");
    }

    @Override
    public void talk() {
        talkCount++;  

        if (talkCount == 0) {
            
            say("Hi! I'm an adorable puppy!");
            String[] options = {
                "Yes you are! Who's a good boy?",
                "Ew, no. You're actually kinda hideous."
            };
            getResponse(options);
            talkCount++;
        } else if (talkCount == 1) {
            
            say("Hey! Wanna play fetch? Say yes! Say yes!");
            String[] options = {
                "Yes! I love fetch!",
                "No. I am a horrible person and don't like playing with puppies."
            };
            getResponse(options);
            talkCount++;
        } else {
          
            say("Yip! wags tail");
            talkCount++;
        }
    }

    @Override
    public void response(int option) {
        if (talkCount == 0) {
            
            switch (option) {
                case 1:
                    say("I am! I'm a good boy!");
                    break;
                case 2:
                    say("I am adorable! Why are you so mean?");
                    Game.print("The puppy bites you. You deserve it.");
                    break;
            }
        } else if (talkCount == 1) {
            
            switch (option) {
                case 1:
                    say("Yay! Fetch!");
                    Game.print("The puppy runs off and returns with a ball. You receive the ball.");
                    item ball = new item("ball", "A small ball");
                    Game.inventory.add(ball);
                    break;
                case 2:
                    say("You're a bad person! I don't like you!");
                    Game.print("The puppy runs away and doesn't come back.");
                    break;
            }
        }
    }
}
