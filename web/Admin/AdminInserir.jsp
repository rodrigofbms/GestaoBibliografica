<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 09/05/2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
          crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inserir bibliografias</title>
</head>
<body>
<!--  Menu de navegação> -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
        href="https://www.ucsal.br/"> <img alt="Logo UCSal"
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
                <li class="nav-item"><a class="nav-link" href="../AdminHome.jsp">Home
                    </a></li>
                <li class="nav-item"><a class="nav-link"
                                        href="../AdminPesquisar.jsp">Pesquisar <span class="sr-only"></span>
                </a></li>
                <li class="nav-item active"><a class="nav-link"
                                               href="AdminInserir.jsp">Inserir</a></li>
            </ul>
        </div>
    </h3>
</nav>
<!-- Fim do menu de navegação -->
<br>
<br>
<br>
<br>
<br>
<br>
<div align="center">
    <form action="/GestaoBibliografica/EfetuarCadastroController"
          method="post">
        <div class="form-row">
            <div class="col-md-2 mb-3">
                <label for="validationDefault01">Nome do bibliografia</label> <input
                    type="text" class="form-control" placeholder="Nome do bibliografia"
                    required>
            </div>
            <div class="col-md-2 mb-3">
                <label for="validationDefault02">Editora</label> <input type="text"
                                                                        class="form-control" placeholder="Editora" required>
            </div>

            <div class="col-md-2 mb-3">
                <label for="validationDefaultUsername">Autores</label> <input
                    type="text" class="form-control" id="validationDefaultUsername"
                    placeholder="Autor" aria-describedby="inputGroupPrepend2" required>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-2 mb-3">
                <label for="validationDefault03">Imagem</label> <input type="text"
                                                                       class="form-control" id="validationDefault03" placeholder="Imagem"
                                                                       required>
            </div>
            <div class="col-md-2 mb-3">
                <label for="validationDefault04">Edição</label> <input type="text"
                                                                       class="form-control" id="validationDefault04" placeholder="Edição"
                                                                       required>
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Cadastrar
            bibliografia</button>
    </form>
</div>
</body>
</html>