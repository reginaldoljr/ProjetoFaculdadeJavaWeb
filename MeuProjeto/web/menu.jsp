


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="assets/img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Conecta Ongs Brasil
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#textoNavbar" aria-controls="textoNavbar" aria-expanded="false" aria-label="Alterna navegação">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="textoNavbar">
        <ul class="navbar-nav mr-auto">
            <li class="btn nav-item">
                <a class="nav-link" href="#">Fazer Parte<span class="sr-only">(Página atual)</span></a>
            </li>
            <li class="btn nav-item">
                <a class="nav-link" href="#">Nossa História</a>
            </li>
            <li class="btn nav-item">
                <a class="nav-link" href="#">Entrar em contato</a>
            </li>
      
               
           
                
        </ul>
         <button class="btn-gradient btn-info btn" href="#">Fazer Login</button>
        <span class="navbar-text">
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-instagram"></a>
        </span>
       
    </div>
</nav>


<div class="container-fluid"> 
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="home.jsp">Início</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Gerir Campanhas</a>
            <div class="dropdown-menu">
                <a class="dropdown-item card-list" href="${pageContext.request.contextPath}/CampanhaListar"><i class="fas fa-book-open"></i> Listar campanhas</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/CampanhaNovo"><i class="far fa-plus-square"></i> Nova Campanha</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/TipoCampanhaNovo"><i class="far fa-plus-square"></i> Adicionar novo tipo de campanha</a>
                <a class="dropdown-item card-list" href="${pageContext.request.contextPath}/TipoCampanhaListar"><i class="fas fa-book-open"></i> Listar Tipos de Campanhas</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle " data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><i class="fas fa-dove"></i> Doações Recebidas</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item card-list" href="#"><i class="fas fa-book-open"></i> Lista de Doações</a>
                            
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#"><i class="fas fa-users-cog"></i> Configurações</a>
        </li>

    </ul>

</div>


                
             