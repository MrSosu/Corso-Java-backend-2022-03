package streamingService;

import streamingService.prodotto.Prodotto;

import java.util.HashSet;

public class Catalogo {

    HashSet<Prodotto> catalogo = new HashSet<>();

    public HashSet<Prodotto> getCatalogo() { return catalogo; }

    public void addInCatalogo(Prodotto p) { catalogo.add(p); }
    public void removeFromCatalogo(Prodotto p) { catalogo.remove(p); }

}
