import java.util.Random;
import java.util.Scanner;

public class Main {


    /*OPDRACHT:    Maak een Steen-papier-schaar spel.
    Bonus maak het zo dat je het spel vaker kan spelen en dat het de scores bijhoudt.
    Bonus maak het zo dat De computer vaker wint.
    Bonus maak het spel zo dat de computer vals speelt gaat spelen wanneer deze met meer dan 2 punten achter staat
    en dat ook visueel laat zien op een grappige manier maar weer normaal speelt als deze weer minder dan 2 punten achterloopt.
    Bonus maak het zo dat als je spock invoert dat je automatisch wint (cheat code)*/
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        //Variabelen

        String userInput;

        String computerResponse;

        int scoreUser = 0;

        int scoreComputer = 0;

        boolean playGame = true;
        System.out.println("Hello, good to see you here.");
        while (playGame) {
            if (userWantsToPlayGame(myScanner)) {
                userInput = userInput(myScanner);
                if (userInput.equalsIgnoreCase("spock")) {
                    System.out.println("You found the magic word, good job!");
                    scoreUser++;
                } else if (!userInput.equalsIgnoreCase("spock")) {
                    if ((scoreUser - scoreComputer) >= 2) {
                        //methode voor valsspelen`
                        System.out.println("I can't believe you're doing better than me! I should be the most powerful machine in the world!");
                        computerResponse = computerResponseCheating(userInput);
                    } else {
                        computerResponse = computerResponse();
                    }
                    System.out.println("You've chosen: " + inputToString(userInput) + " and I've chosen: " + inputToString(computerResponse));
//            calculate scores (wilde dit in aparte methode doen, maar dan worden de scores niet methode overstijgend opgeslagen.

                    if (userInput.equalsIgnoreCase("r")) {
                        if (computerResponse.equalsIgnoreCase("p")) {
                            scoreComputer++;
                        } else if (computerResponse.equalsIgnoreCase("s")) {
                            scoreUser++;
                        }
                    } else if (userInput.equalsIgnoreCase("p")) {
                        if (computerResponse.equalsIgnoreCase("s")) {
                            scoreComputer++;
                        } else if (computerResponse.equalsIgnoreCase("r")) {
                            scoreUser++;
                        }
                    } else {
                        if (computerResponse.equalsIgnoreCase("r")) {
                            scoreComputer++;
                        } else if (computerResponse.equalsIgnoreCase("p")) {
                            scoreUser++;
                        }
                    }
                } else {
                    System.out.println("Have a good day, see you later!");
                    playGame = false;
                }
            }
            printScore(scoreUser, scoreComputer);
        }


        // bij invoer spock - wint speler automatisch

    }

    // methode vragen voor spel spelen
    public static boolean userWantsToPlayGame(Scanner myScanner) {
        System.out.println("Would you like to play a game with me? \nType Y for Yes, or N for No");

        boolean correctUserInput = false;
        boolean playGame = false;
        while (!correctUserInput) {
            String stringPlayGame = myScanner.nextLine();
            if (stringPlayGame.equalsIgnoreCase("y") || stringPlayGame.equalsIgnoreCase("n")) {
                correctUserInput = true;
                if (stringPlayGame.equalsIgnoreCase("y")) {
                    playGame = true;
                    correctUserInput = true;
                } else {
                    playGame = false;
                    correctUserInput = true;
                }
            } else {
                System.out.println("This is not a correct answer. \nPlease type Y for Yes, or N for No");
            }
        }

        return playGame;
    }


    // methode user input voor R, P, S
    public static String userInput(Scanner myScanner) {
        System.out.println("We're gonna play a game of Rock, Paper, Scissors. \nPlease choose between R (Rock), P (Paper) or S (Scissor): ");

        boolean correctUserInput = false;

        String stringUserInput = null;

        while (!correctUserInput) {
            stringUserInput = myScanner.nextLine();
            if (stringUserInput.equalsIgnoreCase("spock") || stringUserInput.equalsIgnoreCase("r") || stringUserInput.equalsIgnoreCase("s") || stringUserInput.equalsIgnoreCase("p")) {
                correctUserInput = true;
            } else {
                System.out.println("This is not a correct answer. \nPlease choose between R (Rock), P (Paper) or S (Scissor):");
            }
        }

        return stringUserInput;
    }

    // methode computer input random genereren

    public static String computerResponse() {
        Random rand = new Random();
        String[] rpsRandom = {"R", "P", "S"};

        String stringComputerResponse = rpsRandom[rand.nextInt(3)];

//        System.out.println(stringComputerResponse);

        return stringComputerResponse;

    }

    public static String inputToString(String input) {
        String inputToString = null;
        switch (input) {
            case "R":
            case "r":
                inputToString = "Rock";
                break;
            case "P":
            case "p":
                inputToString = "Paper";
                break;
            case "S":
            case "s":
                inputToString = "Scissor";
                break;
            default:
                System.out.println("Something goes wrong!");
        }

        return inputToString;
    }

    //methode scores berekenen


    public static void printScore(int scoreUser, int scoreComputer) {
        System.out.println("We have the following scores: \nYou: " + scoreUser + "\nMe: " + scoreComputer);
    }

    // methode computer input vals spelen

    public static String computerResponseCheating(String userInput) {
        String computerResponseCheating = null;
        switch (userInput) {
            case "R":
            case "r":
                computerResponseCheating = "p";
                break;
            case "P":
            case "p":
                computerResponseCheating = "s";
                break;
            case "S":
            case "s":
                computerResponseCheating = "r";
                break;
            default:
                System.out.println("Something goes wrong!");
        }
        return computerResponseCheating;
    }

}