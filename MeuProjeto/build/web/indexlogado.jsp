<%-- 
    Document   : indexlogado
    Created on : 26/03/2021, 08:17:14
    Author     : Tassia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.oVoluntario != null}">
                <h1>Só quem está logado tem acesso</h1>
                <!---Tudo que coloca aqui somente usuarios
                logados tem acesso--->
                Consulta 
                
                <a href="LogarVoluntario?acao=logout">Sair</a>
            </c:when>            
            <c:otherwise>   
                <c:redirect url = "login.jsp"/>
                sadsadsa
                
                <!--Colocar conteúdo diferente-->
            </c:otherwise>
        </c:choose>

        
    </body>
</html>
