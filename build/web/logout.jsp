<%@page import="java.util.Map"%>
<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->
<%@page import="esse.chat.persistence.ChatRoomList"%>
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
                        ServletContext context = request.getServletContext();
                        String nickname = (String) session.getAttribute("nickname");
                        String roomname = (String) session.getAttribute("roomname");
                        ChatRoomList roomlist = (ChatRoomList)context.getAttribute("myListRooms");
                        ChatRoom chatRoom = roomlist.getRoom(roomname);
                                                       
                            Message msg = new Message("ESSEChat", nickname + " saiu dESSE Chat e não está mais logado.", new java.util.Date().getTime());
                            chatRoom.addMessage(msg);
                            String no = "no";
                            session.setAttribute("exit", no);
                                
                        Object obj = session.getAttribute("chatterid");
                        String id = obj.toString();
                        long chatterId = Long.parseLong(id);
                            
                            Map<Long, Chatter> map = chatRoom.getMapChatters();
                            Chatter esseChatter = map.remove(chatterId);    
                            
                        session.invalidate();
                                                    
                    %>
                <font color="blue"><%=nickname%> não está mais logado nESSE Chat!</font><br/>
                <a href="login.jsp?nick=<%=nickname%>">Logar novamente</a>
                </center>
            </div>
        </section>
    </body>
</html>