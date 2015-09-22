<%@page import="esse.chat.persistence.ChatRoomList"%>
<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<html>
    <head>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/send.css">
        <script type="text/javascript">
        <!--

        function winopen(path)
        {
                chatterinfo = window.open(path,"chatterwin","scrollbars=no,resizable=yes, width=400, height=300, location=no, toolbar=no, status=no");
                chatterinfo.focus();

        }

        //-->
        </script>
    </head>
    
    <body class="sendBody" bgcolor="darkgreen">
        <%@ page isErrorPage="false" errorPage="error.jsp" import="java.util.Set,java.util.Iterator,java.util.Map,esse.chat.model.*"%>
        <%
            ServletContext context = request.getServletContext();
            String nickname = (String)session.getAttribute("nickname");
            String roomname = (String)session.getAttribute("roomname");

            if (nickname != null) {
                ChatRoomList roomlist = (ChatRoomList) context.getAttribute("myListRooms");
                ChatRoom chatRoom = (ChatRoom)roomlist.getRoom(roomname);//cria a nova sala
                if (chatRoom != null) {
                    String msg = request.getParameter("messagebox");

                    if (msg != null && msg.length() > 0) {
                        msg = msg.trim();
                        chatRoom.addMessage(new Message(nickname, msg, new java.util.Date().getTime()));
                    }
                
        %>
        <div class="send">
        <form id="send" name="msg" action="<%=request.getContextPath()%>/sendMessage.jsp" method="post">    
            <label for="messagebox" class="white" />Digite aqui sua mensagem: </label>
            <input type="text" name="messagebox" maxlength="300" size="50">
        <input type="hidden" name="nickname" value="<%=nickname%>">
        <input name="submit" type="submit" value="Enviar" class="botao">   
        </form>
        </div>
        <% 
                }else {
                    out.write("<h2 class=\"error\">Sala não encontrada. Impossível enviar a mensagem!</h2>");
                    response.sendRedirect("error.jsp");
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        %> 
    </body>
</html>