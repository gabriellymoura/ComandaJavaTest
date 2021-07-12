package comandaeletronica;

import java.util.ArrayList;

public class Comanda {

    private ArrayList<ItemComanda> itens;

    public Comanda() {
        itens = new ArrayList<ItemComanda>();
    }

    public void registrarItem(ItemComanda item) {
        itens.add(item);
    }

    public float calcularValorTotal() {
        float total = 0.0f;
        for (ItemComanda item : itens) {
           
        }
        return total;
    }

    public String formatarParaImpressao() {
        StringBuilder sb = new StringBuilder();
        for (ItemComanda item : itens) {
            sb.append(item.formatarParaImpressao() + "\n");
        }
        return sb.toString();
    }
}