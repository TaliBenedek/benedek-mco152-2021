package benedek.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {
    @Test
    public void testFindWord() {
        try
        {
            Dictionary dictionary = new Dictionary("C:\\Users\\talib\\Documents\\Tali\\dictionary.txt");
            //test a word that exists in the dictionary
            String validWord = "ATT";
            Assert.assertTrue(dictionary.findWord(validWord));

            //test a word that does not exist in the dictionary
            String invalidWord = "sjknvkjsdn";
            Assert.assertFalse(dictionary.findWord(invalidWord));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
