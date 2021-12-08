package benedek.scrabble;

import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
import static org.mockito.Mockito.*;

public class ScrabbleControllerTest
{
    @BeforeAll
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void initialize() throws FileNotFoundException
    {
        // given
        LetterBag letterBag = mock(LetterBag.class);
        Dictionary dictionary = mock(Dictionary.class);
        ScrabbleController controller = new ScrabbleController(dictionary, letterBag);
        controller.letterLabels = Arrays.asList(
                mock(Label.class),
                mock(Label.class),
                mock(Label.class)
        );
        doReturn("T",
                "G",
                "L")
                .when(letterBag).nextLetter();

        // when
        controller.initialize();

        // then
        verify(controller.letterLabels.get(0)).setText("T");
        verify(controller.letterLabels.get(1)).setText("G");
        verify(controller.letterLabels.get(2)).setText("L");
        verify(letterBag, times(3)).nextLetter();
    }
}
