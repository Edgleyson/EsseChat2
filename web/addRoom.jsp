<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->
<!-- Futuramente, alguma autenticação pode ser adicionada aqui -->

<html>
    <head>
        <title>Adiciona Nova Sala</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/chat.css">
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">	
    </head>

    <body>
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <section>
            <form id="createRoom" action="<%=request.getContextPath()%>/control/ManageChatServlet" method="post">
                        
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
                            
                                <h2>Adicionar nova sala</h2>
                                <label for="newroom" class="white">Nome da nova Sala</label>
                                <input type="text" id="newroom" name="rn"><br/>
                                <label for="desc" class="white">Descrição da Sala</label>
                                <textarea rows="3" cols="33" id="desc" name="rd"></textarea><br/>
                                
                                <input type="submit" class="botao" value="Submeter">
                     </form>

        </section>
        <%@ include file="/footer.jsp"%>

    </body>
</html>