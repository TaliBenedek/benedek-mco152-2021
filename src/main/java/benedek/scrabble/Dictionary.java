package benedek.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Dictionary {
    private final Map<String, String> wordsToDefinitions = new HashMap<>();


    public Dictionary() throws FileNotFoundException
    {
        Scanner inputFile = new Scanner(new FileReader("src/main/resources/dictionary.txt"));
        while(inputFile.hasNextLine())
        {
            wordsToDefinitions.put(inputFile.next(), // key
                    inputFile.nextLine().trim() // value
            );
        }
    }

    /**
     * @param word to be searched for in the dictionary
     * @return a boolean value reflecting if the word was found or not
     * */
    public boolean findWord(String word)
    {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    /**
     * @param word whose definition is to be returned
     * @return definition of the word or "" if the word does not exist
     */
    public String getDefinition(String word)
    {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size()
    {
        return wordsToDefinitions.size();
    }
}


