

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    private JTextArea descriptionArea;
    private JTextField directionField;
    private String currentRoom = "BruceHall201";

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        buildWindow();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String direction = directionField.getText().trim().toLowerCase();
        if (!direction.isEmpty()) {
            move(direction);
            directionField.setText(""); // Clear input field after submission
        }
    }

    private void buildWindow() {
        setTitle("Room Navigation Game");
        setLayout(new BorderLayout(10, 10));

        // Center Panel: Room Description
        descriptionArea = new JTextArea();
        descriptionArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        descriptionArea.setEditable(false);
        descriptionArea.setText(getRoomDescription(currentRoom));
        add(new JScrollPane(descriptionArea), BorderLayout.CENTER);

        // South Panel: User input and submit button
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel promptLabel = new JLabel("Where do you want to go?");
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
        directionField = new JTextField();
        JButton goButton = new JButton("Go");

        goButton.addActionListener(this);

        inputPanel.add(promptLabel);
        inputPanel.add(directionField);
        inputPanel.add(goButton);

        add(inputPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center window
        setVisible(true); // Make window appear
    }

    private void move(String direction) {
        switch (currentRoom) {
            case "BruceHall201":
                if (direction.equals("west")) currentRoom = "BruceHall202";
                else if (direction.equals("east")) currentRoom = "BruceHall203";
                else if (direction.equals("north")) currentRoom = "JanitorCloset";
                else invalidDirection();
                break;
            case "BruceHall202":
                if (direction.equals("south")) currentRoom = "Restroom";
                else if (direction.equals("east")) currentRoom = "BruceHall201";
                else invalidDirection();
                break;
            case "BruceHall203":
                if (direction.equals("south")) currentRoom = "Elevator";
                else if (direction.equals("west")) currentRoom = "BruceHall201";
                else invalidDirection();
                break;
            case "JanitorCloset":
                if (direction.equals("south")) currentRoom = "BruceHall201";
                else invalidDirection();
                break;
            case "Elevator":
                if (direction.equals("down")) currentRoom = "FirstFloor";
                else invalidDirection();
                break;
            case "FirstFloor":
                invalidDirection();
                break;
            case "Restroom":
                if (direction.equals("north")) currentRoom = "BruceHall202";
                else invalidDirection();
                break;
            default:
                invalidDirection();
        }
        descriptionArea.setText(getRoomDescription(currentRoom));
    }

    private void invalidDirection() {
        descriptionArea.setText(getRoomDescription(currentRoom) + "\nInvalid direction! Please try again.");
    }

    private String getRoomDescription(String room) {
        switch (room) {
            case "BruceHall201":
                return "BruceHall201\nYou are in the 201. Doorways lead west to 202, east to 203, and north to the janitor closet.";
            case "BruceHall202":
                return "BruceHall202\nYou are in the 202. A small room with a desk. Doorways lead south to the restroom and east back to 201.";
            case "BruceHall203":
                return "BruceHall203\nYou are in the 203. It’s a quiet room with a desk and a chair. A doorway leads south to the elevator and west to 201.";
            case "JanitorCloset":
                return "JanitorCloset\nYou are in the janitor closet. It’s cramped and filled with cleaning supplies. The only way out is south to 201. The door is locked.";
            case "Elevator":
                return "Elevator\nYou are in the elevator. A small metal box with buttons for different floors. The door leads down to the first floor. It is locked.";
            case "FirstFloor":
                return "First Floor\nYou are on the first floor. A wide hallway stretches before you. There is nothing else here.";
            case "Restroom":
                return "Restroom\nYou are in the restroom. There are several stalls and a sink. Doorways lead north back to 202.";
            default:
                return "Unknown location.";
        }
    }
}
