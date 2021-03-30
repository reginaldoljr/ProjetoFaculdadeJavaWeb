<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Campanhas</h2>
<table align="center" class="table tabl-striped " border="1" id="datatable">
    <thead>
        <tr>
            <th align="center">ID</th>
            <th align="center">Data Entrega</th>
            <th align="center">Hora Entrega</th>
            <th align="center">Detalhes</th>
            <th align="center">Endereço Entrega</th>
            <th align="center">Encerrado</th>
            <th align="center">Tipo Campanha</th>
            <th align="center" colspan="2">Editar</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="campanha" items="${campanhas}">
            <tr>
                <td align="center">${campanha.idCampanha}</td>
                <td align="center">${campanha.dataEntrega}</td>
                <td align="center">${campanha.horaEntrega}</td>
                <td align="center">${campanha.detalhes}</td>
                <td align="center">${campanha.enderecoEntrega}</td>
                <td align="center">${campanha.encerrado}</td>
                <td align="center">${campanha.tipoCampanha.nomeTipoCampanha}</td>
                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/CampanhaExcluir?idCampanha=${campanha.idCampanha}">
                        Excluir</a></td>

                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/CampanhaCarregar?idCampanha=${campanha.idCampanha}">
                        Alterar</a></td>
                        
            </tr>
        </c:forEach>
    </tbody>
</table>

<div align="center">
    <a href="${pageContext.request.contextPath}/CampanhaNovo">Novo</a>
    <a href="index.jsp">Voltar à Página Inicial</a>
</div>
    <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>

    <%@include file="/footer.jsp" %>