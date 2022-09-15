package streamingService.profilo;

import streamingService.Catalogo;
import streamingService.prodotto.*;

import java.util.HashMap;
import java.util.HashSet;

public class Utente {

    // attributi
    private String nome;
    private String avatar;
    private boolean isKid;
    private String pin;
    private Profilo profiloUtente;
    private HashSet<Prodotto> miaLista = new HashSet<>();

    // costruttore
    public Utente(String nome, String avatar, boolean isKid, String pin, Profilo profiloUtente) {
        this.nome = nome;
        this.avatar = avatar;
        this.isKid = isKid;
        this.pin = pin;
        this.profiloUtente = profiloUtente;
    }

    // setter e getter
    public String getNome() { return nome; }
    public String getAvatar() { return avatar; }
    public String getPin() { return pin; }
    public HashSet<Prodotto> getMiaLista() { return miaLista; }
    public Profilo getProfiloUtente() { return profiloUtente; }
    public boolean isKid() { return isKid; }

    public void setNome(String nome) { this.nome = nome; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public void setKid(boolean kid) { isKid = kid; }
    public void setPin(String pin) { this.pin = pin; }

    // metodi
    // questo metodo aggiunge in lista (se possibile) un nuovo prodotto
    public void addInLista(Prodotto p) {
        if (profiloUtente.getOfferta() != TipoOfferta.BASIC) {
            miaLista.add(p);
        }
        else { System.out.println("non puoi avere una lista hai l'abbonamento da poraccio"); }
    }
    // questo metodo rimuove dalla lista un prodotto p
    public void removeFromLista(Prodotto p) {
        if (miaLista.contains(p)) {
            miaLista.remove(p);
        }
        else { System.out.println("il prodotto non è presente nella tua lista"); }
    }

    // questo metodo inserisce un voto da 1 a 5 che l'utente assegna a un prodotto
    public void assegnaVoto(Prodotto p, Integer voto) {
        if (profiloUtente.getOfferta() != TipoOfferta.BASIC) {
            if (voto >= 1 && voto <= 5) { p.addVoto(this, voto); }
            else { System.out.println("voto non valido"); }
        }
        else { System.out.println("non puoi mettere voti hai l'abbonamento da poraccio"); }
    }

    // questo metodo prende in input una categoria e restituisce i prodotto del catalogo di quella categoria
    public HashSet<Prodotto> cercaProdotti(Catalogo catalogo, String categoria) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        if (profiloUtente.getOfferta().equals(TipoOfferta.PREMIUM)) {
            // se cerco dei film
            if (categoria.equalsIgnoreCase("film")) {
                // scorro i prodotti in catalogo
                for (Prodotto p: prodottiCatalogo) {
                    // se quel prodotto è una istanza di film lo aggiungo all'insieme risultato
                    if (p instanceof Film) {
                        prodottiCercati.add(p);
                    }
                }
            }
            else if (categoria.equalsIgnoreCase("serie tv")) {
                // scorro i prodotti in catalogo
                for (Prodotto p: prodottiCatalogo) {
                    // se quel prodotto è una istanza di serie tv lo aggiungo all'insieme risultato
                    if (p instanceof SerieTV) {
                        prodottiCercati.add(p);
                    }
                }
            }
            else if (categoria.equalsIgnoreCase("documentario")) {
                // scorro i prodotti in catalogo
                for (Prodotto p: prodottiCatalogo) {
                    // se quel prodotto è una istanza di documentario lo aggiungo all'insieme risultato
                    if (p instanceof Documentario) {
                        prodottiCercati.add(p);
                    }
                }
            }
            else { System.out.println("ricerca non valida"); }
        }
        else { System.out.println("non hai abbonamento premium"); }
        return prodottiCercati;
    }

    public HashSet<Prodotto> cercaProdotti(Catalogo catalogo, Genere genere) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        if (profiloUtente.getOfferta().equals(TipoOfferta.PREMIUM)) {
            for (Prodotto p: prodottiCatalogo) {
                if (p.getGenere().equals(genere)) {
                    prodottiCercati.add(p);
                }
            }
        }
        else { System.out.println("non hai abbonamento premium"); }
        return prodottiCercati;
    }

    // questo metodo ritorna un insieme di prodotti che possono interessare all'utente
    public HashSet<Prodotto> prodottiConsigliati(Catalogo catalogo) {
        HashSet<Prodotto> prodottiCercati = new HashSet<>();
        HashSet<Prodotto> prodottiCatalogo = catalogo.getCatalogo();
        // ci calcoliamo il genere preferito dall'utente
        HashMap<Genere, Integer> votiPerGenere = new HashMap<>();
        for (Prodotto p: miaLista) {
            Genere g = p.getGenere();
            if (votiPerGenere.containsKey(g)) {
                votiPerGenere.put(g, votiPerGenere.get(g) + 1);
            }
            else {
                votiPerGenere.put(g, 1);
            }
        }
        // ora che ho fatto la mappa calcolo il genere preferito
        Genere genereMax = null;
        int numGenereMax = 0;
        for (Genere g: votiPerGenere.keySet()) {
            if (votiPerGenere.get(g) > numGenereMax) {
                genereMax = g;
                numGenereMax = votiPerGenere.get(g);
            }
        }
        /* aggiungo all'insieme risultato tutti quei prodotti che sono dello stesso genere di
        genereMax, che non sono nella lista dell'utente e che hanno una media voto > 3
         */
        for (Prodotto p: prodottiCatalogo) {
            if (p.getGenere().equals(genereMax) && !miaLista.contains(p) && p.mediaVoto() > 3) {
                prodottiCercati.add(p);
            }
        }
        return prodottiCercati;
    }

}
