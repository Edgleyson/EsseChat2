package esse.chat.control;

import esse.chat.model.Chatter;
import esse.chat.model.ChatRoom;
import esse.chat.persistence.ChatRoomList;
import esse.chat.persistence.ChatterDao;
import esse.chat.persistence.ChatterDaoJDBC;
import esse.chat.persistence.ChatterDaoJPA;
import esse.chat.persistence.Fabrica;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
Permite que os usuários salvem suas informações pessoais.
@author Equipe ESSE Chat
*/
public class SaveInfoServlet extends HttpServlet
{

	String contextPath = null;
        private static final String tipo = "JDBC";
    
        

	

        @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
            ChatterDao chatterDao = Fabrica.FabricaMethod(tipo).createChatterDAO();
            ServletContext context = request.getServletContext();
            HttpSession session = request.getSession();
            
            try {
                contextPath = request.getContextPath();
                ChatRoomList roomlist = (ChatRoomList) context.getAttribute("myListRooms");
                String room = (String)session.getAttribute("roomname");
                ChatRoom chatRoom = roomlist.getRoom(room);
                
                String name = request.getParameter("name");
                String nickname = request.getParameter("nickname");
                nickname = nickname.trim().toUpperCase();
                String sexo = request.getParameter("sex");
                String email = request.getParameter("email");
                String checkEmail = request.getParameter("email2");
                String senha = request.getParameter("senha");
                String novaSenha = request.getParameter("senha1");
                if(novaSenha == null || novaSenha.equals("")){novaSenha = "nulo";}
                String checkNovaSenha = request.getParameter("senha2");
                if(checkNovaSenha == null || checkNovaSenha.equals("")){checkNovaSenha = "nulo";}
                
                if(name.equals("") || null == name){
                    response.sendRedirect(contextPath + "/editInfo.jsp?onome=nulo");
                    return;
                }
                if(nickname.equals("") || null == nickname){
                    response.sendRedirect(contextPath + "/editInfo.jsp?onick=nulo");
                    return;
                }
                if(email.equals("") || null == email){
                    response.sendRedirect(contextPath + "/editInfo.jsp?oemail=nulo");
                    return;
                }
                if(!(email.equals(checkEmail))){
                    response.sendRedirect(contextPath + "/editInfo.jsp?ocheckemail=nulo");
                    return;
                }
                if(senha.equals("") || null == senha){
                    response.sendRedirect(contextPath + "/editInfo.jsp?asenha=nulo");
                    return;
                }
                Object obj = session.getAttribute("chatterid");
                String id = obj.toString();
                long chatterId = Long.parseLong(id);
                Chatter esseChatter = chatRoom.getChatter(chatterId);
                String chatterSenha = esseChatter.getSenha();
                if(!(senha.equals(chatterSenha))){
                    response.sendRedirect(contextPath + "/editInfo.jsp?ochecksenha=nulo");
                    return;
                }
                
                if(!(checkNovaSenha.equals(novaSenha))){
                        response.sendRedirect(contextPath + "/editInfo.jsp?onovasenha=nulo");
                        return;
                }
                
                if("nulo".equals(novaSenha)){
                    if("nulo".equals(checkNovaSenha)){
                                          
                        esseChatter.setName(name);
                        esseChatter.setNick(nickname);
                        esseChatter.setSex(sexo);
                        esseChatter.setEmail(email);
                        boolean b = chatterDao.atualizarDados(esseChatter);
                            if(b){
                                response.sendRedirect(contextPath + "/cadastrado.jsp?nick=nickname");
                            }   
                    }
                }else{
                    esseChatter.setName(name);
                    esseChatter.setNick(nickname);
                    esseChatter.setSex(sexo);
                    esseChatter.setEmail(email);
                    esseChatter.setSenha(novaSenha);
                    boolean b = chatterDao.atualizarDados(esseChatter);
                    if(b){
                        response.sendRedirect(contextPath + "/cadastrado.jsp?nick=nickname");
                        
                    }
                }
                
            } catch (IOException | SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}