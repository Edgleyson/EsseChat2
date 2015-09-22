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
        <section id="logout">
        <div align="center">
        <center>
        <%
        String nickname = request.getParameter("nick");
        String roomname = request.getParameter("room");
        String prof = request.getParameter("prof");
        if("prof".equals(prof)){        
        %>
                <font color="blue">Professor: <%=nickname%> cadastrado com sucesso</font><br>
                <font color="blue">na sala de chat: <%=roomname%>!</font>
        <%
        }else{
        %>
                <font color="blue">Monitor: <%=nickname%> cadastrado com sucesso</font><br>
                <font color="blue">na sala de chat: <%=roomname%>!</font>
        <%
        }
        %>
        </center>
        </div>
        </section>
    </body>
</html>