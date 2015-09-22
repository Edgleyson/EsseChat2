package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import esse.chat.model.*;

public final class listrooms_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/pageheader.html");
    _jspx_dependants.add("/footer.jsp");
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>ESSE Chat: Lista de salas</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\">\r\n");
      out.write("        <meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)\">\t\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            if (window.top !== window.self)\r\n");
      out.write("            {\r\n");
      out.write("                window.top.location = window.location;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body bgcolor=\"#FFFFFF\">\r\n");
      out.write("        ");



        String nickname = (String)session.getAttribute("nickname");
        if (nickname == null || nickname == "")
        {
                response.sendRedirect("login.jsp");
        }
        else
        {
                String roomname = request.getParameter("rn");	
                String descr = request.getParameter("sd");
                boolean see = false;
                if (descr != null && descr.equals("y"))
                {
                        see = true;
                }
        
      out.write("\r\n");
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
      out.write("        <section>\r\n");
      out.write("            <p>Bem-vindo <span class=\"chattername\">");
      out.print(nickname);
      out.write("</span></p>\r\n");
      out.write("            <p>Escolha uma sala para entrar! Você pode ver antes uma breve descrição da sala clicando em \"Visualizar descrição\".</p>\r\n");
      out.write("\r\n");
      out.write("            ");

				
		
                    try
                    {
                            ServletContext context = getServletContext();
                            ChatRoomList roomlist = (ChatRoomList)context.getAttribute("MyListRoom");
                            ChatRoom[] chatrooms = roomlist.getRoomListArray();
                            if(roomname == null)
                            {
                               roomname = roomlist.getRoomOfChatter(nickname).getName();
                            }
                            

            
      out.write("\r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <center>\r\n");
      out.write("                    <form name=\"chatrooms\" action=\"");
      out.print(request.getContextPath());
      out.write("/start.jsp\" method=\"post\">\r\n");
      out.write("                        <table id=\"lista\"  width=\"70%\" border=\"1\" cellspacing=\"1\" cellpadding=\"1\" align=\"rigth\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th colspan=\"2\" class=\"pagetitle\">Lista de Salas disponíveis</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                                            for (int i = 0; i < chatrooms.length; i++)
                                            {
                                                    if (chatrooms[i].getName().equals("SalaVip"))
                                                            continue;
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td width=\"50%\">\r\n");
      out.write("                                    <input type=radio name=\"rn\" value=\"");
      out.print(chatrooms[i].getName());
      out.write("\"\r\n");
      out.write("                                           ");
if (chatrooms[i].getName().equals(roomname))
			out.write("checked");
      out.write('>');
      out.print(chatrooms[i].getName());
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                                ");

                                                        if (see == true && chatrooms[i].getName().equals(roomname))
                                                        {
                                
      out.write("\t\r\n");
      out.write("                                <td width=\"50%\">");
      out.print(chatrooms[i].getDescription());
      out.write("</td>\r\n");
      out.write("                                ");

                                                        }
                                                        else
                                                        {
                                
      out.write("\r\n");
      out.write("                                <td width=\"50%\"><A href=\"");
      out.print(request.getContextPath());
      out.write("/listrooms.jsp?rn=");
      out.print(chatrooms[i].getName());
      out.write("&sd=y\">Visualizar Descrição</A></td>\r\n");
      out.write("                                        ");

                                                                }
                                        
      out.write("\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            ");

                                            }
                                    }
                                    catch (Exception e)
                                    {
                                            System.out.println("Não foi possível obter o Servlet Context: " + e.getMessage());
                                            e.printStackTrace();
                                    }
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>&nbsp;<a href=\"");
      out.print(request.getContextPath());
      out.write("/addRoom.jsp\" title=\"Add new Room\">Adicionar Nova Sala</a></td>\r\n");
      out.write("                                <td><input type=\"Submit\" value=\"Entrar na sala\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                </center>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        ");

                }
        
      out.write("\r\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<ul>\r\n");
      out.write("    ");

		String n = (String)session.getAttribute("nickname");
		if (n != null && n.length() > 0)
		{
			out.write("<li><a href=\"logout.jsp\">Sair</a></li>");
                     	out.write("<li><a href=\"listrooms.jsp\">Atualizar Lista</a></li>");
		}

      out.write(" \r\n");
      out.write("</ul>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
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
