package benedek.webapp;

import benedek.scrabble.Dictionary;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;

class WordServletTest
{
    @Test
    public void doGet() throws IOException
    {
        // given
        WordServlet servlet = new WordServlet();
        Dictionary dictionary = new Dictionary();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("binary").when(request).getParameter("word");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(dictionary.getDefinition("binary"));
    }
}