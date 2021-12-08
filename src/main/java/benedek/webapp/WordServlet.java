package benedek.webapp;

import benedek.scrabble.Dictionary;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WordServlet extends HttpServlet
{
    private final Dictionary dictionary;

    public WordServlet() throws IOException
    {
        dictionary = new Dictionary();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException
    {
        PrintWriter out = response.getWriter();

        String word = request.getParameter("word");
        String definition = dictionary.getDefinition(word);
        String output = (definition.equals("")) ? "Word not found" : definition;

        out.println(output);
    }
}
