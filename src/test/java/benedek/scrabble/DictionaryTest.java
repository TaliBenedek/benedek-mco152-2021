package benedek.scrabble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class DictionaryTest
{
    @Test
    public void testFindWord_trueUpperCase() throws IOException
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertTrue(dictionary.findWord("ATT"));
    }

    @Test
    public void testFindWord_trueLowerCase() throws IOException
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertTrue(dictionary.findWord("att"));
    }

    @Test
    public void testFindWord_trueMixedCase() throws IOException
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertTrue(dictionary.findWord("AtT"));
    }

    @Test
    public void testFindWord_false() throws IOException
    {

        Dictionary dictionary = new Dictionary();
        Assertions.assertFalse(dictionary.findWord("sjknvkjsdn"));
    }

    @Test
    public void testGetDefinition_Valid() throws IOException
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertEquals("one that {slakes=v} [n -S]", dictionary.getDefinition("SLAKER"));
    }

    @Test
    public void testGetDefinition_Invalid() throws IOException
    {
        Dictionary dictionary = new Dictionary();
        Assertions.assertEquals("", dictionary.getDefinition("jsndfkjsn"));
    }
}
