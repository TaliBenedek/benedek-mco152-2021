package benedek.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    private final Scanner inputFile;
    private final ArrayList<String> words = new ArrayList<>();
    private final String[] dictArray;

    public Dictionary(String fileName) throws FileNotFoundException
    {
        inputFile = new Scanner(new File(fileName));
        while(inputFile.hasNextLine())
        {
            String[] line = inputFile.nextLine().split(" ");
            words.add(line[0].toUpperCase());
        }
        dictArray = words.toArray(new String[0]);
        Arrays.sort(dictArray);
    }

    /**
     * @param word to be searched for in the dictionary
     * @return a boolean value reflecting if the word was found or not
     * */
    public boolean findWord(String word)
    {
        return Arrays.binarySearch(dictArray, word.toUpperCase()) > 0;
    }
}


