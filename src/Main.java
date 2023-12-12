import java.util.ArrayList;
import java.util.Scanner;

// Rock, Paper, Scissors game for multiple players
public class Main {
    public static void main(String[] args) {

        // Ask users the number of players
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Let's play the rock-paper-scissors game!\n" + Emoji.personEmoji + "How many players? ");
        int numberOfPlayers;
        numberOfPlayers = keyboard.nextInt();


        // Validate the user input
        while (numberOfPlayers <= 1) {
            System.out.println(Emoji.personEmoji + "You typed invalid number. Try again.");
            System.out.println(Emoji.personEmoji + "How many players? ");
            numberOfPlayers = keyboard.nextInt();
        }
        System.out.println(Emoji.personEmoji + "You typed: " + numberOfPlayers);
        System.out.println(Emoji.personEmoji + "Is this correct? (Y or N)");
        char yesOrNo;
        yesOrNo = keyboard.next().charAt(0);


        // Validate the user's confirmation
        while (true) {
            if (yesOrNo == 'Y' || yesOrNo == 'y') {
                System.out.println(Emoji.personEmoji + "Cool. Let's get started! \n");
                break;
            } else if (yesOrNo == 'N' || yesOrNo == 'n') {
                System.out.println(Emoji.personEmoji + "Please select the number of players again");
                numberOfPlayers = keyboard.nextInt();
                System.out.println(Emoji.personEmoji + "You typed: " + numberOfPlayers);
                System.out.println(Emoji.personEmoji + "Is this correct? (Y or N)");
                yesOrNo = keyboard.next().charAt(0);
            } else {
                System.out.println(Emoji.personEmoji + "Please answer 'Y' or 'N'");
                yesOrNo = keyboard.next().charAt(0);
            }
        }





        // Game start
        ArrayList<String> chosenArr = new ArrayList<>();
        while (chosenArr.size() != 1) {
            chosenArr.clear();
            System.out.printf("\n" + Emoji.flagEmoji + "Please select ONE among 'R(Rock %s), 'P(Paper %s)', and 'S(Scissors %s)'\n", Emoji.rockEmoji, Emoji.paperEmoji, Emoji.scissorsEmoji);

            // Collect choices from each player
            for (int i = 1; i < numberOfPlayers + 1; i++) {
                System.out.println(Emoji.speechBalloonEmoji + "Player" + i);
                String choice = keyboard.next().toUpperCase();

                // Validate the user input
                while (!("R".equals(choice) || "P".equals(choice) || "S".equals(choice))) {
                    System.out.printf(Emoji.exclamationMarkEmoji + "Again. Please select ONE among 'R(Rock %s), 'P(Paper %s)', and 'S(Scissors %s)'", Emoji.rockEmoji, Emoji.paperEmoji, Emoji.scissorsEmoji);
                    choice = keyboard.next().toUpperCase();
                }
                chosenArr.add(choice);
            }


            // Initialise variables to track the count and index of each choice
            int countR = 0;
            int countP = 0;
            int countS = 0;

            int winnerR = 0;
            int winnerP = 0;
            int winnerS = 0;


            // Count occurrences of each choice and determine winners
            for (String check : chosenArr) {
                if ("R".equals(check)) {
                    countR++;
                    winnerR = chosenArr.indexOf("R");

                } else if ("P".equals(check)) {
                    countP++;
                    winnerP = chosenArr.indexOf("P");

                } else if ("S".equals(check)) {
                    countS++;
                    winnerS = chosenArr.indexOf("S");
                }
            }


            // Handle tie conditions
            if ((countP > 0 && countR > 0 && countS > 0) ||
                    (countP == chosenArr.size()) || (countR == chosenArr.size()) || (countS == chosenArr.size())) {

                // Clear the array when it's a tie
                System.out.println(Emoji.personEmoji + "A tie. Let's do it again!");
                chosenArr.clear();

                // Handle game rules for non-tie scenarios
                // Rule: Paper covers Rock
            } else if (countP > 0 && countR > 0 && countS == 0 && chosenArr.size() > 1) {

                for (int r = 0; r < chosenArr.size(); r++) {
                    if ("R".equals(chosenArr.get(r))) {
                        chosenArr.remove(r);
                        r--;
                        numberOfPlayers = chosenArr.size();
                    }
                }
                if (chosenArr.size() >= 2) {
                    System.out.println(Emoji.personEmoji + chosenArr + " won." + " Next round!");
                }


                // Rule: Scissors cut Paper
            } else if (countP > 0 && countR == 0 && countS > 0 && chosenArr.size() > 1) {

                for (int s = 0; s < chosenArr.size(); s++) {
                    if ("P".equals(chosenArr.get(s))) {
                        chosenArr.remove(s);
                        s--;
                        numberOfPlayers = chosenArr.size();
                    }
                }
                if (chosenArr.size() >= 2) {
                    System.out.println(Emoji.personEmoji + chosenArr + " won." + " Next round!");
                }


                // Rule: Rock crushes Scissors
            } else if (countP == 0 && countR > 0 && countS > 0 && chosenArr.size() > 1) {

                for (int r = 0; r < chosenArr.size(); r++) {
                    if ("S".equals(chosenArr.get(r))) {
                        chosenArr.remove(r);
                        r--;
                        numberOfPlayers = chosenArr.size();
                    }
                }
                if (chosenArr.size() >= 2) {
                    System.out.println(Emoji.personEmoji + chosenArr + " won." + " Next round!");
                }
            }


            // Display the result of the game
            if (chosenArr.size() == 1 && chosenArr.get(0).equals("P")) {
                System.out.println("\n" + Emoji.celebrationEmoji + "Congrats! Winner is Player number " + (winnerP + 1));
            } else if (chosenArr.size() == 1 && chosenArr.get(0).equals("R")) {
                System.out.println("\n" + Emoji.celebrationEmoji + " Congrats! Winner is Player number " + (winnerR + 1));
            } else if (chosenArr.size() == 1 && chosenArr.get(0).equals("S")) {
                System.out.println("\n" + Emoji.celebrationEmoji + " Congrats! Winner is Player number " + (winnerS + 1));
            }

        }


    }

}
