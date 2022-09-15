package streamingService;

import streamingService.eccezioni.HasKidException;
import streamingService.eccezioni.MaxUserException;
import streamingService.eccezioni.ProfiloException;
import streamingService.profilo.Profilo;
import streamingService.profilo.TipoOfferta;
import streamingService.profilo.Utente;

public class StreamingServiceMain {
    public static void main(String[] args) {
        Profilo profilo = new Profilo("pimarchetto03@gmail.com", "password", TipoOfferta.STANDARD);
        Utente utente1 = new Utente("Pietro", "avatar", false, "1234", profilo);
        Utente utente2 = new Utente("PietroKid", "avatarKid", true, "1234", profilo);
        Utente utente3 = new Utente("Pietro2", "avatar2", true, "1234", profilo);

        try {
            profilo.addUtente(utente1);
            System.out.println("streamingService.profilo.Utente 1 inserito");
            profilo.addUtente(utente2);
            System.out.println("streamingService.profilo.Utente 2 inserito");
            profilo.addUtente(utente3);
            System.out.println("streamingService.profilo.Utente 3 inserito");
        } catch(MaxUserException | HasKidException e) {
            System.out.println(e.getMessage());
        } catch(ProfiloException pe) {
            System.out.println("Eccezione specifica non riconosciuta:" + pe.getMessage());
        }

        System.out.println("Programma Terminato");
    }
}
