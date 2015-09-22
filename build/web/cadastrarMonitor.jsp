<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page contentType="text/html" language="java" errorPage="error.jsp" import="esse.chat.model.*"%>

<html>
    <head>
        <title>ESSE Monitor</title>
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
    </head>
    <body onLoad="document.login.nickname.focus();">
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <%
            String roomName = (String)session.getAttribute("roomname");
            String monitor = request.getParameter("monitor");
        %>
        <section>
        <%
             if("p".equals(monitor)){
        %>
        <p class="geral"><span class="error">Informe o nickname do usuário.</span></p>
        <p class="geral">Clique em submeter para cadastrá-lo como Professor da sala <%=roomName%></p>
        <%
        } else {
        %>
        <p class="geral"><span class="error">Informe o nickname do usuário.</span></p>
        <p class="geral">Clique em submeter para cadastrá-lo como Monitor da sala <%=roomName%></p>
        <%
            }
        %>
        <div class="formcadastro">
                <form name="login" id="formCadastro" method="post" action="<%=request.getContextPath()%>/CadastraMonitorServlet">
                    <%
                        Object e = request.getAttribute("error");
                        String error = null;
                        if (e != null) {
                        error = (String) e;
                    %>
                            
                                <h3 class="error"><%=error%></h3>
                            
                    <%
                        }
                    %>
                    
                    <label for="nick" class="white">Nickname: </label><br/>
                    <input type="text" id="nick" name="nickDoAluno" size="10" placeholder="Apelido"><br/>
                    <label for="status" class="white">Status:&nbsp;</label><br/>
                    <%
                        if("p".equals(monitor)){
                    %>
                    <input type="text" id="status" name="status" size="10" value="Professor" disabled><br/>
                    <%
                        }else{
                    %>
                    <input type="text" id="status" name="status" size="10" value="Monitor" disabled><br/>
                    <%
                        }
                    %>
                    <input type="hidden" name="typeMonitor" value="<%=monitor%>"><br/>
                                            
                    <input type="submit" class="botao" name="Submit" value="Submeter">
                </form>
        </div>
        </section>
    </body>
</html>
