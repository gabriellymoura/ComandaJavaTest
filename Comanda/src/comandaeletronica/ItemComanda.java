package comandaeletronica;

import javax.swing.JOptionPane;

public class ItemComanda {

	    private Produto produto;
	    private int quantidade;

	    public ItemComanda(Produto p, int q) {
	        produto = p;
	        quantidade = q;
	    }

	    public float calcularPreco() {
	        return produto.getPrecoUnitario() * quantidade;
	    }

	    public String formatarParaImpressao() {
	        return String.format("%3d|%-15s|%3d|R$ %.2f", produto.getCodigo(),
	                produto.getDescricao(), quantidade, calcularPreco());
	    }
	    
	}