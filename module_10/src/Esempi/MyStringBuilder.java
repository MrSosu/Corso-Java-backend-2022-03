package Esempi;

public class MyStringBuilder {

    private String stringa = "";

    MyStringBuilder() {}

    MyStringBuilder(String stringa) { this.stringa = stringa; }

    public MyStringBuilder append(String stringa) {
        this.stringa += stringa;
        return this;
    }

    public String build() { return this.stringa; }

    @Override
    public String toString() { return this.build(); }

    public static void main(String[] args) {
        String stringa = "ciao " + "come " + "va?";

        StringBuilder sb = new StringBuilder()
            .append("ciao")
            .append(" come")
            .append(" va?");

        MyStringBuilder msb = new MyStringBuilder()
            .append("ciao")
            .append(" come")
            .append(" va?");

        System.out.println(stringa);
        System.out.println(sb.toString());
        System.out.println(msb.build());
    }
}
