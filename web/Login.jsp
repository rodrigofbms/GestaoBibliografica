<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 09/05/2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
          crossorigin="anonymous">

    <title>Login</title>

</head>
<body>
<!--  Menu de navegação> -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a href="https://www.ucsal.br/"> <img alt="Logo UCSal"
                                          src="https://ead.ucsal.br/pluginfile.php/1/theme_adaptable/logo/1523360667/logomarca_UCSal_branca_fundo_transparente_v2.png">
    </a>
    <h3>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarColor01" aria-controls="navbarColor01"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="#">Login
                    <span class="sr-only">(current)</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="Cadastro.jsp">Cadastrar</a></li>
            </ul>
        </div>
    </h3>
</nav>
<!-- <c:import url="BarraNavegacao.jsp"></c:import> -->
<!-- Fim do menu de navegação -->
<div align="center">
    <form action="/GestaoBibliografica/LoginController" method="post">
        <br> <br> <br> <br>
        <h1>Acessar</h1>
        <div class="col-md-3 mb-3">
            <label for="validationDefault05"></label> <input type="text"
                                                             class="form-control" name="usuario" placeholder="Login"
                                                             required>
        </div>
        <div class="col-md-3 mb-3">
            <label for="validationDefault05"></label> <input type="password"
                                                             class="form-control" name="senha" placeholder="Senha"
                                                             required>
        </div>
        <button type="submit" class="btn btn-success">Entrar</button>
    </form>
    <a href="/GestaoBibliografica/Cadastro.jsp"> Não é cadastrado
        ainda? </a>
</div>
</body>
</html>
