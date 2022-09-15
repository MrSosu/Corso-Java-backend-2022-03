package streamingService.prodotto;

import java.util.HashSet;

public class Film extends Prodotto {

    public Film(String titolo, int anno, HashSet<String> cast, Genere genere, boolean pg, boolean originale) {
        super(titolo, anno, cast, genere, pg, originale);
    }
}
