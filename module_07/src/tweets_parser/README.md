# Esercizio Tweets parser 🛵

Scrivere un programma Java che permetta di calcolare le 10 parole più frequenti
a partire da una lista di tweet, contenuti in un file in formato csv fornito in
input. In particolare, utilizzare i dati contenuti nella colonna "content" del file fornito.

Per iniziare con un csv più semplice e non dover gestire da subito la presenza
di colonne successive a "content" e le ultime due che possono essere vuote,
utilizzate il file `realdonaldtrump_3columns.csv` 

PLUS 🏍: Eliminare ogni simbolo o numero per ottenere parole di senso compiuto 
(per esempio tramite regex, che possiamo vedere insieme!)

Suggerimento: scegliete bene la struttura dati

Per leggere un file linea per linea, potete utilizzare il seguente metodo:
```
try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    String line;
    while ((line = br.readLine()) != null) {
        // process the line.
    }
}
```
