import java.util.HashSet;

public class SerieTV extends Prodotto {

    // attributi
    private int numStagioni;
    private int epStagione;

    // costruttore
    public SerieTV(String titolo, int anno, HashSet<String> cast, Genere genere, boolean pg,
                   boolean originale, int numStagioni, int epStagione) {
        super(titolo, anno, cast, genere, pg, originale);
        this.numStagioni = numStagioni;
        this.epStagione = epStagione;
    }

    // getter e setter
    public int getNumStagioni() { return numStagioni; }
    public int getEpStagione() { return epStagione; }

    public void setNumStagioni(int numStagioni) { this.numStagioni = numStagioni; }
}
