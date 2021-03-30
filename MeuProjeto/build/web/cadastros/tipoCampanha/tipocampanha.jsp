<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Tipo Campanhas</h2>
<table align="center" class="table tabl-striped table-bordered" border="1" id="datatable">
    <thead>
        <tr>
            <th colspan="6" align="center">Lista de Tipo Campanhas</th>
        </tr>
        <tr>
            <th align="center">ID</th>
            <th align="center">Nome</th>
            <th align="center">Descricao</th>
            <th align="center" colspan="2">Editar</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="tipocampanha" items="${tipocampanhas}">
            <tr>
                <td align="center">${tipocampanha.idTipoCampanha}</td>
                <td align="center">${tipocampanha.nomeTipoCampanha}</td>
                <td align="center">${tipocampanha.descricaoTipoCampanha}</td>
                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/TipoCampanhaExcluir?idTipoCampanha=${tipocampanha.idTipoCampanha}">
                        Excluir</a></td>

                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/TipoCampanhaCarregar?idTipoCampanha=${tipocampanha.idTipoCampanha}">
                        Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div align="center">
    <a href="${pageContext.request.contextPath}/TipoCampanhaNovo">Novo</a>
    <a href="index.jsp">Voltar à Página Inicial</a>
</div>
<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<%@include file="/footer.jsp"%>
