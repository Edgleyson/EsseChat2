<%@page import="esse.chat.model.Chatter"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css" type="text/css">
        <title>Lista com Taglibs</title>
    </head>
    <body>
        <header>
            <c:import url="pageheader.html" />
        </header>
        <section>
        <table id="listChatters">
            <caption>Lista de Usuários Cadastrados</caption>
            <!-- percorre contatos montando as linhas da tabela -->
            <tr class="pagetitle">
                <th></th>
                <th>ID</th>
                <th>Nome</th>
                <th>Nick</th>
                <th>Senha</th>
                <th>Sexo</th>
                <th>Nascimento</th>
                <th>Email</th>
                <th>Status</th>
            </tr>
            <c:forEach var="chatter" items="${chattersList}" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? '99FF99' : 'CCFFCC' }">
                    <td>${id.count}</td>
                    <td>${chatter['id']}</td>
                    <td>${chatter['name']}</td>
                    <td>${chatter['nick']}</td>
                    <td>${chatter['senha']}</td>
                    <td>
                    <c:choose>
                        <c:when test="${chatter['sex'] eq 'm'}">
                            Masculino
                        </c:when>
                        <c:otherwise>
                            Feminino
                        </c:otherwise>
                    </c:choose>                    
                    </td>
                    <td>${chatter['nascimento']}</td>
                    <td>${chatter['email']}</td>
                    <td>
                    <c:choose>
                        <c:when test="${chatter['status'] eq 1}">
                            Aluno
                        </c:when>
                        <c:when test="${chatter['status'] eq 2}">
                            Professor
                        </c:when>
                        <c:otherwise>
                            Administrador
                        </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table> <br/>
        <ul>
            <%
                
            %>
            <li><a href="#" onclick="window.print();" title="Imprimir Relatório">Imprimir</a></li>
            <li><a href="<%=request.getContextPath()%>/listrooms.jsp" title="Voltar para lista de salas">Retornar</a></li>
                <%
                    
                %> 
        </ul>
        </section>
    </body>
</html>
