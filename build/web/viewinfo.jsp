<%@page import="esse.chat.persistence.ChatRoomList"%>
<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page isErrorPage="false" errorPage="error.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,esse.chat.model.*"%>

<%
    String stringId = request.getParameter("chatteriD");
    
    ServletContext context = request.getServletContext();
    ChatRoomList roomList = (ChatRoomList)context.getAttribute("myListRooms");

    long chatterId = Long.parseLong(stringId);
    ChatRoom chatRoom = roomList.getRoomOfChatter(chatterId);
    if (chatRoom != null) {
        Chatter chatter = chatRoom.getChatter(chatterId);
        String nome = chatter.getName();
        String nick = chatter.getNick();
        String sexo = chatter.getSex();
        String nasc = chatter.getNascimento();
        String email = chatter.getEmail();
        
        
        
%>
<html>
    <head>
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
        <title>(<%=chatter.getName()%>) Perfil</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
    </head>

    <body>
    <header>
            <%@ include file="pageheader.html" %>
    </header>   
            
                <div class="formview">
                <form name="chatterinfo" >

                    <label for="name" class="white">Nome: </label><br/>
                    <input type="text" id="name" name="name" size="30" value="<%=nome%>" readonly="readonly"><br/>
                    
                    <label for="nick" class="white">Nickname: </label><br/>
                    <input type="text" id="nick" name="nickname" size="10" value="<%=nick%>" readonly="readonly"><br/>

                    <label for="sex" class="white">Sexo:&nbsp;</label><br/>
                    <%
                       if("m".equals(sexo)) 
                        {
                    %>
                    <input type="text" id="sex" name="sex" size="10" value="Masculino" readonly="readonly"><br/>
                    <%
                        }else{
                    %>
                    <input type="text" id="sex" name="sex" size="10" value="Feminino" readonly="readonly"><br/>
                    <%
                        }
                    %>
                   
                    <label for="email" class="white">E-mail: </label><br/>
                    <input type="email" id="email" name="email" size="30" value="<%=email%>" readonly="readonly"><br/>
                    
                    

                </form>
              </div>
            

    </body>
</html>
<%
    } 
%>