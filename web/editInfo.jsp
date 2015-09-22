<%@page import="esse.chat.persistence.ChatRoomList"%>
<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page isErrorPage="false" errorPage="error.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,esse.chat.model.*"%>

<%
    String nickname = (String) session.getAttribute("nickname");
    if (nickname == null) {
        out.write("<font color=\"red\" size=\"+1\">Você não está logado.</font>");
        out.close();
        return;
    }
    ServletContext context = request.getServletContext();
    ChatRoomList roomList = (ChatRoomList)context.getAttribute("myListRooms");
    Object obj = session.getAttribute("chatterid");
    String id = obj.toString();
    long chatterId = Long.parseLong(id);
    ChatRoom chatRoom = roomList.getRoomOfChatter(chatterId);
    if (chatRoom != null) {
        Chatter chatter = chatRoom.getChatter(chatterId);
        String nome = chatter.getName();
        String nick = chatter.getNick();
        String sexo = chatter.getSex();
        String nasc = chatter.getNascimento();
        String email = chatter.getEmail();
        int status = chatter.getStatus();
        String password = chatter.getSenha();
        
%>
<html>
    <head>
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
        <title><%=chatter.getNick()%> Perfil</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
    </head>

    <body>
    <header>
            <%@ include file="pageheader.html" %>
    </header> 
    <section>
        <%
            String onome = request.getParameter("onome");
            String onick =request.getParameter("onick");
            String oemail = request.getParameter("oemail");
            String ocheckemail = request.getParameter("ocheckemail");
            String asenha = request.getParameter("asenha");
            String ochecksenha = request.getParameter("ochecksenha");
            String onovasenha = request.getParameter("onovasenha");
		
                if (onome != null && onome.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! O nome do usuário estava em branco no envio das informações!</span></p>
            <%
                }
                else if (onick != null && onick.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! Seu Nickname estava em branco no envio das informações!</span></p>
            <%
                }
                else if (oemail != null && oemail.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! Seu email estava em branco no envio das informações!</span></p>
            <%
                }
                else if (ocheckemail != null && ocheckemail.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! Seu email confirmado precisa ser igual ao email!</span></p>
            <%
                }
                else if (asenha != null && asenha.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! A senha precisa ser informada para salvar as alterações!</span></p>
            <%
                }
                else if (ochecksenha != null && ochecksenha.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! A senha informada está incorreta. Tente novamente!</span></p>
            <%
                }
                else if (onovasenha != null && onovasenha.equals("nulo"))
                {
            %>
            <p class="geral"><span class="error">Desculpe! A confirmação da nova senha precisa ser igual a nova senha. Tente novamente!</span></p>
            <%
                }

            %>
            
                <div class="formcadastro">
                <form name="chatterinfo" method="post" action="<%=request.getContextPath()%>/control/SaveInfoServlet">

                    <label for="name" class="white">Nome: </label><br/>
                    <input type="text" id="name" name="name" size="30" value="<%=nome%>"><br/>
                    
                    <label for="nick" class="white">Nickname: </label><br/>
                    <input type="text" id="nick" name="nickname" size="10" value="<%=nick%>"><br/>

                    <label for="sex" class="white">Sexo:&nbsp;</label><br/>
                    <%
                       String valor;
                        if(sexo.equals("Masculino")) {
                           valor = "m";
                       }else{
                           valor = "f";
                       }
                    %>
                    <select size="1" id="sex" name="sex" value="<%=valor%>">
                        <option value="m">
                            Masculino
                        </option>
                        <option value="f">
                            Feminino
                        </option>
                    </select><br/>
                    <label for="email" class="white">E-mail: </label><br/>
                    <input type="email" id="email" name="email" size="30" value="<%=email%>"><br/>
                    
                    <label for="email2" class="white">Confirme seu E-mail: </label><br/>
                    <input type="email" id="email2" name="email2" size="30" value="<%=email%>"><br/>
                    
                    <span class="white">Para salvar alterações:</span><br/>
                    <label for="senha" class="white">Digite a senha atual: </label>
                    <input type="password" id="senha" name="senha" size="13"><br/>
                    
                    <span class="white">Alterar senha (opcional):</span><br/>
                    <label for="novasenha" class="white">Digite a nova Senha: </label>
                    <input type="password" id="novasenha" name="novasenha" size="13"><br/>
                    
                    <label for="novasenha2" class="white">Confirme sua Senha: </label>
                    <input type="password" id="novasenha2" name="novasenha2" size="13"><br/>
                    
                    <center>
                    <input type="submit" class="botao" name="Submit" value="Salvar">
                    </center>

                </form>
              </div>
            <center>
            <ul class='perfil'>
            
            <li><a href="#" onclick="window.print();" title="Imprimir Perfil">Imprimir</a></li>
            <li><a href="<%=request.getContextPath()%>/listrooms.jsp" title="Voltar para lista de salas">Cancelar</a></li>
                
            </ul>
            </center>
    </section>
    </body>
</html>
<%
    } 
%>