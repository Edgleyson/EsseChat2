package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>ESSE Chat: Cadastro</title>\r\n");
      out.write("        <script>\r\n");
      out.write("        if(window.top !== window.self)\r\n");
      out.write("        {\r\n");
      out.write("            window.top.location = window.location;\r\n");
      out.write("        }\r\n");
      out.write("        </script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/chat.css\">\r\n");
      out.write("        <meta name=\"Author\" content=\"Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body onLoad=\"document.login.name.focus();\">\r\n");
      out.write("        <div class=\"formcadastro\">\r\n");
      out.write("                <form name=\"login\" id=\"formCadastro\" method=\"post\" action=\"");
      out.print(request.getContextPath());
      out.write("/control/CadastraChatterServlet\">\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"name\" class=\"white\">Nome: </label><br/>\r\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" size=\"30\" placeholder=\"Nome Completo\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"nick\" class=\"white\">Nickname: </label><br/>\r\n");
      out.write("                    <input type=\"text\" id=\"nick\" name=\"nickname\" size=\"10\" placeholder=\"Apelido\"><br/>\r\n");
      out.write("\r\n");
      out.write("                    <select aria-label=\"Dia\" name=\"birthday_day\" id=\"day\" title=\"Dia\" class=\"_5dba\">\r\n");
      out.write("        <option value=\"0\">Dia</option>\r\n");
      out.write("        <option value=\"1\">1</option>\r\n");
      out.write("        <option value=\"2\">2</option>\r\n");
      out.write("        <option value=\"3\">3</option>\r\n");
      out.write("        <option value=\"4\">4</option>\r\n");
      out.write("        <option value=\"5\">5</option>\r\n");
      out.write("        <option value=\"6\">6</option>\r\n");
      out.write("        <option value=\"7\">7</option>\r\n");
      out.write("        <option value=\"8\">8</option>\r\n");
      out.write("        <option value=\"9\">9</option>\r\n");
      out.write("        <option value=\"10\">10</option>\r\n");
      out.write("        <option value=\"11\">11</option>\r\n");
      out.write("        <option value=\"12\">12</option>\r\n");
      out.write("        <option value=\"13\">13</option>\r\n");
      out.write("        <option value=\"14\">14</option>\r\n");
      out.write("        <option value=\"15\">15</option>\r\n");
      out.write("        <option value=\"16\">16</option>\r\n");
      out.write("        <option value=\"17\">17</option>\r\n");
      out.write("        <option value=\"18\">18</option>\r\n");
      out.write("        <option value=\"19\">19</option>\r\n");
      out.write("        <option value=\"20\">20</option>\r\n");
      out.write("        <option value=\"21\">21</option>\r\n");
      out.write("        <option value=\"22\">22</option>\r\n");
      out.write("        <option value=\"23\">23</option>\r\n");
      out.write("        <option value=\"24\">24</option>\r\n");
      out.write("        <option value=\"25\">25</option>\r\n");
      out.write("        <option value=\"26\">26</option>\r\n");
      out.write("        <option value=\"27\">27</option>\r\n");
      out.write("        <option value=\"28\">28</option>\r\n");
      out.write("        <option value=\"29\">29</option>\r\n");
      out.write("        <option value=\"30\">30</option>\r\n");
      out.write("        <option value=\"31\">31</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <select aria-label=\"M&#xea;s\" name=\"birthday_month\" id=\"month\" title=\"M&#xea;s\" class=\"_5dba\">\r\n");
      out.write("        <option value=\"0\">Mês</option>\r\n");
      out.write("        <option value=\"1\">Jan</option>\r\n");
      out.write("        <option value=\"2\">Fev</option>\r\n");
      out.write("        <option value=\"3\">Mar</option>\r\n");
      out.write("        <option value=\"4\">Abr</option>\r\n");
      out.write("        <option value=\"5\">Maio</option>\r\n");
      out.write("        <option value=\"6\">Jun</option>\r\n");
      out.write("        <option value=\"7\">Jul</option>\r\n");
      out.write("        <option value=\"8\">Ago</option>\r\n");
      out.write("        <option value=\"9\">Set</option>\r\n");
      out.write("        <option value=\"10\">Out</option>\r\n");
      out.write("        <option value=\"11\">Nov</option>\r\n");
      out.write("        <option value=\"12\">Dez</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <select aria-label=\"Ano\" name=\"birthday_year\" id=\"year\" title=\"Ano\" class=\"_5dba\">\r\n");
      out.write("        <option value=\"0\">Ano</option>\r\n");
      out.write("        <option value=\"2000\">2000</option>\r\n");
      out.write("        <option value=\"1999\">1999</option>\r\n");
      out.write("        <option value=\"1998\">1998</option>\r\n");
      out.write("        <option value=\"1997\">1997</option>\r\n");
      out.write("        <option value=\"1996\">1996</option>\r\n");
      out.write("        <option value=\"1995\">1995</option>\r\n");
      out.write("        <option value=\"1994\">1994</option>\r\n");
      out.write("        <option value=\"1993\">1993</option>\r\n");
      out.write("        <option value=\"1992\">1992</option>\r\n");
      out.write("        <option value=\"1991\">1991</option>\r\n");
      out.write("        <option value=\"1990\">1990</option>\r\n");
      out.write("        <option value=\"1989\">1989</option>\r\n");
      out.write("        <option value=\"1988\">1988</option>\r\n");
      out.write("        <option value=\"1987\">1987</option>\r\n");
      out.write("        <option value=\"1986\">1986</option>\r\n");
      out.write("        <option value=\"1985\">1985</option>\r\n");
      out.write("        <option value=\"1984\">1984</option>\r\n");
      out.write("        <option value=\"1983\">1983</option>\r\n");
      out.write("        <option value=\"1982\">1982</option>\r\n");
      out.write("        <option value=\"1981\">1981</option>\r\n");
      out.write("        <option value=\"1980\">1980</option>\r\n");
      out.write("        <option value=\"1979\">1979</option>\r\n");
      out.write("        <option value=\"1978\">1978</option>\r\n");
      out.write("        <option value=\"1977\">1977</option>\r\n");
      out.write("        <option value=\"1976\">1976</option>\r\n");
      out.write("        <option value=\"1975\">1975</option>\r\n");
      out.write("        <option value=\"1974\">1974</option>\r\n");
      out.write("        <option value=\"1973\">1973</option>\r\n");
      out.write("        <option value=\"1972\">1972</option>\r\n");
      out.write("        <option value=\"1971\">1971</option>\r\n");
      out.write("        <option value=\"1970\">1970</option>\r\n");
      out.write("        <option value=\"1969\">1969</option>\r\n");
      out.write("        <option value=\"1968\">1968</option>\r\n");
      out.write("        <option value=\"1967\">1967</option>\r\n");
      out.write("        <option value=\"1966\">1966</option>\r\n");
      out.write("        <option value=\"1965\">1965</option>\r\n");
      out.write("        <option value=\"1964\">1964</option>\r\n");
      out.write("        <option value=\"1963\">1963</option>\r\n");
      out.write("        <option value=\"1962\">1962</option>\r\n");
      out.write("        <option value=\"1961\">1961</option>\r\n");
      out.write("        <option value=\"1960\">1960</option>\r\n");
      out.write("        <option value=\"1959\">1959</option>\r\n");
      out.write("        <option value=\"1958\">1958</option>\r\n");
      out.write("        <option value=\"1957\">1957</option>\r\n");
      out.write("        <option value=\"1956\">1956</option>\r\n");
      out.write("        <option value=\"1955\">1955</option>\r\n");
      out.write("        <option value=\"1954\">1954</option>\r\n");
      out.write("        <option value=\"1953\">1953</option>\r\n");
      out.write("        <option value=\"1952\">1952</option>\r\n");
      out.write("        <option value=\"1951\">1951</option>\r\n");
      out.write("        <option value=\"1950\">1950</option>\r\n");
      out.write("        <option value=\"1949\">1949</option>\r\n");
      out.write("        <option value=\"1948\">1948</option>\r\n");
      out.write("        <option value=\"1947\">1947</option>\r\n");
      out.write("        <option value=\"1946\">1946</option>\r\n");
      out.write("        <option value=\"1945\">1945</option>\r\n");
      out.write("        <option value=\"1944\">1944</option>\r\n");
      out.write("        <option value=\"1943\">1943</option>\r\n");
      out.write("        <option value=\"1942\">1942</option>\r\n");
      out.write("        <option value=\"1941\">1941</option>\r\n");
      out.write("        <option value=\"1940\">1940</option>\r\n");
      out.write("        <option value=\"1939\">1939</option>\r\n");
      out.write("        <option value=\"1938\">1938</option>\r\n");
      out.write("        <option value=\"1937\">1937</option>\r\n");
      out.write("        <option value=\"1936\">1936</option>\r\n");
      out.write("        <option value=\"1935\">1935</option>\r\n");
      out.write("        <option value=\"1934\">1934</option>\r\n");
      out.write("        <option value=\"1933\">1933</option>\r\n");
      out.write("        <option value=\"1932\">1932</option>\r\n");
      out.write("        <option value=\"1931\">1931</option>\r\n");
      out.write("        <option value=\"1930\">1930</option>\r\n");
      out.write("        <option value=\"1929\">1929</option>\r\n");
      out.write("        <option value=\"1928\">1928</option>\r\n");
      out.write("        <option value=\"1927\">1927</option>\r\n");
      out.write("        <option value=\"1926\">1926</option>\r\n");
      out.write("        <option value=\"1925\">1925</option>\r\n");
      out.write("        <option value=\"1924\">1924</option>\r\n");
      out.write("    </select>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"nasc\" class=\"white\">Data de nascimento: </label><br/>\r\n");
      out.write("                    <input type=\"text\" id=\"nasc\" name=\"data\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"sex\" class=\"white\">Sexo:&nbsp;</label><br/>\r\n");
      out.write("                    <select size=\"1\" id=\"sex\" name=\"sex\">\r\n");
      out.write("                        <option value=\"m\">\r\n");
      out.write("                            Masculino\r\n");
      out.write("                        </option>\r\n");
      out.write("                        <option value=\"f\">\r\n");
      out.write("                            Feminino\r\n");
      out.write("                        </option>\r\n");
      out.write("                    </select><br/>\r\n");
      out.write("                    <label for=\"email\" class=\"white\">E-mail: </label><br/>\r\n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" size=\"30\" placeholder=\"seuemail@com\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"email2\" class=\"white\">Confirme seu E-mail: </label><br/>\r\n");
      out.write("                    <input type=\"email\" id=\"email2\" name=\"email2\" size=\"30\" placeholder=\"seuemail@com\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"senha\" class=\"white\">Digite uma Senha: </label><br/>\r\n");
      out.write("                    <input type=\"password\" id=\"senha\" name=\"senha\" size=\"10\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"senha2\" class=\"white\">Confirme sua Senha: </label><br/>\r\n");
      out.write("                    <input type=\"password\" id=\"senha2\" name=\"senha2\" size=\"10\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("                    <input type=\"hidden\" name=\"iduser\" value=\"1\"><br/>\r\n");
      out.write("                    \r\n");
      out.write("         <input type=\"submit\" class=\"botao\" name=\"Submit\" value=\"Cadastrar\">\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
