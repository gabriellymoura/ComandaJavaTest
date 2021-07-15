package test;

import comandaeletronica.CatalogoProdutos;
import comandaeletronica.Produto;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;


public class TesteProduto {


    @Test(timeout = 30000)
    public void CadastroProdutos(){
        Produto p = new Produto(122,"carne frita", 20.05f);
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.cadastrarProduto(p);
        Assert.assertNotNull(catalogo);

    }
    @Test(timeout = 30000)
    public void BuscarProdutos(){
        Produto p = new Produto(122,"carne frita", 20.05f);
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.cadastrarProduto(p);
        Produto produtosEncontrados = catalogo.buscarProduto(122);
        Assert.assertNotNull(produtosEncontrados);
    }
    @Test(timeout = 30000)
    public void ImprimirProduto(){
        Produto p = new Produto(122,"carne frita", 20.05f);
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.cadastrarProduto(p);
        String produtosEncontrados = catalogo.formatarParaImpressao();
        Assert.assertNotEquals("",produtosEncontrados);
    }



}
