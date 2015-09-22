package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import esse.chat.model.*;

public final class logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/pageheader.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Logout</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\">\r\n");
      out.write("        <meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)\">\t\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<!--<meta http-equiv=\"refresh\" content=\"10\">-->\r\n");
      out.write("<meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e SÃ©rgio)\">\t\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"chat.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<header>\r\n");
      out.write("    \r\n");
      out.write("    <img src=\"images/EsseChatAnime.gif\" alt=\"ESSE Chat\">\r\n");
      out.write("\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("        <aside>\r\n");
      out.write("\r\n");
      out.write("        </aside>\r\n");
      out.write("        <section id=\"cadastrado\">\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <center>\r\n");
      out.write("                    ");

                        String nickname = (String) session.getAttribute("nickname");
                        if (nickname != null && nickname.length() > 0) {
                            ChatRoomList roomlist = (ChatRoomList) application.getAttribute("myListRoom");
                            ChatRoom chatRoom = roomlist.getRoomOfChatter(nickname);
                            chatRoom.addMessage(new Message("system", nickname + " saiu da sala.", new java.util.Date().getTime()));
                            if (chatRoom != null) {
                                chatRoom.removeChatter(nickname);
                                session.invalidate();
                                out.write("<font color=\"blue\">Você não está mais logado nESSE Chat</font><br>");
                                out.write("<a href=\"login.jsp\">Logar novamente</a>");
                            } else {
                                response.sendRedirect("login.jsp");
                            }
                        } else {
                            response.sendRedirect("login.jsp");
                        }
                    
      out.write("\r\n");
      out.write("                </center>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
