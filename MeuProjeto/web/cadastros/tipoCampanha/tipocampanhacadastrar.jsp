<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrartipocampanha" action="TipoCampanhaCadastrar"
      method="POST">

    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Tipo Campanha</th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idtipocampanha"
                           id="idtipocampanha" value="${tipocampanha.idTipoCampanha}"
                           readonly="readonly"/></td></tr>
            <tr><td>Nome: </td>
                <td><input placeholder="Tipo de Campanha" type="text" name="nometipocampanha" id="nometipocampanha"
                           value="${tipocampanha.nomeTipoCampanha}"/></td></tr>
            <tr><td>Descricao: </td>
                <td><textarea rows="4" cols="50" maxlength="300" placeholder="Máx. 200 palavras." type="text" name="descricaotipocampanha" id="descricaotipocampanha"
                              value="${tipocampanha.descricaoTipoCampanha}"/></textarea></td></tr>
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

