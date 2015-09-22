package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import esse.chat.model.*;

public final class cadastrado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        ");

        String nickname = request.getParameter("nick");
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <section id=\"logout\">\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <center>\r\n");
      out.write("                <font color=\"blue\">Nickname: ");
      out.print(nickname);
      out.write(" cadastrado com sucesso!</font><br>\r\n");
      out.write("                <a href=\"login.jsp\">Fazer Login agora</a>\r\n");
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
