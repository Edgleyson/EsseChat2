<!DOCTYPE html>

<html>
<head>
</head>
<body>
<section>
<ul>
    <%
		String n = (String)session.getAttribute("nickname");
		if (n != null && n.length() > 0)
		{
    %>
                    <li><a href="<%=request.getContextPath()%>/logout.jsp" title="Sair dESSE Chat">Logoff (Sair)</a></li>
                    <li><a href="<%=request.getContextPath()%>/listrooms.jsp" title="Atualizar Lista de Salas">Atualizar Lista</a></li>
    <%
		}
    %> 
</ul>
</section>    
</body>
</html>