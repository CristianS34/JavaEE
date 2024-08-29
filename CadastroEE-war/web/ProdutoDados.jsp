<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dados do Produto</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">
    <h1>Dados do Produto</h1>
    <form action="ServletProdutoFC" method="post" class="form">
        <input type="hidden" name="acao" value="${produto != null ? 'alterar' : 'incluir'}">
        <c:if test="${produto != null}">
            <input type="hidden" name="id" value="${produto.idProduto}">
        </c:if>
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" id="nome" name="nome" class="form-control" value="${produto != null ? produto.nome : ''}">
        </div>
        <div class="mb-3">
            <label for="quantidade" class="form-label">Quantidade:</label>
            <input type="number" id="quantidade" name="quantidade" class="form-control" value="${produto != null ? produto.quantidade : ''}">
        </div>
        <div class="mb-3">
            <label for="preco" class="form-label">Preço:</label>
            <input type="text" id="preco" name="preco" class="form-control" value="${produto != null ? produto.precoVenda : ''}">
        </div>
        <div>
            <button type="submit" class="btn btn-primary">${produto != null ? 'Alterar' : 'Incluir'}</button>
        </div>
    </form>
</body>
</html>
