public enum TipoOfferta {

    BASIC(7.50, 1), STANDARD(12, 2), PREMIUM(16, 4);

    private double prezzoOfferta;
    private int numUtenti;

    TipoOfferta(double prezzoOfferta, int numUtenti) {
        this.prezzoOfferta = prezzoOfferta;
        this.numUtenti = numUtenti;
    }

    public double getPrezzoOfferta() {
        return prezzoOfferta;
    }

    public int getNumUtenti() {
        return numUtenti;
    }
}
