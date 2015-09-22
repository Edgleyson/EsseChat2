package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import esse.chat.model.*;

public final class cadastrarMonitor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>ESSE Monitor</title>\r\n");
      out.write("        <meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)\">\t\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body onLoad=\"document.login.name.focus();\">\r\n");
      out.write("        ");

            String roomname = (String)session.getAttribute("roomname");    
        
      out.write("\r\n");
      out.write("        <p><span class=\"error\">Informe o nome completo ou nickname do aluno.</span></p>\r\n");
      out.write("        <p>Clique em submeter para cadastrá-lo como Monitor da sala ");
      out.print(roomname);
      out.write("</p>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"formcadastro\">\r\n");
      out.write("                <form name=\"login\" id=\"formCadastro\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/control/CadastraChatterServlet\">\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"name\" class=\"white\">Informe o nome: </label><br/>\r\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" size=\"30\" placeholder=\"Nome Completo\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"nick\" class=\"white\">ou o Nickname: </label><br/>\r\n");
      out.write("                    <input type=\"text\" id=\"nick\" name=\"nickname\" size=\"10\" placeholder=\"Apelido\"><br/>\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"status\" class=\"white\">Status:&nbsp;</label><br/>\r\n");
      out.write("                    <select size=\"10\" id=\"status\" name=\"status\">\r\n");
      out.write("                        <option value=\"3\">Monitor</option>\r\n");
      out.write("                        <option value=\"1\">Aluno</option>\r\n");
      out.write("                    </select><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <input type=\"submit\" class=\"botao\" name=\"Submit\" value=\"Submeter\">\r\n");
      out.write("                </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
