<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarcampanha" action="CampanhaCadastrar" method="POST">

    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Campanha</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idcampanha"
                           id="idcampanha" value="${campanha.idCampanha}"
                           readonly="readonly"/></td></tr>
            <tr><td>Data Entrega </td>
                <td><input type="date" name="dataentrega" id="dataentrega"
                           value="${campanha.dataEntrega}"/></td></tr>
            <tr><td>Hora Entrega </td>
                <td><input type="time" name="horaentrega" id="horaentrega"
                           value="${campanha.horaEntrega}"/></td></tr>
            <tr><td>Detalhes</td>
                <td><textarea type="textarea" name="detalhes" id="detalhes"
                              rows="4" cols="50" maxlength="300" placeholder="Máx. 200 palavras." value="${campanha.detalhes}"/></textarea></td></tr>
            <tr><td>Endereço Entrega </td>
                <td><input type="text" name="enderecoentrega" id="enderecoentrega"
                           value="${campanha.enderecoEntrega}"/></td></tr>
            <tr>
                <td>Encerrado </td>
                <td>
                    <select name="encerrado" id="encerrado">
                        <option value="${campanha.encerrado}">Não</option>
                        <option value="${campanha.encerrado}">Sim</option>
                    </select> 
                </td>
            </tr>
                    
            <tr>
                <td>Tipo Campanha</td>
                <td>
                    <select name="idtipocampanha" id="idtipocampanha">
                        <option value="">Selecione</option>
                        <c:forEach var="tipoCampanha" items="${tipocampanhas}">
                            <option value="${tipoCampanha.idTipoCampanha}"
                                    ${campanha.tipoCampanha.idTipoCampanha == tipoCampanha.idTipoCampanha ? "selected" : ""}>
                                ${tipoCampanha.nomeTipoCampanha}
                            </option>

                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar"/>
                    <input type="reset" name="limpar" id="limpar" value="Limpar"/>
                </td></tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar à Página Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>

<%@ include file="/footer.jsp"%>

