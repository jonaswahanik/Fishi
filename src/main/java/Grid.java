
//ignore this class, moses made this and then didnt show up to class for like a week

import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
    ArrayList<ArrayList<Space>> rows = new ArrayList<ArrayList<Space>>();
    int playerX;
    int playerY;
    int pondX;
    int pondY;
    // The Grid holds the coordinates of the player.
    Scanner scan = new Scanner(System.in);


    public Grid(int playerX, int playerY, int pondX, int pondY) throws IOException {
        this.playerX = playerX;
        this.playerY = playerY;
        this.pondX = pondX;
        this.pondY = pondY;
        //sets up grid as well as checking if you fell in the pond
        for (int i = 0; i<15; i++) {
            ArrayList<Space> thisList = new ArrayList<>();
            for (int j=0; j<15; j++) {
                Space thisSpace = new Space();
                if (i == this.playerY && j == this.playerX) {
                    thisSpace.addPlayer();
                }
                if (i == this.pondY && j == this.pondX) {
                    thisSpace.addPond();
                }
                if (pondX == playerX && pondY == playerY){
                    thisSpace.addSwimming();



                }

                thisList.add(thisSpace);
            }
            rows.add(thisList);
        }
        if (pondX == playerX && pondY == playerY) {
            fellInWater();
        }
    }

    public void refreshGrid() throws IOException {

        Grid movedGrid = new Grid(playerX,playerY, pondX, pondY);
        System.out.println(movedGrid);
    }
    //changes player y
    public void changePlayerY() {
        System.out.println("How much would you like to move up or down?\nUse negative numbers to move down and positive numbers to move up");
        int amountMovedY = scan.nextInt();
        playerY -= amountMovedY;
    }
    // changes players x
    public void changePlayerX() {
        System.out.println("How much would you like to move left or right?\nUse negative numbers to move left and positive numbers to move right");
        int amountMovedX = scan.nextInt();
        playerX += amountMovedX;

    }
    //if you are adjacent to the pond you can fish
    public boolean canFish() {
        int y = Math.abs(pondY - playerY);
        int x = Math.abs(pondX - playerX);
        if((x <= 1 && y <= 1) && x+y > 0)  {
            return true;
        }
        return false;
    }
    //clears output when you have fall in the lake
    public void fellInWater() throws IOException {
        System.out.println("OH NO\nYOU FELL IN THE POND\nALL YOU FISH SWAM AWAY");
        FileWriter fwOb = new FileWriter("output.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();

    }


    public void movePlayer(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_UP) {
            playerY -= 1;

        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            playerY += 1;

        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            playerX -= 1;

        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerX += 1;

        }

    }






    @Override
    public String toString() {
        String result = " ";
        for(ArrayList<Space> row: rows) {
            //Create a String representation of this row.
            String rowString = "";
            for(Space drop : row) {
                rowString += drop.toString() + " ";
            }
            result += rowString + "\n";
        }
        return result;
    }
}
