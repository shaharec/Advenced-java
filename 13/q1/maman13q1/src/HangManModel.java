import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangManModel implements IHangManModel {

    private String word;
    private ArrayList<String> words;
    private String guss;
    private int lifes ;
    private final int NUM_LIFES =6;
    private final String FILE_PATH = "src/input.txt";


    public HangManModel() throws FileNotFoundException {
        fillWords(); // fill words array.
        reset(); // Start game.
    }

    // Fill words array from input file.
    private void fillWords() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILE_PATH));
        this.words = new ArrayList<>();
        while(sc.hasNext()){
            words.add(sc.nextLine());
        }
        sc.close();
    }

    /**Check if the char exsist in the word.
     * if the char exist show were to the user.
     * else reduce life of user in the game.**/
    public void handelLetter(char c){
        boolean appear = false;
        String upperCase = word.toUpperCase(); // letters on screen is in uppercase.
        for (int i = 0; i < upperCase.length(); i++) {
            if (upperCase.charAt(i) == c ) {
                appear = true;
                guss = guss.substring(0, i)
                        + c
                        + guss.substring(i + 1);
            }
        }
        if(!appear)
            lifes--;
    }

    // Restart game - select new word.
    public void reset()  {
        this.word = getNewWord();
        this.guss = new String();
        this.lifes = NUM_LIFES;
        for(int i = 0; i < word.length(); i++)
            this.guss += "_";

    }

    // Get new random word form file.
    public String getNewWord()  {
        // Select random word
        Random rnd = new Random();
        String word = words.get(rnd.nextInt(words.size()));
        while(word.equals(this.word))
            word = words.get(rnd.nextInt(words.size()));
        return word;
    }

    @Override
    public String getGuss(){
        return this.guss;
    }

    @Override
    public int getLifes() {
        return this.lifes;
    }
}
