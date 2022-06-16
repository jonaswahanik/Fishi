//import statements
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws IOException {


        //runs code from Util class... this is to keep the main class decluddered and easy to understand
        Util run = new Util();
        run.tutorialText();
        run.runGame();


    }
}

