<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page errorPage="error.jsp" %>
<%
        String nickname = (String)session.getAttribute("nickname");
        if (nickname != null)
        {
                response.sendRedirect("listrooms.jsp");
        }
%>

<html>
    <head>
        <title>ESSE Chat: Login</title>
        <script>
        if(window.top !== window.self)
        {
            window.top.location = window.location;
        }
        </script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css">
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">
    </head>
    <body onLoad="document.login.nickname.focus();">
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <aside>

        </aside>
        <section>

            <%
            String d=request.getParameter("d");
            String n=request.getParameter("n");
            String ic = request.getParameter("ic");
		
                if (d!=null && d.equals("t"))
                {
            %>

            <p class="geral"><span class="error">Nickname <b><%=n%></b> inexistente</span></p>
            <p class="geral">O usuário ainda não está habilitado para utilizar ESSE Chat.</p>
            <%
              }
              else if (ic!=null && ic.equals("t"))
              {
            %>
            <p class="geral"><span class="error">Senha não confere</span></p>
            <p class="geral">Talvez você tenha digitado a senha errada por engano.</p>
            <%
              }
                String nick = request.getParameter("nick");
                if(nick == null){
                    nick = "";
                }
            %>
            <div class="formlogin">
                <form name="login" id="formLogin" method="post" action="<%=request.getContextPath()%>/control/LoginServlet">

                    <label for="nick" class="white">Nickname: </label>
                    <input type="text" id="nick" name="nickname" size="10" value="<%=nick%>"><br/>

                    <label for="senha" class="white">Senha: </label>
                    <input type="password" id="senha" name="senha" size="15"><br/>
                    
                    <input type="submit" class="botao" name="Submit" value="Entrar">

                </form>
            </div>
                <div class="login">
                <font color="blue">Ainda não é cadastrado?</font><br>
                <a href="cadastro.jsp">Cadastre-se agora!</a>
                </div>

        </section>
    </body>
</html>

                    
