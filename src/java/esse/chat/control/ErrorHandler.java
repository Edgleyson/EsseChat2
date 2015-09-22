/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.control;

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
public class ErrorHandler extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
            processError(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ErrorHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            processError(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ErrorHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        
        String admin = getServletContext().getInitParameter("adminEmail");
        String contextPath = request.getContextPath();
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
 
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
            if (requestUri == null) {
            	requestUri = "desconehcido";
            }
        String erro = throwable.toString();
        String nomeErro = throwable.getClass().getName();
        String subject = "Erro " +statusCode+ ": " +nomeErro+ "na URL: ..."+requestUri;

       response.setContentType("text/html;charset=UTF-8");
        // busca o writer
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->");
            out.println("<html>");
            out.println("  <head>");
            out.println("     <title>ESSE ERRO</title>");
            out.println("     <meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)\">");
            out.println("     <link rel=\"stylesheet\" href=\""+contextPath+"/erro.css\" type=\"text/css\">");
            out.println("  </head>");
            out.println("  <body>");
            out.println("     <header>");
            out.println("     <h2 class=\"error\">Oops! Alguma coisa quebrou do lado de cá!</h2>");
            out.println("     <p>Ajude-nos a consertar, envie um email para: <a href=\"mailto:"+admin+"?subject="+subject+"\">"+admin+"</a></p>");
            out.println("     <p>informando o erro "+statusCode+": "+nomeErro+"</p>");
            out.println("     <p>na URL: ..."+requestUri+"</p>");
            out.println("     <p>Clique em: <a href=\""+contextPath+"/login.jsp\">Tire-me daqui</a> para ir a nossa homepage!</p>");
            out.println("     </header>");
            out.println("  </body>");
            out.println("</html>");
        }
                
    }


}
