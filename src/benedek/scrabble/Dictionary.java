package benedek.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    private final Scanner inputFile;

    public Dictionary(String fileName) throws FileNotFoundException
    {
        try
        {
            File file = new File(fileName);
            inputFile = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    /**
     * @param word to be searched for in the dictionary
     * @return a boolean value reflecting if the word was found or not
     * */
    public boolean findWord(String word)
    {
        boolean found = false;
        while(inputFile.hasNextLine())
        {
            String currLine = inputFile.nextLine().toLowerCase();
            if(currLine.startsWith(word.toLowerCase()))
            {
                found = true;
                break;
            }
        }
        return found;
    }
}


