package streamingService.eccezioni;

public class ProfiloException extends Exception {
    public ProfiloException(String message) {
        super("Eccezione streamingService.profilo.Profilo: " + message);
    }
}
