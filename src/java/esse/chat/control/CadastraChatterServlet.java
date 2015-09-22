package esse.chat.control;

import esse.chat.model.Chatter;
import esse.chat.persistence.ChatterDao;
import esse.chat.persistence.Fabrica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Equipe ESSE Chat
 */
public class CadastraChatterServlet extends HttpServlet {

    private static final String tipo = "JDBC";
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
            String name = request.getParameter("name");
            String nickname = request.getParameter("nickname");
            nickname = nickname.trim().toUpperCase();
            String diaNasc = request.getParameter("birthday_day");
            String mesNasc = request.getParameter("birthday_month");
            String anoNasc = request.getParameter("birthday_year");
            String nascimento = diaNasc + "-" + mesNasc + "-" + anoNasc;
            String sexo = request.getParameter("sex");
            String email = request.getParameter("email");
            String email2 = request.getParameter("email2");
            String senha = request.getParameter("senha");
            String senha2 = request.getParameter("senha2");
            String id = request.getParameter("iduser");
            int iduser = Integer.parseInt(id);

            // monta um objeto contato
            Chatter chatter = new Chatter();
            chatter.setName(name);
            chatter.setNick(nickname);
            chatter.setSenha(senha);
            chatter.setSex(sexo);
            chatter.setNascimento(nascimento);
            chatter.setEmail(email);
            chatter.setStatus(iduser);
            
            // salva o contato usando o padrão DAO
            ChatterDao chatterdao;
            chatterdao = Fabrica.FabricaMethod(tipo).createChatterDAO();
            
            boolean ok = chatterdao.inserirDados(chatter);

            if(ok){
               response.sendRedirect(request.getContextPath() + "/cadastrado.jsp?nick="+nickname); 
            }          
            else{
               response.sendRedirect("/error.jsp");  
            }

      
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
            Logger.getLogger(CadastraChatterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastraChatterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
