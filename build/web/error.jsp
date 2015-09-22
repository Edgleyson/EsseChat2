<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>ESSE ERRO</title>
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e S�rgio)">	
        <link rel="stylesheet" href="<%=request.getContextPath()%>/erro.css" type="text/css">
    </head>
    <body>
        <%
            String admin = getServletContext().getInitParameter("adminEmail");
        %>
        <header>
            <h2>Oops! Alguma coisa quebrou do lado de c�!</h2>
            <p>A p�gina que voc� procura n�o existe!</p>
            <p>Clique em: <a href="<%=request.getContextPath()%>/login.jsp">Tire-me daqui</a> para ir a nossa homepage!</p>
            <p class="menor">Reclame por email: <a href="mailto:<%=admin%>"><%=admin%></a>
            informando o erro ${pageContext.errorData.statusCode} na p�gina: ${pageContext.errorData.requestURI}</p>
        </header>
    </body>
</html>