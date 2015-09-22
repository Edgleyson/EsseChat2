package esse.chat.control;

import esse.chat.model.ChatRoom;
import esse.chat.model.Chatter;
import esse.chat.persistence.ChatRoomDao;
import esse.chat.persistence.ChatRoomList;
import esse.chat.persistence.ChatterDao;
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
 *
 * @author Equipe ESSE Chat
 */
public class CadastraMonitorServlet extends HttpServlet {

    private String contextPath = "";
    private static final String tipo = "JDBC";
    ChatterDao chatterDao = Fabrica.FabricaMethod(tipo).createChatterDAO();
    ChatRoomDao roomDao = Fabrica.FabricaMethod(tipo).createChatRoomDAO();
   // ChatterDaoJDBC chatteDao = new ChatterDaoJDBC();
   // ChatRoomDaoJDBC roomDao = new ChatRoomDaoJDBC();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        // busca o writer
        try (PrintWriter out = response.getWriter()) {
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastraMonitorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = request.getServletContext();
        HttpSession session = request.getSession();
        
        try {
            
            String nickname = request.getParameter("nickDoAluno");
            nickname = nickname.trim().toUpperCase();
            String typeMonitor = request.getParameter("typeMonitor");
            String roomName = (String)session.getAttribute("roomname");
            
            contextPath = request.getContextPath();
                ChatRoomList roomlist = (ChatRoomList) context.getAttribute("myListRooms");
                ChatRoom chatRoom = roomlist.getRoom(roomName);
                
            Chatter chatter = chatterDao.pesquisarDados(nickname);
            String nick = chatter.getNick();
            Long chatterId;
            boolean ok = false;
            if(nick==null){
                request.setAttribute("error", "Nickname informado não existe no banco de dados dESSE Chat!");
		context.getRequestDispatcher("/cadastrarMonitor.jsp").forward(request, response);
            }
                if(typeMonitor.equals("m1")){
                chatterId = chatter.getId();
                ok = roomDao.cadastrarMonitor1(chatterId, chatRoom.getRoomid());
                    if(ok){
                        chatRoom.setMonitor1(chatterId);
                        response.sendRedirect(contextPath + "/monitorCadastrado.jsp?nick="+nick+"&room="+roomName);
                    }else{
                        request.setAttribute("error", "Desculpe-nos! Ocorreu um erro de conexão e o monitor não foi cadastrado");
                        context.getRequestDispatcher("/cadastrarMonitor.jsp").forward(request, response);
                    }
                }else if(typeMonitor.equals("m2")){
                    chatterId = chatter.getId();
                    ok = roomDao.cadastrarMonitor2(chatterId, chatRoom.getRoomid());
                    if(ok){
                        chatRoom.setMonitor2(chatterId);
                        response.sendRedirect(contextPath + "/monitorCadastrado.jsp?nick="+nick+"&room="+roomName);
                    }else{
                        request.setAttribute("error", "Desculpe-nos! Ocorreu um erro de conexão e o monitor não foi cadastrado");
                        context.getRequestDispatcher("/cadastrarMonitor.jsp").forward(request, response);
                    }
                }else{
                    chatterId = chatter.getId();
                    ok = roomDao.cadastrarProfessor(chatterId, chatRoom.getRoomid());
                    if(ok){
                        chatRoom.setProfessor(chatterId);
                        response.sendRedirect(contextPath + "/monitorCadastrado.jsp?prof=prof&nick="+nick+"&room="+roomName);
                    }else{
                        request.setAttribute("error", "Desculpe-nos! Ocorreu um erro de conexão e o monitor não foi cadastrado");
                        context.getRequestDispatcher("/cadastrarMonitor.jsp").forward(request, response);
                    }
                }
            
        }catch (IOException | SQLException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
