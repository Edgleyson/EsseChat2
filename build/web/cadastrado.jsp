<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page import="esse.chat.model.*" errorPage="error.jsp" %>
<html>
    <head>
        <title>Logout</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/chat.css">
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
    </head>

    <body>
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <aside>

        </aside>
        <%
        String nickname = request.getParameter("nick");
        %>
        
        <section id="logout">
            <div align="center">
                <center>
                <font color="blue">Nickname: <%=nickname%> cadastrado com sucesso!</font><br>
                <a href="login.jsp">Fazer Login agora</a>
                </center>
            </div>
        </section>
    </body>
</html>