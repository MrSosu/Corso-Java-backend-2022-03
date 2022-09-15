package libraryV2;

import java.util.Objects;

public class Book {
    private String code, title, synopsis;
    private int quantity;

    public Book(String code, String title, String synopsis) {
        this.code = code;
        this.title = title;
        this.synopsis = synopsis;
        this.quantity = 1;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(code, book.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return title + ": " + synopsis;
    }
}
