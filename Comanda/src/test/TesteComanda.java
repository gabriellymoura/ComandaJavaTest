package test;

import comandaeletronica.CatalogoProdutos;
import comandaeletronica.Comanda;
import comandaeletronica.ItemComanda;
import comandaeletronica.Produto;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TesteComanda {
    @Test(timeout = 30000)
    public void RegistrarItem() {
        Produto p = new Produto(122, "carne frita", 20.05f);
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.cadastrarProduto(p);

        Comanda comanda = new Comanda();
        ItemComanda item = new ItemComanda(p, 12);

        comanda.registrarItem(item);

        ArrayList<String> array = new ArrayList<>();

        Assert.assertNotEquals(array, comanda.itens);
    }

    @Test(timeout = 30000)
    public void CalculaTotal() {
        Produto p = new Produto(122, "carne frita", 20.05f);
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.cadastrarProduto(p);

        Comanda comanda = new Comanda();
        ItemComanda item = new ItemComanda(p, 2);

        comanda.registrarItem(item);
        float valorTotal = comanda.calcularValorTotal();

        Assert.assertNotEquals(0.0f, valorTotal);
    }
}
