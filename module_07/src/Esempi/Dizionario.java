package Esempi;

import java.util.*;

public class Dizionario {

    TreeMap<String, List<String>> map = new TreeMap<>();

    /**
     * Verifica che una parola sia presente nel dizionario
     */
    public boolean isPresent(String parola) {
        return this.map.containsKey(parola);
    }

    /**
     * Inserisce un significato nel dizionario
     */
    public void put(String parola, String significato) {
        List<String> significati = this.get(parola);

        if (significati != null) {
            significati.add(significato);
        }
        else {
            significati = List.of(significato);
        }

        this.put(parola, significati);
    }

    /**
     * Inserisce una lista di significati nel dizionario
     */
    public void put(String parola, List<String> significati) {
        this.map.put(parola, significati);
    }

    /**
     * Estrae i significati di una parola dal dizionario
     */
    public List<String> get(String parola) {
        return this.map.get(parola);
    }

    public static void main(String[] args) {
        Dizionario dizionario = new Dizionario();
        dizionario.put("plane", "aereoplano");
        System.out.println(dizionario.get("plane"));
        dizionario.put("plane", "piano cartesiano");
        System.out.println(dizionario.get("plane"));
        System.out.println(dizionario.isPresent("plane"));
        System.out.println(dizionario.isPresent("language"));
        dizionario.put("language", Arrays.asList("programming language", "language from a linguistic point of view"));
        System.out.println(dizionario.get("language"));
        System.out.println(dizionario.isPresent("language"));
    }

}
