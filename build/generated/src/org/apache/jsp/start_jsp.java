package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import esse.chat.model.*;

public final class start_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    ServletContext context = request.getServletContext();
    String roomname = request.getParameter("sala");
    if(roomname!=null){
    String nickname = (String) session.getAttribute("nickname");

            ChatRoom oldChatRoom = new ChatRoom();                
            oldChatRoom = (ChatRoom)session.getAttribute("chatroom");;            
            oldChatRoom.removeChatter(nickname);
 
    ChatRoomList roomlist = (ChatRoomList)context.getAttribute("myListRooms");
  
                Chatter newChatter;
                newChatter = (Chatter)session.getAttribute("chatter");
                ChatRoom chatRoom = roomlist.getRoom(roomname);
                chatRoom.addChatter(newChatter);
        
                Message msg = new Message("system", nickname + " entrou na sala.", new java.util.Date().getTime());
                chatRoom.addMessage(msg);
                newChatter.setEnteredInRoomAt(new java.util.Date().getTime());
 
            response.sendRedirect("chat.jsp");
        } else {
            response.sendRedirect("/error.jsp");
            
        }
    

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
