<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<!DOCTYPE html>

<%
	String nickname = (String)session.getAttribute("nickname");
        String roomname = (String)session.getAttribute("roomname");
%>
	
<html>
<head>
<title>ESSE Chat - <%=nickname%> (<%=roomname%>) </title>
<META name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">
</head>

<frameset rows="93%,7%">
<frame id="display" src="displayMessages.jsp#current" name="MessageWin">
<frame id="send" src="sendMessage.jsp" name="TypeWin">
</frameset>
<noframes>
<h2>ESSE Chat requer um browser que suporte frames</h2>
</noframes>
</html>
