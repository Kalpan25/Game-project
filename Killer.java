public class Killer extends NPC {
    int talkCount = 0;  

    public Killer(String name, String description) {
        super("killer", "A terrifying figure lurks in the shadows.");
    }

    @Override
    public void talk() {
        talkCount++;  

        if (talkCount == 0) {
            say("You shouldn't have come here. Do you think you can escape?");
            String[] options = {
                "I'm not afraid of you!",
                "Please, let me go!"
            };
            getResponse(options);
            talkCount++;
        } else if (talkCount == 1) {
            say("Run while you still can. The elevator won't save you.");
            String[] options = {
                "I will escape!",
                "Stay away from me!"
            };
            getResponse(options);
            talkCount++;
        } else {
            say("Too late... You can't hide forever.");
            talkCount++;
        }
    }

    @Override
    public void response(int option) {
        if (talkCount == 0) {
            switch (option) {
                case 1:
                    say("Brave, but foolish.");
                    Game.print("The killer smirks and steps closer.");
                    break;
                case 2:
                    say("Cowardice won't save you.");
                    Game.print("You feel the killer's presence intensify.");
                    break;
            }
        } else if (talkCount == 1) {
            switch (option) {
                case 1:
                    say("Your courage won't last.");
                    Game.print("The killer vanishes into the darkness, but you feel watched.");
                    break;
                case 2:
                    say("Fear is delicious.");
                    Game.print("The killer seems to enjoy your panic, stepping even closer.");
                    break;
            }
        }
    }
}