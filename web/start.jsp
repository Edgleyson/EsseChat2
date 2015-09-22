<%-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE --%>

<%@page import="esse.chat.persistence.ChatRoomList"%>
<%@page import="java.util.Map.Entry"%>
<%@ page errorPage="error.jsp" import="java.io.IOException,java.util.Set,java.util.Iterator,java.util.Map,esse.chat.model.*"%>
<%
    ServletContext context = request.getServletContext();
    String nickname = (String) session.getAttribute("nickname");
    String senha = (String) session.getAttribute("senha");
    String sex = (String) session.getAttribute("sexo");
    Object obj = session.getAttribute("chatterid");
    String id = obj.toString();
    long chatterId = Long.parseLong(id);
    String roomname = (String)session.getAttribute("roomname");//retorna SalaVip
    String newRoomName = request.getParameter("rn");//retorna a sala escolhida
    
    if (newRoomName == null) {
        response.sendRedirect("listrooms.jsp");
    }
    ChatRoomList roomlist = (ChatRoomList)context.getAttribute("myListRooms");
    ChatRoom oldRoom = roomlist.getRoom(roomname);
    ChatRoom newRoom = roomlist.getRoom(newRoomName);
    Map<Long, Chatter> map = oldRoom.getMapChatters();

    if(!roomname.equals(newRoomName)){
        //vamos remover o valor (o Chatter) cuja chave é igual ao seu id
        Chatter esseChatter = map.remove(chatterId);
        //e adicioná-lo à nova sala
        newRoom.addChatter(esseChatter);
        Message msg = new Message("ESSEChat", nickname + " entrou na sala.", new java.util.Date().getTime());
        
        String roomName = newRoom.getName();        
        session.setAttribute("roomname", roomName);
        session.setAttribute("salaatual", roomName);
        
        esseChatter.setEnteredInRoomAt(new java.util.Date().getTime());
        newRoom.addMessage(msg);
        response.sendRedirect("chat.jsp");
    }else{
        Message msg2 = new Message("ESSEChat", nickname + " retornou à sala.", new java.util.Date().getTime());
        newRoom.addMessage(msg2);
        response.sendRedirect("chat.jsp");
    }
%>
             
    
