import java.util.Random;


public class Space {
    String marker;
    String defaultMarker;
    String water;
    String player;
    // adds emojis do the grid
    {
        defaultMarker = "\uD83C\uDF32";
        water = "\uD83C\uDF0A";
        player = "\uD83D\uDC12";
    }

    public Space() {marker = defaultMarker;}

    public String toString() {
        return marker;
    }

    public void addPlayer() {
        marker = "\uD83D\uDC12";
    }

    public void addPond() {marker = "\uD83C\uDF0A";}

    public void addSwimming() {marker = "\uD83D\uDCA6";}

    public void addLandscape() {
        int min = 1;
        int max = 10;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public void removeTreasure() { marker = defaultMarker;}

}

