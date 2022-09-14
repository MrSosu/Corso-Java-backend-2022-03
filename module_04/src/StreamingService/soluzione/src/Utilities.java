import java.util.HashSet;

public class Utilities {

    /* metodo statico che prende in input una lista di utenti e ritorna l'insieme dei
    prodotti più popolari tra tali utenti
     */
    public static HashSet<Prodotto> prodottiPopolari(HashSet<Utente> utenti, Catalogo catalogo) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        for (Prodotto p: catalogo.getCatalogo()) {
            if (p.mediaVotoUtenti(utenti) > 3) {
                prodottiCercati.add(p);
            }
        }
        return prodottiCercati;
    }

}
