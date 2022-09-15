package streamingService.prodotto;

import java.util.HashSet;

public class Documentario extends Prodotto {

    public Documentario(String titolo, int anno, HashSet<String> cast, Genere genere, boolean pg, boolean originale) {
        super(titolo, anno, cast, genere, pg, originale);
    }
}
