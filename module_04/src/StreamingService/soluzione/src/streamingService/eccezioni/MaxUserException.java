package streamingService.eccezioni;

import streamingService.profilo.TipoOfferta;

public class MaxUserException extends ProfiloException {
    public MaxUserException(TipoOfferta tipoOfferta) {
        super("Limite utenti raggiunto: " + tipoOfferta.getNumUtenti());
    }

    public MaxUserException(int numUtenti) {
        super("Limite utenti raggiunto: " + numUtenti);
    }
}
