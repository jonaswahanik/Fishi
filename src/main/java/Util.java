import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public final class Util {
    //utility class to not cludurg main with print statements

    //prints tutorial text such as title screen credits and how to play. WOWOWOWOOWOWOWOWOWWOWOOWOWOWOWOWOWOOWOWOWOWO!
    public static void tutorialText() {
        String text = "\n" +
                "  ______ _____  _____ _    _ _____   ______ _____  _____ _    _ _____ _   _  _____  \n" +
                " |  ____|_   _|/ ____| |  | |_   _| |  ____|_   _|/ ____| |  | |_   _| \\ | |/ ____| \n" +
                " | |__    | | | (___ | |__| | | |   | |__    | | | (___ | |__| | | | |  \\| | |  __  \n" +
                " |  __|   | |  \\___ \\|  __  | | |   |  __|   | |  \\___ \\|  __  | | | | . ` | | |_ | \n" +
                " | |     _| |_ ____) | |  | |_| |_  | |     _| |_ ____) | |  | |_| |_| |\\  | |__| | \n" +
                " |_|    |_____|_____/|_|  |_|_____| |_|    |_____|_____/|_|  |_|_____|_| \\_|\\_____| " +
                "\n";
        int i;

        //animates the welcome text, prints it line by line.
        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(1);//0.5s pause between characters
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        System.out.println("Find your way next to the pond\nThen type in the random word as fast as possible");
    }

    public static void runGame() throws IOException {
        Random rand = new Random();
        boolean playAgain = true;
        int num60 = rand.nextInt(63);
        int numY = rand.nextInt(15);
        int numX = rand.nextInt(15);
        //create game board
        Grid grid = new Grid(numX,numY, 7, 7);

        //System.out.println(grid);

        //sets up the game by
        Fish fishing = new Fish();
        fishing.addBulkFish();

        Scanner scan = new Scanner(System.in);

        System.out.println(grid);
        while(grid.canFish() == false) {
            grid.changePlayerX();
            grid.changePlayerY();
            grid.refreshGrid();
            if (grid.canFish() == false && (grid.playerX != grid.pondX && grid.playerY != grid.pondY)) {
                System.out.println("Uh Oh!\nYou got lost on your way\nTry Again");
            }
            if (grid.canFish() == true) {
                System.out.println("You have arrived at the pond.\nYou can now start fishing");
            }
//        f.addKeyListener(new KeyListener() {
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
//                    System.out.println("woot!");
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        });
        }


        //allows the round to be played multiple times and if they are near a pond, but ends if they dont catch the fish.
        while(playAgain == true && grid.canFish() == true) {
            System.out.println("Ready!!");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String fish = fishing.pickRandomFish();
            System.out.println("A wild " + fish + " has appeared");
            System.out.println("Rarity: " + fishing.getRarity(fish));
            fishing.fillWordsToWin();

            //runs method and gets random word from the word list
            String winningWord = fishing.catcherWord(fish);
            System.out.println(winningWord);

            String str = "";

            //gives user certain amount of time for input.

            TimerTask task = new TimerTask() {
                public void run() {
                    if (str.equals("")) {
                        System.out.println("\nToo Slow!");
                        System.out.println("You scared away all the fish!\nYou'll need to come back another day once the fish have returned");
                        try {
                            runGame();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        try {
//
//                            grid.refreshGrid();
//                            runGame();
//
//                        } catch (IOException e) {
//
//                            e.printStackTrace();
//                        }
                    }
                }
            };

            Timer timer = new Timer();
            timer.schedule(task, 2500);
            Scanner sc = new Scanner(System.in);
            String in = sc.next();
            timer.cancel();

            //shows user results and prints caught fish if user wants
            if (fishing.didCatch(in, winningWord)) {
                fishing.storeFish(fish);
                System.out.println("You have caught a " + fish);
                System.out.println("Press 'i' if you would like to view your inventory full of fish!\nOr enter anything else if you would like to skip this");
                String viewFish = scan.nextLine();
                if(viewFish.equals("i")) {
                    fishing.readStoredFish();
                }
            }
            else {
                System.out.println(fish + " broke free");
            }
            System.out.println("Do you want to play again? Enter y for yes and n for no");
            String userInput = scan.nextLine();
            if(userInput.equals("n")) {
                playAgain = false;
            System.out.println("Press 'i' to view your inventory full of fish!");
            String viewFish = scan.nextLine();
            if(viewFish.equals("i")) {
                fishing.readStoredFish();
            }
            }
        }
    }

}

