
class DefinitionServletTest
{
    @Test
    public void doGet() throws IOException, IOException
    {

        // given
        PathServlet servlet = new PathServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("binary").when(request).getParameter("word");

        // when
        servlet.doGet(request, response);

        // then
        verify(out).println(anyString());
    }
 }