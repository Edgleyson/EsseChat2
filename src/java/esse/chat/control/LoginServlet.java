package esse.chat.control;

import esse.chat.model.Chatter;
import esse.chat.model.ChatRoom;
import esse.chat.persistence.ChatRoomList;
import esse.chat.persistence.ChatterDao;
import esse.chat.persistence.ChatterDaoJDBC;
import esse.chat.persistence.Fabrica;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
@author Equipe ESSE Chat
*/
public class LoginServlet extends HttpServlet
{
	private String contextPath = "";
        private static final String tipo = "JDBC";
        ChatterDao chatterDao = Fabrica.FabricaMethod(tipo).createChatterDAO();
                
	/** Este método apenas redireciona usuário para uma página de login
        * @param request.
        * @param response
        * @throws javax.servlet.ServletException
        * @throws java.io.IOException*/
        @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/login.jsp");		
	}
	/** Executa alguma validação e se tudo estiver ok envia usuário para uma página que exibe uma lista de
        * salas disponíveis.
        * @param request
        * @param response
        * @throws javax.servlet.ServletException
        * @throws java.io.IOException
	*/
        @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
            ServletContext context = request.getServletContext();
            
            try {
                contextPath = request.getContextPath();
                ChatRoomList roomlist = (ChatRoomList) context.getAttribute("myListRooms");
                ChatRoom chatRoom = roomlist.getRoom("SalaVip");
                
                String nickname = request.getParameter("nickname");
                nickname = nickname.trim().toUpperCase();
                String senha = request.getParameter("senha");
                if(nickname.equals("") || null == nickname){
                    response.sendRedirect(contextPath + "/login.jsp?d=t&n=ou senha");
                }
                
                Chatter chatter = chatterDao.pesquisarDados(nickname);
                String nick = chatter.getNick();
                String name = chatter.getName();
                long chatterId = chatter.getId();
                String nasc = chatter.getNascimento();
                String email = chatter.getEmail();
                int status = chatter.getStatus();
                String sex = chatter.getSex();
                if(nick==null){
                    response.sendRedirect(contextPath + "/login.jsp?d=t&n="+nickname);
                }else{
                    String password = chatter.getSenha();
                    if(senha.equals(password)){
                        HttpSession session = request.getSession(true);
                        int timeout = 1800; // 30 minutes
                        String t = context.getInitParameter("sessionTimeout"); // gets Minutes
                        if (t != null)
                        {
                            try
                            {
                                timeout = Integer.parseInt(t);
                                timeout = timeout * 60;
                            }
                            catch (NumberFormatException nfe)
                            {
                            }
                        }
                        session.setMaxInactiveInterval(timeout);

                        chatter = new Chatter(chatterId, nick, name, sex, senha, nasc, email, status, new java.util.Date().getTime());
                        chatRoom.addChatter(chatter);
                        
                        session.setAttribute("chatroom", chatRoom);
                        
                        String roomname = chatRoom.getName();
                        session.setAttribute("chatter", chatter);
                        session.setAttribute("roomname", roomname);
                        session.setAttribute("sexo", sex);
                        session.setAttribute("senha", senha);
                        session.setAttribute("nickname", nickname);
                        session.setAttribute("chatterid", chatterId);
                        session.setAttribute("status", status);
                        response.sendRedirect(contextPath + "/listrooms.jsp");
                    }else{
                        response.sendRedirect(contextPath + "/login.jsp?ic=t");
                    }
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            
	}

