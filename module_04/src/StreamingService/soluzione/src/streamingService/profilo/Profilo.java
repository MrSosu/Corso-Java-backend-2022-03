package streamingService.profilo;

import streamingService.eccezioni.HasKidException;
import streamingService.eccezioni.MaxUserException;
import streamingService.eccezioni.ProfiloException;

import java.util.HashSet;

public class Profilo {

    // attributi
    private String email;
    private String password;
    private TipoOfferta offerta;
    private HashSet<Utente> utenti = new HashSet<>();
    private boolean hasKid = false;

    // costruttore
    public Profilo(String email, String password, TipoOfferta offerta) {
        this.email = email;
        this.password = password;
        this.offerta = offerta;
    }

    // getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public TipoOfferta getOfferta() { return offerta; }
    public HashSet<Utente> getUtenti() { return utenti; }

    // setters
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setOfferta(TipoOfferta offerta) { this.offerta = offerta; }

    // metodi
    // questo metodo aggiunge un utente al profilo
    public void addUtente(Utente u) throws ProfiloException {
        if (utenti.size() < offerta.getNumUtenti()) {
            if(u.isKid() && hasKid) { //Il nostro profilo può avere al massimo 1 solo bambino
                //Lanciamo Eccezione
                throw new HasKidException();
            } else {
                utenti.add(u);
                hasKid = u.isKid();
            }
        } else {
            System.out.println("non puoi aggiungere questo utente, hai raggiunto il limite massimo per la tua offerta");
            throw new MaxUserException(offerta);
        }
    }

    // questo metodo rimuove un utente dal profilo
    public void removeUtente(Utente u) {
        if (utenti.contains(u)) {
            utenti.remove(u);

            if(u.isKid())
                hasKid = false;
        }
        else {
            System.out.println("errore! utente non presente");
        }
    }

    // questo metodo svuota l'insieme di utenti
    public void emptyUtenti() { utenti.clear(); }

}
