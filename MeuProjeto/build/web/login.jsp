<%-- 
    Document   : login.jsp
    Created on : 19/03/2021, 10:56:05
    Author     : Tassia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="css/estiloform.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        

        <div class="sidenav">
            <div class="login-main-text">
                <h2>Controle<br>de Sessão</h2>
                <p>Faça o login para ter acesso.</p>
            </div>
        </div>
        <div class="main">
            <div class="col-md-6 col-sm-12">
                <div class="login-form">
                    <form method="post" action="LogarVoluntario">
                        <div class="form-group">
                            <label>E-mail</label>
                            <input name="emailusuario" type="text" class="form-control" placeholder="User Name">
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input name="senhausuario" type="password" class="form-control" placeholder="Password">
                        </div>
                        <input type="hidden" value="logar" name="acao"/>
                        <button type="submit" class="btn btn-black">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
