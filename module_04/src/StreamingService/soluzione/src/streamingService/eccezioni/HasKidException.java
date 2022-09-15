package streamingService.eccezioni;
public class HasKidException extends ProfiloException {
    public HasKidException() {
        super("Il streamingService.profilo.Profilo contiene già un utente Kid");
    }
}
