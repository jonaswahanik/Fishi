
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Random;

class Fish {
    //creates a new hashmap called fishi and creates a new list called wordToWin
    List<String> wordToWin = new ArrayList<>();
    Map<String, Integer> fishi = new HashMap<>();

    //puts fishies into a map with their name and rarity
    public void addFishi(String name, int rarity) {
        fishi.put(name, rarity);

    }

    public int getRarity(String name) {
        return fishi.get(name);
    }

    public void fillWordsToWin() {
        //fills array list with words from word list(words.txt)
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/words.txt"));
            String nextWord;
            while ((nextWord = br.readLine()) != null) {
                wordToWin.add(nextWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //picks random word from the word list.
    public String catcherWord(String fishName) {
        Random ran = new Random();
        return wordToWin.get(ran.nextInt(wordToWin.size()));
    }
    //if user guess is equal to it returns the word
    public Boolean didCatch(String userGuess, String wordToCatch) {
        return userGuess.equals(wordToCatch);
    }



    //picks random fish from the list of all the fish
    public String pickRandomFish(){
        Set<String> keySet = fishi.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int randIdx = new Random().nextInt(size);

        String randomKey = keyList.get(randIdx);
        Integer randomValue = fishi.get(randomKey);

        return randomKey;

    }

    //puts diffrent fish into the fish array, the numbers are the rarities.
    // the keys are the fish breeds and the values are their rarities.
    public void addBulkFish() {
        fishi.put("Anchovies", 100);
        fishi.put("Black Cod", 101);
        fishi.put("Bream", 102);
        fishi.put("arp", 103);
        fishi.put("Clam", 104);
        fishi.put("Cod", 105);
        fishi.put("Coley", 106);
        fishi.put("Crab", 307);
        fishi.put("Crayfish", 208);
        fishi.put("Cuttlefish", 409);
        fishi.put("Eel", 310);
        fishi.put("Flounder", 211);
        fishi.put("Goosenecks", 312);
        fishi.put("Grey Mullet", 113);
        fishi.put("Gurnard", 114);
        fishi.put("Haddock", 115);
        fishi.put("Hake", 116);
        fishi.put("Halibut", 170);
        fishi.put("Herring", 117);
        fishi.put("King Crab", 418);
        fishi.put("Kingfish", 219);
        fishi.put("Kingklip", 220);
        fishi.put("Langoustine", 121);
        fishi.put("Lemon Sole", 122);
        fishi.put("Mackerel", 123);
        fishi.put("Mahi Mahi", 324);
        fishi.put("Monkfish", 225);
        fishi.put("Mussel", 126);
        fishi.put("Octopus", 227);
        fishi.put("Oysters", 128);
        fishi.put("Patagonian Toothfish", 329);
        fishi.put("Pike", 231);
        fishi.put("Prawns", 232);
        fishi.put("Red Mullet", 233);
        fishi.put("Red Snapper", 234);
        fishi.put("Salmon", 135);
        fishi.put("Sardine", 136);
        fishi.put("Scallops", 137);
        fishi.put("Sea Bass", 138);
        fishi.put("Sea Urchins", 139);
        fishi.put("Seaweed", 140);
        fishi.put("Shrimps", 141);
        fishi.put("Silver Pomfret", 142);
        fishi.put("Snail", 143);
        fishi.put("Squid", 244);
        fishi.put("Stone Bass", 245);
        fishi.put("Sturgeon", 246);
        fishi.put("Swordfish", 447);
        fishi.put("Gunfish", 348);
        fishi.put("Trout", 149);
        fishi.put("Iraq Lobster", 550);
        fishi.put("Tuna", 151);
        fishi.put("Wolf Fish", 252);
        fishi.put("Yellowtail", 153);
        fishi.put("Bigfish", 254);
        fishi.put("Jonasfish", 455);
        fishi.put("Durgfish", 456);
        fishi.put("Alwynfish(short as hell)", 457);
        fishi.put("Chuglobster", 458);
        fishi.put("Smokey Trout", 359);
        fishi.put("Harpermacoral", 460);
        fishi.put("Jaclam", 461);
        fishi.put("Hammerhead Shark", 562);
        fishi.put("Megaladon", 563);
    }

    //stores fish into the text file "output.txt"
    public void storeFish(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt"), true));
            writer.write("\n"+ str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //accesses the fish and allows them to be printed
    public void readStoredFish() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            System.out.println("You have caught: ");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


