import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EsempiLambda {

    public static void main(String[] args) {

        ArrayList<String> parole = new ArrayList<>();
        parole.add("buongiorno");
        parole.add("java");
        parole.add("mercoledi");
        parole.add("marco");
        parole.add("AS Roma");
        parole.add("tree");
        parole.add("programming");

        /* esempio 1: utilizzando stream e lambda stampare in ordine alfabetico le parole
        lunghe più di 4 caratteri maiuscole
         */
        parole.stream().filter(s -> s.length() > 4).
                map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

        // esempio 2: salvare dentro un arrayList le stringhe che iniziano con m
        ArrayList<String> paroleM = (ArrayList<String>) parole.stream().filter(s -> s.toLowerCase().startsWith("m"))
                .collect(Collectors.toList());
        System.out.println(paroleM);

        // esempio 3: salvare dentro una variabile il numero di parole che contengono la lettera 'o'
        long x = parole.stream().map(s -> s.toLowerCase()).filter(s -> s.contains("o")).count();
        System.out.println(x);

        long y = parole.stream().filter(s -> s.toLowerCase().contains("o")).count();
        System.out.println(y);

        // esempio 4: salvare dentro un array le lunghezze di tutte le stringhe senza però ripetere valori uguali
        ArrayList<Integer> lunghezze_distinte = (ArrayList<Integer>) parole.stream().
                map(s -> s.length()).distinct().collect(Collectors.toList());

        System.out.println(lunghezze_distinte);

        // esempio 5: creare una stringa unica dove ogni stringa dell'array è concatenata separata da un trattino
        String totale = parole.stream().collect(Collectors.joining(" - "));
        System.out.println(totale);

    }

}
