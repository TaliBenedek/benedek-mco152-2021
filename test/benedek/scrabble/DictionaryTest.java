package benedek.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DictionaryTest {
    @Test
    public void testFindWord_trueUpperCase() throws FileNotFoundException {
            Dictionary dictionary = new Dictionary("dictionary.txt");
            Assert.assertTrue(dictionary.findWord("ATT"));
    }

    @Test
    public void testFindWord_trueLowerCase() throws FileNotFoundException {
        Dictionary dictionary = new Dictionary("dictionary.txt");
        Assert.assertTrue(dictionary.findWord("att"));
    }

    @Test
    public void testFindWord_trueMixedCase() throws FileNotFoundException {
        Dictionary dictionary = new Dictionary("dictionary.txt");
        Assert.assertTrue(dictionary.findWord("AtT"));
    }

    @Test
    public void testFindWord_false() throws FileNotFoundException {

        Dictionary dictionary = new Dictionary("dictionary.txt");
        Assert.assertFalse(dictionary.findWord("sjknvkjsdn"));
    }
}
