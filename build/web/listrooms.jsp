<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->
<%@ page session="true" errorPage="error.jsp" import="java.io.IOException,java.util.Set,java.util.Iterator,java.util.Map,esse.chat.model.*,esse.chat.persistence.ChatRoomList"%>
<html>
    <head>
        <title>ESSE Chat: Lista de salas</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/chat.css">

        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
        <script>

            if (window.top !== window.self)
            {
                window.top.location = window.location;
            }

        </script>
    </head>

    <body bgcolor="#FFFFFF">
        <%
        ServletContext context = request.getServletContext();

        String nickname = (String)session.getAttribute("nickname");
        
        String salaAtual = (String)session.getAttribute("salaatual");
        if(salaAtual == null){
             salaAtual = "SalaVip"; 
             session.setAttribute("salaatual", salaAtual);
        }
        

        if (nickname == null)
        {
                response.sendRedirect("login.jsp");
        }
        else
        {
                String roomname = request.getParameter("rn");	
                String descr = request.getParameter("sd");
                boolean see = false;
                if (descr != null && descr.equals("y"))
                {
                        see = true;
                }
        %>
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <aside>
        <%
            Object obj = session.getAttribute("status");
            String status = obj.toString();
            long chatterStatus = Long.parseLong(status);
            if(chatterStatus == 4)
                {
        %>    
            <form name="listachatters" method="post" action="<%=request.getContextPath()%>/ListaChattersServlet">
                <input class="botoes"  type="submit"  value="Listar usuários">
            </form>
        <%
                }
        %>
        <!--    <form name="editinfo" action="editinfo" method="post">
           <input class="botoes" type="Button" value="Editar Perfil" onClick='window.open("editInfo.jsp", "_self")'>
            </form> -->
        </aside>
        <section class="listRooms">
            <h3 class="lrmsg">Bem-vindo <span class="chattername"><%=nickname%></span></h3>
            <p class="lrmsg">Escolha uma sala para entrar! Você pode ver antes uma breve descrição da sala clicando em "Visualizar descrição".</p>

            <div>
                
                    <form name="chatrooms" action="<%=request.getContextPath()%>/start.jsp" method="post">
                        <table id="lista">
                            <tr>
                                <th colspan="2" class="pagetitle">Lista de Salas disponíveis</th>
                            </tr>
        <%
                            ChatRoomList roomlist = (ChatRoomList)context.getAttribute("myListRooms");
                            if(roomname == null)
                            {
                                roomname = (String)session.getAttribute("roomname");    
                            }
                            
                            ChatRoom[] chatrooms = roomlist.getRoomListArray();
                            String name, desc;
                            int count = 0;
                           
                            for (ChatRoom room : chatrooms) {
                                name = room.getName();
                                desc = room.getDescription();
                                if (name.equals("SalaVip")) 
                                continue;
                            %>
                            <tr>
                                <td class="col1">
                                    <input type=radio id="<%=count%>" class="clicavel" name="rn" value="<%=name%>" 
                                           <%if (name.equals(salaAtual))out.write("checked");%>><label for="<%=count%>" class="clicavel">&nbsp<%=name%></label>
                                </td>
                                <%
                                                        if (see == true && name.equals(roomname))
                                                        {
                                %>	
                                <td class="col1"><%=desc%></td>
                                <%
                                                        }
                                                        else
                                                        {
                                %>
                                <td class="col2"><a href="<%=request.getContextPath()%>/listrooms.jsp?rn=<%=name%>&sd=y">Visualizar Descrição</a></td>
                                <%
                                                        }
                                %>
                            </tr>
            <%
                            count++;
                            }
                    
            %>
                            <tr>
                                <td class="col1">&nbsp;<a href="<%=request.getContextPath()%>/addRoom.jsp" title="Add new Room">Adicionar Nova Sala</a></td>
                                <td class="col2"><input type="Submit" class="clicavel" value="Entrar na sala"></td>
                            </tr>
                        </table>
                    </form>

               
            </div>
        </section>
        <%
                }
        %>
        <%
            String roomname = (String)session.getAttribute("roomname");
            String exit = (String)session.getAttribute("exit");
            if ("yes".equals(exit)){
            Message msg2 = new Message("ESSEChat", nickname + " deixou a sala, mas ainda está logado nESSE Chat.", new java.util.Date().getTime());
            ChatRoomList roomlist = (ChatRoomList) context.getAttribute("myListRooms");
            ChatRoom chatRoom = roomlist.getRoom(roomname);
            chatRoom.addMessage(msg2);
            String no = "no";
            session.setAttribute("exit", no);
            }
        %>    
        <%@ include file="/footer.jsp"%>
    </body>
</html>