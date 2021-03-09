package benedek.scrabble;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DictionaryTest {
    @Test
    public void testFindWord_trueUpperCase() throws FileNotFoundException {
            Dictionary dictionary = new Dictionary();
            Assert.assertTrue(dictionary.findWord("ATT"));
    }

    @Test
    public void testFindWord_trueLowerCase() throws FileNotFoundException {
        Dictionary dictionary = new Dictionary();
        Assert.assertTrue(dictionary.findWord("att"));
    }

    @Test
    public void testFindWord_trueMixedCase() throws FileNotFoundException {
        Dictionary dictionary = new Dictionary();
        Assert.assertTrue(dictionary.findWord("AtT"));
    }

    @Test
    public void testFindWord_false() throws FileNotFoundException {

        Dictionary dictionary = new Dictionary();
        Assert.assertFalse(dictionary.findWord("sjknvkjsdn"));
    }

    @Test
    public void testGetDefinition_Valid() throws FileNotFoundException
    {
        Dictionary dictionary = new Dictionary();
        Assert.assertEquals("one that {slakes=v} [n -S]", dictionary.getDefinition("SLAKER"));
    }

    @Test
    public void testGetDefinition_Invalid() throws FileNotFoundException
    {
        Dictionary dictionary = new Dictionary();
        Assert.assertEquals("", dictionary.getDefinition("jsndfkjsn"));
    }
}
