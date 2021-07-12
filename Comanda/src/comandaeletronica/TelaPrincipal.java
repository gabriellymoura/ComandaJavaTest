package comandaeletronica;


	import comandaeletronica.CatalogoProdutos;
	import comandaeletronica.Comanda;
	import comandaeletronica.ItemComanda;
	import comandaeletronica.Produto;
	import java.awt.Font;
	import javax.swing.JOptionPane;
	import javax.swing.UIManager;

	public class TelaPrincipal {

	    public static void main(String[] args) {
	        UIManager.put("OptionPane.messageFont", new Font(Font.MONOSPACED, Font.BOLD, 12));
	        CatalogoProdutos catalogo = new CatalogoProdutos();
	        Comanda comanda = new Comanda();
	        int op;
	        do {
	            op = menu();
	            switch (op) {
	                case 1: // Cadastrar Produto
	                    Produto p = lerProduto();
	                    catalogo.cadastrarProduto(p);
	                    break;
	                case 2: // Imprimir Produtos                    
	                    String produtos = catalogo.formatarParaImpressao();
	                    JOptionPane.showMessageDialog(null, produtos, "Produtos", JOptionPane.INFORMATION_MESSAGE);
	                    break;
	                case 3: // Registrar Item
	                    ItemComanda item = lerItem(catalogo);
	                    if (item != null) {
	                        comanda.registrarItem(item);
	                        JOptionPane.showMessageDialog(null, "Item Registrado com Sucesso");
	                    }
	                    break;
	                case 4: // Finalizar Compra
	                    String itens = comanda.formatarParaImpressao();
	                    itens += String.format("\nValor Total: R$ %.2f", comanda.calcularValorTotal());
	                    JOptionPane.showMessageDialog(null, itens, "Comanda", JOptionPane.INFORMATION_MESSAGE);
	                case 0:
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "Op��o Inv�lida!");
	            }
	        } while (op != 0);
	    }

	    public static int menu() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("*** MENU ***");
	        sb.append("\n1. Cadastrar Produto");
	        sb.append("\n2. Imprimir Produtos");
	        sb.append("\n3. Registrar Item na Comanda");
	        sb.append("\n4. Finalizar Compra");
	        sb.append("\n0. Sair");
	        sb.append("\nOpcao: ");
	        String op = JOptionPane.showInputDialog(sb);
	        if (op == null) {
	            return 0;
	        }
	        try {
	            return Integer.parseInt(op);
	        } catch (NumberFormatException e) {
	            return -1;
	        }
	    }

	    public static Produto lerProduto() {
	        String op = JOptionPane.showInputDialog("Codigo: ");
	        int c = Integer.parseInt(op);
	        String d = JOptionPane.showInputDialog("Descri��o: ");
	        op = JOptionPane.showInputDialog("Preco Unit�rio: ");
	        float p = Float.parseFloat(op);
//	        return new Produto(c, d, p);
			return null;
	    }

	    public static ItemComanda lerItem(CatalogoProdutos catalogo) {
	        String op = JOptionPane.showInputDialog("Codigo: ");
	        int c = Integer.parseInt(op);
	        // Verifica se o produto existe
	        Produto p = catalogo.buscarProduto(c);
	        if (p == null) {
	            JOptionPane.showMessageDialog(null, "Codigo de Produto Inv�lido!!!");
	            return null;
	        }
	        op = JOptionPane.showInputDialog("Quantidade: ");
	        int q = Integer.parseInt(op);
	        ItemComanda item = new ItemComanda(p, q);
	        return item;
	    }
	}

