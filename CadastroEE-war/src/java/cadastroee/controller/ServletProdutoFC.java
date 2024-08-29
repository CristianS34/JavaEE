package cadastroee.controller;

import cadastroee.model.Produtos;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutosFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino = "";

        switch (acao) {
            case "listar":
                List<Produtos> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
                break;
            case "formIncluir":
            case "formAlterar":
                if ("formAlterar".equals(acao)) {
                    String id = request.getParameter("id");
                    Produtos produto = facade.find(Integer.parseInt(id));
                    request.setAttribute("produto", produto);
                }
                destino = "ProdutoDados.jsp";
                break;
            case "excluir":
                String idExcluir = request.getParameter("id");
                Produtos produtoExcluir = facade.find(Integer.parseInt(idExcluir));
                facade.remove(produtoExcluir);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;
            case "alterar":
                String idAlterar = request.getParameter("id");
                Produtos produtoAlterar = facade.find(Integer.parseInt(idAlterar));
                produtoAlterar.setNome(request.getParameter("nome"));
                produtoAlterar.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                produtoAlterar.setPrecoVenda(Long.parseLong(request.getParameter("preco")));
                facade.edit(produtoAlterar);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;
            case "incluir":
                Produtos novoProduto = new Produtos();
                novoProduto.setNome(request.getParameter("nome"));
                novoProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                novoProduto.setPrecoVenda(Long.parseLong(request.getParameter("preco")));
                facade.create(novoProduto);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;
            default:
                destino = "ProdutoLista.jsp";
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet Produto Front Controller";
    }
}
