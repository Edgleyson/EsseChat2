<%@page import="java.util.Map"%>
<%@page import="esse.chat.persistence.ChatRoomList"%>
<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->


<%@ page session="true" import="esse.chat.persistence.ChatRoomList, esse.chat.model.ChatRoom, java.text.DateFormat, java.util.Date, esse.chat.model.Chatter, esse.chat.model.Message" errorPage="error.jsp"%>
<%
	ServletContext context = request.getServletContext();
        String yes = "yes";
        session.setAttribute("exit", yes);
      
        String nickname = (String)session.getAttribute("nickname");
        Object obj = session.getAttribute("chatterid");
        String id = obj.toString();
        long chatterId = Long.parseLong(id);
        
        
	if (nickname != null)
	{
		ChatRoomList roomlist = (ChatRoomList)context.getAttribute("myListRooms");
		
		String roomname = (String)session.getAttribute("roomname");
        
                int refreshAfter = 10000; // 10 seconds
                String t = application.getInitParameter("refreshAfter"); // gets segundos
                if (t != null)
                {
                        try
                        {
                                refreshAfter = Integer.parseInt(t);
                                refreshAfter = refreshAfter * 1000; // converte para milisegundos
                        }
                        catch (NumberFormatException nfe)
                        {							
                        }
                }
%>
	
<html>
<head>
<title>ESSE Chat - <%=nickname%> (<%=roomname%>)</title>
<meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">
<link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css">
<script type="text/javascript">
function reload()
{
        window.location.reload();
}

setInterval('reload()', <%=refreshAfter%>);

function winopen(path)
{
	chatterinfo = window.open(path,"chatterwin","scrollbars=no,resizable=no, width=800, height=600, location=no, toolbar=no, status=no");
	chatterinfo.focus();
}

</script>
</head>
<body class="display">
   <header>
       <%@ include file="pageheader.html" %>
   </header>
   <aside>       
       <form name="changeRoom" method="post" action="<%=request.getContextPath()%>/listrooms.jsp">
           <input type="hidden" name="n" value="<%=nickname%>">
           <input class="botoes"  type="button"  value="Escolher Outra Sala" onClick='window.open("listrooms.jsp", "_self")'>
       </form>
       
    <%
        Object o = session.getAttribute("status");
        String status = o.toString();
        int chatterStatus = Integer.parseInt(status);
        if(chatterStatus == 4){
    %>
        <form name="find">
           <input class="botoes" type="button" value="Cadastrar Professor" onClick='window.open("cadastrarMonitor.jsp?monitor=p")'>
        </form>
        <form name="find2">
           <input class="botoes" type="button" value="Cadastrar Monitor 1" onClick='window.open("cadastrarMonitor.jsp?monitor=m1")'>
       </form>
       <form name="find3">
           <input class="botoes" type="button" value="Cadastrar Monitor 2" onClick='window.open("cadastrarMonitor.jsp?monitor=m2")'>
       </form>
    <%      
        }
    
        ChatRoom chatRoom = null;  
        long prof = 0;
        if(roomname != null)
            {
                chatRoom = (ChatRoom)roomlist.getRoom(roomname);//cria a nova sala    
                prof = chatRoom.getProfessor();
                if(prof == chatterId)
                {
    %>
       <form name="find2">
           <input class="botoes" type="button" value="Cadastrar Monitor 1" onClick='window.open("cadastrarMonitor.jsp?monitor=m1")'>
       </form>
       <form name="find3">
           <input class="botoes" type="button" value="Cadastrar Monitor 2" onClick='window.open("cadastrarMonitor.jsp?monitor=m2")'>
       </form>
    <%
            }
        }
    %>
       <form name="refresh">
           <input class="botoes" type="Button" value="Refresh" onClick="reload()">
       </form>
       <form name="logout" action="logout.jsp" method="post" target="_top">
           <input class="botoes" type="Submit" value="Sair">
       </form>
   </aside>
   <section class="listMsg">
        <%
	Chatter chatter = null;
	Message[] messages = null;

	if (nickname != null)
	{
		try
		{
			
				chatter = chatRoom.getChatter(chatterId);
				if (chatRoom != null)
				{
					long enteredAt = chatter.getEnteredInRoomAt();
					if (enteredAt != -1)
					{
						messages = chatRoom.getMessages(enteredAt);					
					}
					else
					{
						messages = chatRoom.getMessages(chatter.getLoginTime());
					}

                                }else
				{
					out.write("<b>Sala de chat: " + roomname + " não encontrada!</b>");
					out.close();
				}
                        
		}
		catch(Exception e)
		{
                    response.sendRedirect("/error.jsp");
                    System.out.println("Exception: "+ e.getMessage());
			
                        System.err.println(nickname);
                        
		}	
%>

<h3><i><%=nickname%></i> você está na sala de chat: <b><%=roomname%></b></h3>

         <%
            boolean professorOnLine = chatRoom.chatterExists(prof);
            if(professorOnLine)
            {
                Chatter profChatter = chatRoom.getChatter(prof);
                String profName = profChatter.getName();
                String profNick = profChatter.getNick();
                if(!(profNick.equals(nickname))){
        %>
        <h2 id="prof">
                <font face="Arial" size="2" color="red">Professor: <%=profName%> está online</font>
        </h2> 
        <%
                }
            }
            Long monitor1 = chatRoom.getMonitor1();
            boolean monitorOnLine = chatRoom.chatterExists(monitor1);
            if(monitorOnLine)
            {
                Chatter moniChatter = chatRoom.getChatter(monitor1);
                String moniName = moniChatter.getName();
                String moniNick = moniChatter.getNick();
                if(!(moniNick.equals(nickname))){
        %>
        <h2 id="monit1">
            <font face="Arial" size="2" color="red">Monitor: <%=moniName%> está online</font>
        </h2> 
        <%
                }
            }
            Long monitor2 = chatRoom.getMonitor2();
            boolean monitor2OnLine = chatRoom.chatterExists(monitor2);
            if(monitor2OnLine)
            {
                Chatter moni2Chatter = chatRoom.getChatter(monitor2);
                String moni2Name = moni2Chatter.getName();
                String moni2Nick = moni2Chatter.getNick();
                if(!(moni2Nick.equals(nickname))){
        %>
        <h2 id="monit2">
            <font face="Arial" size="2" color="green">Monitor: <%=moni2Name%> está online</font>
        </h2> 
        <%
                }
            }
        %>
 <table id="tbmsgs">
        <tr><td class="msgChat">
<%
	
	

        if(messages != null)
	{
	for (Message message : messages) {
            message = message;
            String chatterName = message.getChatterName();
	    String strmsg = message.getMessage();
	    long time = message.getTimeStamp();
	    Date date = new Date(time);
            
                            

			if (chatterName.equals(nickname))
			{
				out.write("<font face=\"Arial\" size=\"2\" color=\"blue\"><b>" + chatterName + " ("+ DateFormat.getTimeInstance().format(date)+ ")&gt;</b></font> " + strmsg+"<br>\n");
			}
			else if (chatterName.equals("ESSEChat"))
			{
				out.write("<span class=\"error\">" + strmsg+"</span><br>\n");
			}
			else
			{
				out.write("<font face=\"Arial\" size=\"2\"><b>"+chatterName + " ("+ DateFormat.getTimeInstance().format(date)+ ")&gt;</b></font> " + strmsg + "<br>\n");
			}			
		}
		out.write("<a name=\"current\"></a>");
	}
	else
	{
		out.write("<font color=\"red\" face=\"Arial\" size=\"2\">Atualmente não há mensagens nesta sala.</font>");
	}
	out.write("<a name=\"current\"></a>");
	%>
</td></tr>
</table>
</section>

<nav>
    <table id="tbusers">
        <thead>
        <tr><th>
                <span class="white">Usuários nesta sala: <%=chatRoom.getNoOfChatters()%></span>
        </th></tr>
        </thead>
        <%
                String sexChatter = chatter.getSex();
                if(sexChatter.equals("m")){
                sexChatter = "Masculino";
            }else{
                sexChatter = "Feminino";
            }
        %>
        <tbody>
        <tr><td>
            <font face="Arial" size="2" color="blue"><%=nickname + " (" +sexChatter+")<br>"%></font>
        </td></tr>
        <tr><td>        
        <%
	String name, sex;
        Chatter[] chatters = chatRoom.getChattersArray();
        for (Chatter esseChatter : chatters) {
            name = esseChatter.getNick();
            sex = esseChatter.getSex();
            Object objId = esseChatter.getId();
            String stringId = objId.toString();
            long esseId = Long.parseLong(stringId);
            if(sex.equals("m")){
                sex = "Masculino";
            }else{
                sex = "Feminino";
            }
	
		if (!(name.equals(nickname)))
		{
		   out.write("<font face=\"Arial\" size=\"2\"><a href=\"javascript:winopen('viewinfo.jsp?chatteriD="+stringId + "')\" title=\"Veja informações sobre "+name+"\">"+ name+"</a> (" + sex+")</font><br>");
		}
	}

}
else
{
	response.sendRedirect("login.jsp");
}
%>
            </td></tr>
        </tbody>
    </table>
</nav>
</body>
</html>
<%
}
else
{
	response.sendRedirect("login.jsp");
}
%>